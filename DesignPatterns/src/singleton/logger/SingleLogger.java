package singleton.logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SingleLogger implements SingletonInter{
	
	private volatile static SingleLogger obj;
	private static List<String> logBook;
	private SingleLogger() {
		logBook = new ArrayList<String>();
	}
	
	public static SingleLogger getInstance() {
		if(obj==null) {
			synchronized(SingleLogger.class) {
				if(obj==null)
					obj=new SingleLogger();
			}
		}
		return obj;
	}
	
	public void showLogs(){
		for(String log: logBook) {
			System.out.println(log);
		}
	}
	
	@Override
	public void log(String logMessageItem) {
		String logMessage = logMessageItem + " logged at " + new Date().toString();
		logBook.add(logMessage);
	}

}
