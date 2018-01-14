import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeZone {
	
	public static void main(String args[]) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		
		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		String one = df.format(date);
		System.out.println("Timestamp of India : "+one);
		
		df.setTimeZone(TimeZone.getTimeZone("Asia/Karachi"));
		String two = df.format(date);
		System.out.println("Timestamp of Pakistan : "+two);
		
		df.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		String three = df.format(date);
		System.out.println("Timestamp of Sydney :"+ three);
		
		df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		String four = df.format(date);
		System.out.println("Timestamp of USA(NY) : "+four);
		
		df.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String five = df.format(date);
		System.out.println("Timestamp of London :"+five);
		
		
		
		
		
		
		
	}

}