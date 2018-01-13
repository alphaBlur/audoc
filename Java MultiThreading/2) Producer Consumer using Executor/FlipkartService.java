package producer.consumer.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlipkartService {
	
	public static void main(String[] args) throws InterruptedException {
		Inventory inven1 = new Inventory(10);
		Producer p1 = new Producer(inven1,"Producer1");
		Producer p2 = new Producer(inven1,"Producer2");
		Producer p3 = new Producer(inven1,"Producer3");
		
		p1.start();
		p2.start();
		p3.start();
		
		//20 consumers getting served in pool of 3 threads		
		ExecutorService consE = Executors.newFixedThreadPool(3);
		
		//Hence totally 6 threads and 1 main threads are used for any num of customers
		for(int i=0; i<10; ++i) {
			//Each consumer will be served 1 time (1st argument)
			consE.execute(new Consumer(1,inven1));
		}		
	}
}
