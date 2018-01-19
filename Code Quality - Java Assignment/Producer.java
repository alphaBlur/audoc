package producer.consumer;

import java.util.Random;
import java.util.logging.Logger;

public class Producer extends Thread{
	Inventory inven;
	private static final Logger LOG = Logger.getLogger(Producer.class.getName());
	public Producer(Inventory i, String name) {
		super(name);
        this.inven = i;
    }
	@Override
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();

		}
	}
	public void produce() throws InterruptedException{
		while(true) {
			synchronized(inven) {
				while(inven.buffer.size() == inven.getCapacity()){
					inven.wait();
					
				}
				
				Random ran = new Random();
				int val = ran.nextInt(100);
				inven.buffer.add(val);
				String print = Thread.currentThread().getName() + " Produced:" + val + "\nInventory:";
				LOG.info(print);
				for(Integer e: inven.buffer) {
					String print1 = e.intValue() + " ";
					LOG.info(print1);
				}
				inven.notifyAll();
			}
		}
	}
}
