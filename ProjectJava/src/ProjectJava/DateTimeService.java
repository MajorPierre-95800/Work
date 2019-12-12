package ProjectJava;

import java.util.Calendar;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DateTimeService
{
   private Calendar calendar;

   public DateTimeService()
   {
	 this.calendar = Calendar.getInstance();
   }

   public String[] getDateAndTime()
   {
	  Date d = this.calendar.getTime();
	  String[] temp = new String [2];
	  BufferedReader file1 = null;
	  FileReader file2 = null;
	  try 
	  {
	      file2 = new FileReader("/sys/class/thermal/thermal_zone0/temp");
	      file1 = new BufferedReader(file2);
	  while ((temp[0] = file1.readLine()) != null) 
	  {
	        System.out.println(temp[0]);
	  }
	  } 
	  catch (IOException e) 
	  {
	        e.printStackTrace();
	  } 
	  	System.out.println(temp[0]);
	    temp[1] = d.toString();
     
	    return temp;
   }	
}