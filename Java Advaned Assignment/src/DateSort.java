import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DateSort {
	
	
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	public static void main(String[] args) {
        
		List<Date> myList = new ArrayList<>();
		myList.add(parseDate("2014-06-14"));
		myList.add(parseDate("2015-05-15"));
		myList.add(parseDate("2016-04-16"));
		myList.add(parseDate("2017-03-17"));
		myList.add(parseDate("2018-02-18"));

         
        Collections.sort(myList, new Comparator<Date>(){
 
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
         
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i).toString());
        }
 
    }

}