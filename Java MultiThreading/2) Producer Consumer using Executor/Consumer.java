package producer.consumer.pool;

public class Consumer implements Runnable{
	Inventory inven;
	int serveTime;
	static int name = 0;
	public Consumer(int p, Inventory i) {
		serveTime=p;
        this.inven = i;
    }
	
	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void consume() throws InterruptedException {
		while(serveTime>0) {
			synchronized(inven) {
				while(inven.buffer.size() == 0){
					inven.wait();
				}
				Thread.sleep(500);
				System.out.print("\n\n" +  " Consumed:" + inven.buffer.get(0) + " at:" + Thread.currentThread().getName() + "\nInventory:");
				inven.buffer.remove(0);
				serveTime--;
				for(Integer e: inven.buffer) {
					System.out.print(e.intValue() + " ");
				}
				inven.notifyAll();
			}
		}
		if(serveTime == 0)
			System.out.println("\nConsumer" + name++ + " served at " + Thread.currentThread().getName());
	}
}