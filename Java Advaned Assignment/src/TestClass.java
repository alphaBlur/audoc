
public class TestClass {
	public static void main(String[] args) {
		MyArrayList<String> x1 = new MyArrayList<String>();
		x1.add("Nishant");
		x1.add("Adam");
		x1.add("Phil");
		x1.add("Zaheer");
		x1.add("Novak");
		x1.add("Pirlo");
		x1.add("Naman");
		x1.add("Gotye");
		x1.add("Naveen");
		
		for(int i=0; i<x1.size(); ++i) {
			System.out.println(x1.get(i));
		}
		
		Utility<String> ut = new Utility<String>();
		ut.sort(x1);
		
		System.out.println();
		for(int i=0; i<x1.size(); ++i) {
			System.out.println(x1.get(i));
		}
		
		
		
	}
}
