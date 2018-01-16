package templatePattern.designHouse;

public class Client {
	public static void main(String[] args) {
		
		HomeDesigner hutHouse = new HutHouse();
		hutHouse.buildHouse();
		
		System.out.println("\n\n");
		
		HomeDesigner concreteHouse = new HutHouse();
		concreteHouse.buildHouse();
	}
}
