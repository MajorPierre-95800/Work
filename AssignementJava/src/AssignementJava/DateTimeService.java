package AssignementJava;

import java.util.Calendar;
import java.util.Date;

public class DateTimeService
{
   private Calendar calendar;

   public DateTimeService()
   {
         this.calendar = Calendar.getInstance();
   }


   public String getDateAndTime()
   {
         Date d = this.calendar.getTime();
         return "The Raspberry time is: " + d.toString();        
   }        
}
