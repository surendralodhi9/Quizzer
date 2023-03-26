package com.example.quizzer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.quizzer.model.Admin;
import com.example.quizzer.model.Answer;
import com.example.quizzer.model.Attempted;
import com.example.quizzer.model.Candidate;
import com.example.quizzer.model.Contest;
import com.example.quizzer.model.Question;
import com.example.quizzer.model.Registration;
import com.example.quizzer.repos.AdminRepository;

@Controller
public class HomeController {
	@Autowired
	public LoginService loginService;
	@Autowired
	public ContestService contestService;
	public SessionClass sessionObj = new SessionClass();
	@RequestMapping("/")
	public String mainPage() {
		System.out.println("Hi");
		return "home";
	}
	@RequestMapping("home")
	public String home() {
		System.out.println("Hi");
		return "home";
	}
	@RequestMapping("admin/login")
	public String adminLogin() {
		sessionObj = new SessionClass();
		System.out.println("Hi");
		return "admin";
	}
	@RequestMapping("candidate/login")
	public String candidateLogin() {
		sessionObj = new SessionClass();
		System.out.println("Hi");
		return "candidate";
	}
	@RequestMapping("admin/home")
	public ModelAndView adminHome(@RequestParam("email") String email, @RequestParam("password") String password ) {
		ModelAndView mv = new ModelAndView();
		if(email != null && password != null) {
			
			System.out.println("Email: " + email);
			System.out.println("Pasword: " + password);
			//System.out.println(loginService.getAdmin(email));
			if(loginService.isValidAdmin(email, password)) {
				Admin admin = loginService.getAdmin(email);
				mv.addObject("user", admin);
				ArrayList<Contest> contestList = new ArrayList<>();
				contestList.add(new Contest("DSA"));
				contestList.add(new Contest("CPP"));
				mv.addObject("contestList", contestList);
				mv.setViewName("admin-home");
			}
			else {
				mv.setViewName("admin");
				mv.addObject("message", "Invalid username or password");
			}
		}
		return mv;
	}
	@RequestMapping("candidate/home")
	public ModelAndView candidateHome(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		if(email != null && password != null) {
			
			System.out.println("Email: " + email);
			System.out.println("Pasword: " + password);
			if(loginService.isValidCandidate(email, password)) {
				Candidate candidate = loginService.getCandidate(email);
				mv.addObject("user", candidate);
				mv.setViewName("candidate-home");
				sessionObj.setCandidate(candidate);
				if(sessionObj.getContest() != null) {
					return contestHome(sessionObj.getContest().getName());
				}
				return contestHistory();
			}
		}
		mv.setViewName("candidate");
		return mv;
	}
	@RequestMapping(value = "candidate/signup")
	public String candidateSignup() {
		return "signup";	
	}
	@RequestMapping(value = "candidate/signup-complete")
	public ModelAndView candidateSignupComplete(@RequestParam("username") String userName, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("confirm_password") String confirmPassword) {
		ModelAndView mv = new ModelAndView();
		if(!password.equalsIgnoreCase(confirmPassword)) {
			System.out.println("Password mismatched");
			mv.setViewName("signup");
			mv.addObject("message","Password mismatched");
			return mv;
		}
		Candidate candidate = new Candidate(userName, email, password);
		loginService.addNewCandidate(candidate);
		mv.setViewName("candidate-home");
		return mv;	
	}	
	@RequestMapping(value = "admin")
	public String onAdminPage(Admin admin) {
		String email = admin.email;
		String password = admin.password;
		if(email != null && password != null) {
			
			System.out.println("Email: " + email);
			System.out.println("Pasword: " + password);
			if(email.equalsIgnoreCase("surendra@gmail.com") && password.equalsIgnoreCase("1234")) {
				return "candidate";
			}
		}
		return "admin";
	}
	@RequestMapping("adminlogin")
	public String onAdminLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("Email: " + email);
		System.out.println("Pasword: " + password);
		if(email.equalsIgnoreCase("surendra@gmail.com") && password.equalsIgnoreCase("1234")) {
			return "candidate";
		}
		return "admin";
	}
	@RequestMapping("candidate")
	public String onCandidateLogin() {
		return "candidate";
	}
	@RequestMapping("signup")
	public String candidateSignUP() {
		return "signup";
	}
	
	@RequestMapping("admin/createContest")
	public ModelAndView onCreateContestPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("create-contest");
		return mv;
	}
	@RequestMapping("admin/createNewContest")
	public ModelAndView createNewContest(@RequestParam("contestName") String contestName) {
		ModelAndView mv = new ModelAndView();
		if(contestName != null && contestService.isNewContest(contestName)) {

			mv = getContestHistory();
			return mv;
		}
		mv.setViewName("create-contest");
		mv.addObject("message", "contest "  + contestName +" Already exist, please try new name!!!");
		return mv;
	}
	@RequestMapping("admin/contestHistory")
	public ModelAndView getContestHistory() {
		
		ModelAndView mv = new ModelAndView();
		ArrayList<Contest> contestList = new ArrayList<>();
		contestList = contestService.getAllContest();
		mv.addObject("contestList", contestList);
		mv.setViewName("contest-history");
		return mv;
	}
	@RequestMapping("admin/editContest")
	public ModelAndView editContest(@RequestParam("contestName") String contestName) {
		ModelAndView mv = new ModelAndView();
		Contest contest = contestService.getContest(contestName);
		mv.addObject("contest", contest);
		mv.setViewName("edit-contest");
		return mv;
	}
	@RequestMapping("admin/updateContest")
	public ModelAndView updateContest(Contest contest) {

		
		contestService.updateAndSaveContest(contest);
		return getContestHistory();
	}
	
	@RequestMapping("admin/addQuestions")
	public ModelAndView addQuestions(@RequestParam("contestName") String contestName) {
		ModelAndView mv = new ModelAndView();
		Contest contest = contestService.getContest(contestName);
		mv.addObject("contest", contest);
		mv.setViewName("add-questions");
		return mv;
	}
	//admin/deleteQuestion?questionId=3
	@RequestMapping("admin/deleteQuestion")
	public ModelAndView deleteQuestion(@RequestParam("questionId") int questionId) {
		
		int contestId = contestService.deleteQuestionById(questionId);
		return displayAllQuestions(contestId);
	}
	@RequestMapping("admin/editQuestion")
    public ModelAndView editQuestion(@RequestParam("questionId") int questionId) {
		ModelAndView mv = addAnswers(questionId);
		mv.setViewName("edit-question");
    	return mv;
    }
	@RequestMapping("admin/saveAndDisplayQuestion")
	public ModelAndView addQuestions(Question question) {
		contestService.addNewQuestion(question);
		Contest contest = contestService.getContest(question.contestId);
		contest.setNoques(contest.getNoques() + 1);
		contestService.updateAndSaveContest(contest);
		return displayAllQuestions(question.contestId);
	}
	@RequestMapping("admin/displayAllQuestions")
	public ModelAndView displayAllQuestions(int contestId) {
		ModelAndView mv = new ModelAndView();
		Contest contest = contestService.getContest(contestId);
		mv.addObject("contest", contest);
		ArrayList<Question> questionsList = new ArrayList<>();
		questionsList = contestService.getAllQuestionsByContestId(contest.id);
		mv.addObject("questionsList", questionsList);
		mv.setViewName("display-questions");
		return mv;
	}
	@RequestMapping("admin/addAnswers")
	public ModelAndView addAnswers(@RequestParam("questionId") int questionId) {
		ModelAndView mv = new ModelAndView();
		Question question = contestService.getQuestionById(questionId);
		ArrayList<Answer> answersList = contestService.getAllAnswersByQuestionId(questionId);
		mv.addObject("question", question);
		mv.addObject("answersList", answersList);
		mv.setViewName("add-answers");
		return mv;
	}
	@RequestMapping("admin/saveAnswers")
	public ModelAndView saveAnswers(@RequestParam("questionId") int questionId, @RequestParam("content") String content) {
		contestService.addNewAnswer(new Answer(questionId, content));
		return addAnswers(questionId);
	}
	@RequestMapping("admin/deleteAnswer")
	public ModelAndView deleteAnswer(@RequestParam("answerId") int answerId) {
		int questionId = contestService.getQuestionIdByAnswerId(answerId);
		contestService.deleteAnswerById(answerId);
		return addAnswers(questionId);
		
	}
	//admin/makeAnswer?questionId=152 & answerId=53
	@RequestMapping("admin/makeAnswer")
	public ModelAndView makeAsAnswer(@RequestParam("questionId") int questionId, @RequestParam("answerId") int answerId) {
		Question question = contestService.getQuestionById(questionId);
		question.setAnswerId(answerId);
		contestService.addNewQuestion(question);
		return displayAllQuestions(question.contestId);
	}
	//admin/makeAnswer?questionId=152 & answerId=53
	@RequestMapping("candidate/contest/{contestName}")
	public ModelAndView contestHome(@PathVariable("contestName")  String contestName) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Contest-Home");
		Contest contest = contestService.getContest(contestName);
		if(contest == null) {
			mv.setViewName("not-found");
			return mv;
		}
		sessionObj.setContest(contest);
		sessionObj.setDuration(contest.getDuration());
		if(sessionObj.getCandidate() == null) {
			mv.setViewName(candidateLogin());
			return mv;
		}
		Registration register = contestService.getRegistration(sessionObj.getCandidate().getEmail(), contestName);
		if(register == null) {
			mv.addObject("button", "Register");
		}
		else {
			mv.addObject("button", "Start");
			mv.addObject("register", register);
		}
		mv.addObject("contest", contest);
		mv.addObject("candidate", sessionObj.getCandidate());
		mv.setViewName("contest-home");
		return mv;
	}
	//candidate/contest/register
	@RequestMapping("candidate/contest/register")
	public ModelAndView registerForContest(@RequestParam("contestName")String contestName) {
		if(sessionObj.getCandidate() != null) {
			Registration register = new Registration();
			register.email = sessionObj.getCandidate().getEmail();
			register.contestName = contestName;
			contestService.registerForContest(register);
			System.out.println("inside not null");
		}
		System.out.println("calling register");
		return contestHome(contestName);
	}
	@RequestMapping("candidate/contest/start")
	public ModelAndView startContest(@RequestParam("contestName")String contestName) {
		sessionObj.setQuestionsList(contestService.getAllQuestionsByContestId(sessionObj.getContest().getId()));
		sessionObj.setStartTime(HelperUtility.getTimestamp());
		return runContest(contestName, 0, "0", "", Integer.toString(sessionObj.getDuration()));
	}
	
	@RequestMapping("candidate/contest/history")
	public ModelAndView contestHistory() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Registration> registerList = contestService.getAllContestByEmail(sessionObj.getCandidate().getEmail()); 
		mv.addObject("registerList", registerList);
		mv.addObject("candidate", sessionObj.getCandidate());
		mv.setViewName("candidate-contests");
		return mv;
	}
	//candidate/contest/start/Quiz-2/questionNo=1
	@RequestMapping("candidate/contest/start/{contestName}")
	public ModelAndView runContest(@PathVariable("contestName")  String contestName,
			                         @RequestParam("questionNo") int questionNo,
			                         @RequestParam("selectedAnswer") String selectedAnswer,
			                         @RequestParam("buttonId") String buttonId,
			                         @RequestParam("duration") String duration) {
		System.out.println("QuestionNo: " + questionNo);
		System.out.println("Answer: " + selectedAnswer);
		System.out.println("Button: " + buttonId);
		System.out.println("Duration: "+duration);
		
		
		Question question = sessionObj.getQuestionsList().get(questionNo);
		
		int answerId = parseAnswerIntoInteger(selectedAnswer);
		System.out.println(answerId);
		if(answerId != 0) {
			Attempted attempted = contestService.getAttemptByContestEmailQuestionId(sessionObj.getContest().name, 
                    sessionObj.getCandidate().email, question.id);
			if(attempted != null) {
				attempted.setAnswerId(answerId);
			}
			else {
			    attempted = new Attempted(sessionObj.getContest().name, sessionObj.getCandidate().email, question.id, answerId);
			}
			contestService.addNewAttempt(attempted);
		}
		
		if(buttonId.equalsIgnoreCase("Next")) {
			questionNo++;
		}
		else if(buttonId.equalsIgnoreCase("Previous")) {
			questionNo--;
		}
		ModelAndView mv = new ModelAndView();
		if(sessionObj.getContest() == null) {
			System.out.println("contest is null"+contestName);
			return contestHome(contestName);
		}
		if(sessionObj.getQuestionsList() == null) {
			System.out.println("question list is null"+contestName);
			return contestHome(contestName);
		}
	
		if(sessionObj.getQuestionsList().size() <= questionNo) {
			System.out.println("question list is null"+contestName);
			questionNo = 0;
		}
		else if(questionNo < 0) {
			System.out.println("New question: "+ questionNo);
			questionNo = 0;
		}
		System.out.println("New question: "+ questionNo);
		question = sessionObj.getQuestionsList().get(questionNo); 
		ArrayList<Answer> answersList = contestService.getAllAnswersByQuestionId(question.getId());
		Attempted attempted = contestService.getAttemptByContestEmailQuestionId(sessionObj.getContest().name, 
				                              sessionObj.getCandidate().email, question.id);
		if(attempted != null) {
			answerId = attempted.answerId;
		}
		System.out.println("Start: "+ sessionObj.getStartTime());
		System.out.println("Current: "+ HelperUtility.getTimestamp());
		
		long used = HelperUtility.getTimeDiff(sessionObj.startTime, HelperUtility.getTimestamp());
		System.out.println("Used: " +used);
		long remaingTime = sessionObj.getDuration() * 1000;
		System.out.println("Total: " + remaingTime);
		remaingTime -= used;
		System.out.println("Remaining: " + remaingTime);
		remaingTime /= (1000);
		System.out.println("Remaining: " + remaingTime);
		if(remaingTime < 0) {
			remaingTime = 1;
			return submitTheContest(contestName);
			
		}
		duration = Long.toString(remaingTime);
		System.out.println("Remaining: D " + duration);
		mv.addObject("questionNo", questionNo);
		mv.addObject("contest", sessionObj.getContest());
		mv.addObject("question", question);
		mv.addObject("answersList", answersList);
		mv.addObject("selectedAnswer", answerId);
		mv.addObject("candidate", sessionObj.getCandidate());
		mv.addObject("duration", duration);
		mv.setViewName("contest-start");
		
		return mv;
	}
	private int parseAnswerIntoInteger(String selectedAnswer) {
		// TODO Auto-generated method stub
		
		String tempAnswer = "";
		for(int i = 0; i < selectedAnswer.length(); ++i) {
			if(selectedAnswer.charAt(i) == ',') {
				tempAnswer = "";
			}
			else {
				tempAnswer = tempAnswer + Character.toString(selectedAnswer.charAt(i));
			}
		}
		if(!tempAnswer.isEmpty()) {
			return Integer.parseInt(tempAnswer);
		}
		return 0;
	}
	@RequestMapping("candidate/contest/{contestName}/submitted")
	public ModelAndView submitTheContest(@PathVariable("contestName") String contestName) {
		
		ArrayList<Question> questionList = sessionObj.getQuestionsList();
		int finalScore = 0;
		for(Question question:questionList) {
			Attempted  attempted = contestService.getAttemptByContestEmailQuestionId(sessionObj.getContest().name, 
                                                  sessionObj.getCandidate().email, question.id);
            if(attempted != null) {
			   if(attempted.answerId == question.answerId) {
				  finalScore += question.maxScore;
			   }
			   else {
				  finalScore += question.minScore;
			   }
           }
		}
		Registration registration = contestService.getRegistration(sessionObj.getCandidate().email, sessionObj.getContest().name);
		registration.setScore(finalScore);
		String completionTime = HelperUtility.getCurrentTimeStamp();
		completionTime = HelperUtility.getDateDiff(sessionObj.getContest().dop, completionTime);
		registration.setCompletionTime(completionTime);
		contestService.registerForContest(registration);
		return showLeaderboard(contestName);
	}
	@RequestMapping("candidate/contest/{contestName}/leaderboard")
	public ModelAndView showLeaderboard(@PathVariable("contestName") String contestName) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Registration> resultList = contestService.getAllRegistrationByContestName(contestName);
		Collections.sort(resultList, new SortLeaderboard());
		mv.addObject("contestName", contestName);
		mv.addObject("resultList", resultList);
		mv.addObject("rank", 1);
		mv.setViewName("leaderboard");
		return mv;
	}
	public class SortLeaderboard implements Comparator<Registration>{
		public int compare(Registration a, Registration b) {
			if(a.getScore() < b.getScore()) {
				return 1;
			}
			if(a.getScore() > b.getScore()) {
				return -1;
			}
			long aTime = 0;
			long bTime = 0;
			try {
				Date aDate = new SimpleDateFormat("HH:mm:ss").parse(a.getCompletionTime());  
				aTime = aDate.getTime();
				Date bDate = new SimpleDateFormat("HH:mm:ss").parse(b.getCompletionTime());  
				bTime = bDate.getTime();
			}
			catch(Exception e) {
				
			}
			return (int) (aTime - bTime);
		}
	}
}
