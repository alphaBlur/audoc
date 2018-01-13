import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HospitalPatientsService {
	public static void main(String[] args) {
		ExecutorService hospitalDesks = Executors.newFixedThreadPool(5);
		int nPatients = 50;
		while(nPatients != 0) {
			hospitalDesks.execute(new Patient());
			nPatients--;
		}
		hospitalDesks.shutdown();
		while(!hospitalDesks.isTerminated()) {
			
		}
		System.out.println("All the patients are served");
	}
}
