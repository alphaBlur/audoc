/*
A simple multi-threading program simulating the producer-consumer problem.
5 producers are serving 5 customers. After 3 min the program closes itself.
Author - Nishant Kaushik
*/
package producer.consumer;

public class FlipkartService {
	
	public static void main(String[] args) throws InterruptedException {
		Inventory inven1 = new Inventory(10);
		
		//All five producer will produce until all the consumers are served 
		Producer p1 = new Producer(inven1,"Producer1");
		Producer p2 = new Producer(inven1,"Producer2");
		Producer p3 = new Producer(inven1,"Producer3");
		Producer p4 = new Producer(inven1,"Producer4");
		Producer p5 = new Producer(inven1,"Producer5");
		
		//Each consumer will be served 3 times before terminating
		Consumer c1= new Consumer(3,inven1,"Consumer1");
		Consumer c2= new Consumer(3,inven1,"Consumer2");
		Consumer c3= new Consumer(3,inven1,"Consumer3");
		Consumer c4= new Consumer(3,inven1,"Consumer4");
		Consumer c5= new Consumer(3,inven1,"Consumer5");
		
		//All threads start to mingle
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		
		//Stop all threads after 3mins
		Thread.sleep(180000);
		p1.interrupt();
		p2.interrupt();
		p3.interrupt();
		p4.interrupt();
		p5.interrupt();
		c1.interrupt();
		c2.interrupt();
		c3.interrupt();
		c4.interrupt();
		c5.interrupt();
		
	}
}
