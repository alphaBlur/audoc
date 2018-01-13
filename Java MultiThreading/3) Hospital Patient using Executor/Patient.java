
public class Patient implements Runnable {
	static int count =0;
	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Patient " + count++ + " served");

	}

}
