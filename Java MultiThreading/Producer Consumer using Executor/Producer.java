package producer.consumer.pool;

import java.util.Random;

public class Producer extends Thread{
	Inventory inven;
	
	public Producer(Inventory i, String name) {
		super(name);
        this.inven = i;
    }
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void produce() throws InterruptedException{
		while(true) {
			synchronized(inven) {
				while(inven.buffer.size() == inven.capacity){
					inven.wait();
					
				}
				Thread.sleep(500);
				Random ran = new Random();
				int val = ran.nextInt(100);
				inven.buffer.add(val);
				System.out.print("\n\n" + Thread.currentThread().getName() + " Produced:" + val + "\nInventory:");
				for(Integer e: inven.buffer) {
					System.out.print(e.intValue() + " ");
				}
				inven.notifyAll();
			}
		}
	}
}
