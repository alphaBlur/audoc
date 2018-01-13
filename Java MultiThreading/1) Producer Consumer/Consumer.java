package producer.consumer;

public class Consumer extends Thread{
	Inventory inven;
	int serveTime;
	public Consumer(int p, Inventory i, String name) {
		super(name);
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
				System.out.print("\n\n" + Thread.currentThread().getName() + " Consumed:" + inven.buffer.get(0) + "\nInventory:");
				inven.buffer.remove(0);
				serveTime--;
				for(Integer e: inven.buffer) {
					System.out.print(e.intValue() + " ");
				}
				inven.notifyAll();
			}
		}
		if(serveTime == 0)
			System.out.println("\n*********" +Thread.currentThread().getName() + " is served*********");
	}
}