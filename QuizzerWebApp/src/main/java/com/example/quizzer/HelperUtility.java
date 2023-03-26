package com.example.quizzer;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperUtility {
	
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = new Date();  
	    return formatter.format(date);
	}
	public static String getTimestamp() {
	    // 2021-03-24 16:48:05
	    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	        // method 1
	        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        //System.out.println(timestamp);                      // 2021-03-24 16:34:26.666
	        return sdf3.format(timestamp); 
	        // 2021-03-24 16:48:05

	}
	
	public static  long getTimeDiff(String start_date, String end_date)   
	{   
	    SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    // In the try block, we will try to find the difference  
	    try {   
	        // Use parse method to get date object of both dates  
	        Date date1 = obj.parse(start_date);   
	        Date date2 = obj.parse(end_date);   
	        // Calucalte time difference in milliseconds   
	        long time_difference = date2.getTime() - date1.getTime();  
	        // Calucalte time difference in days  
	        
	        return time_difference;
	    }   
	    // Catch parse exception   
	    catch (ParseException excep) {   
	        excep.printStackTrace();   
	    }
	    return 0;
	}   

	public static  String getDateDiff(String start_date, String end_date)   
    {   
        // Create an instance of the SimpleDateFormat class
		start_date = start_date.replace('T', ' ');
		end_date = end_date.replace('T', ' ');
        SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
        // In the try block, we will try to find the difference  
        try {   
            // Use parse method to get date object of both dates  
            Date date1 = obj.parse(start_date);   
            Date date2 = obj.parse(end_date);   
            // Calucalte time difference in milliseconds   
            long time_difference = date2.getTime() - date1.getTime();  
            // Calucalte time difference in days  
            long days_difference = (time_difference / (1000*60*60*24)) % 365;   
            // Calucalte time difference in years  
            long years_difference = (time_difference / (1000l*60*60*24*365));   
            // Calucalte time difference in seconds  
            long seconds_difference = (time_difference / 1000)% 60;   
            // Calucalte time difference in minutes  
            long minutes_difference = (time_difference / (1000*60)) % 60;   
              
            // Calucalte time difference in hours  
            long hours_difference = (time_difference / (1000*60*60)) % 24;   
            // Show difference in years, in days, hours, minutes, and seconds   
            /*System.out.print(   
                "Difference "  
                + "between two dates is: ");   
            System.out.println(   
                hours_difference   
                + " hours, "  
                + minutes_difference   
                + " minutes, "  
                + seconds_difference   
                + " seconds, "  
                + years_difference   
                + " years, "  
                + days_difference   
                + " days"  
                );*/ 
            String hours_T = Long.toString(hours_difference);
            String minutes_T = Long.toString(minutes_difference);
            String seconds_T = Long.toString(seconds_difference);
            if(hours_difference < 10) {
            	hours_T = "0" + hours_T;
            }
            if(minutes_difference < 10) {
            	minutes_T = "0" + minutes_T;
            }
            if(seconds_difference < 10) {
            	seconds_T = "0" + seconds_T;
            }
            return hours_T + ":" + minutes_T + ":" + seconds_T;
        }   
        // Catch parse exception   
        catch (ParseException excep) {   
            excep.printStackTrace();   
        }
        return "00:00:00";
    }   

}
