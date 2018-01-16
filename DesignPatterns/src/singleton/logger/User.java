package singleton.logger;

public class User{
	public static void main(String[] args) throws InterruptedException {
		SingleLogger singleLogger = SingleLogger.getInstance();
		singleLogger.log("Ishant");
		//Thread.sleep(2400);
		singleLogger.log("Amit");
		//Thread.sleep(3400);
		singleLogger.log("Abhishek");
		//Thread.sleep(1400);
		singleLogger.log("Nishant");
		singleLogger.showLogs();
		
	}
}
