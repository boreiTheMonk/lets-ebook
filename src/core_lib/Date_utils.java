package core_lib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date_utils {

	   private DateFormat df;
	   
	   
	   
       public Date_utils() {
		super();
		 df = new SimpleDateFormat("yyyy-MM-dd");
       }
       
       public Date_utils(String pattern) {
   		super();
   	    df = new SimpleDateFormat(pattern);
          }
       
	public Date[] getWeekInterval(Calendar cal)
       {
          // find start of week

          Calendar start = Calendar.getInstance();
          start.setTime(cal.getTime());
          start.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));

          // find end of week

          Calendar end = Calendar.getInstance();
          end.setTime(cal.getTime());
          end.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));

          // format start and end date and return

          return new Date[] { start.getTime(), end.getTime() };
     }
      public Date[] getLastWeekInterval(Calendar cal)
       {
          // find start of week

          Calendar start = Calendar.getInstance();
          start.setTime(cal.getTime());
          start.roll(Calendar.WEEK_OF_YEAR, false);
          start.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));

          // find end of week

          Calendar end = Calendar.getInstance();
          end.setTime(cal.getTime());
          end.roll(Calendar.WEEK_OF_MONTH, false);
          end.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));

          // format start and end date and return

          return new Date[] { start.getTime(), end.getTime() };
     }
      
      public Date getYesterday(Calendar cal)
      {
         // find yesterday

         Calendar start = Calendar.getInstance();
         start.setTime(cal.getTime());
         start.roll(Calendar.DAY_OF_YEAR, false);
        // start.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));

        
         // format start and end date and return

         return start.getTime();
    }
       
       public Date[] getMonthInterval(Calendar cal)
       {
          // find start of week

          Calendar start = Calendar.getInstance();
          start.setTime(cal.getTime());
          start.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));

          // find end of week

          Calendar end = Calendar.getInstance();
          end.setTime(cal.getTime());
          end.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

          // format start and end date and return

          return new Date[] { start.getTime(), end.getTime() };
     }
       
       public static void main(String[] arg0){
    	   
    	   Date_utils d = new Date_utils();
    	   Calendar c = Calendar.getInstance();
    	   c.setTime(new Date());
    	   System.out.println(d.getWeekInterval(c)[0]);
    	   System.out.println(d.getMonthInterval(c)[0]);
    	   System.out.println(d.getLastWeekInterval(c)[0]);
    	   System.out.println(d.getYesterday(c));
    	   
       }
	
}
