import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<40; ++i) {
			list.add(new Random().nextInt(1000));
		}
		
		for(int i=0; i<40; ++i) {
			System.out.println(list.get(i));
		}
		List<Integer> newlist = list.stream().filter( li -> li%5 == 0).collect(Collectors.toList());
		for(Integer i: newlist) {
			System.out.println(ConvertToString(i.intValue()));
		}
	}
	
	
	
	
	
	
	
	private static final String[] tensNames = {
		    "",
		    " ten",
		    " twenty",
		    " thirty",
		    " forty",
		    " fifty",
		    " sixty",
		    " seventy",
		    " eighty",
		    " ninety"
		  };

		  private static final String[] numNames = {
		    "",
		    " one",
		    " two",
		    " three",
		    " four",
		    " five",
		    " six",
		    " seven",
		    " eight",
		    " nine",
		    " ten",
		    " eleven",
		    " twelve",
		    " thirteen",
		    " fourteen",
		    " fifteen",
		    " sixteen",
		    " seventeen",
		    " eighteen",
		    " nineteen"
		  };

		  //private EnglishNumberToWords() {}

		  private static String ConvertToString(int number) {
		    String soFar;

		    if (number % 100 < 20){
		      soFar = numNames[number % 100];
		      number /= 100;
		    }
		    else {
		      soFar = numNames[number % 10];
		      number /= 10;

		      soFar = tensNames[number % 10] + soFar;
		      number /= 10;
		    }
		    if (number == 0) return soFar;
		    return numNames[number] + " hundred" + soFar;
		  }
}