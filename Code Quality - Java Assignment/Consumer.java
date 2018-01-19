package producer.consumer;

import java.util.logging.Logger;

public class Consumer extends Thread{
	Inventory inven;
	int serveTime;
	private static final Logger LOG = Logger.getLogger(Producer.class.getName());
	public Consumer(int p, Inventory i, String name) {
		super(name);
		serveTime=p;
        this.inven = i;
    }
	@Override
	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	public void consume() throws InterruptedException {
		while(serveTime>0) {
			synchronized(inven) {
				while(inven.buffer.isEmpty()){
					inven.wait();
				}
				
				String print1 = Thread.currentThread().getName() + " Consumed:" + inven.buffer.get(0).toString() + "Inventory:";
				LOG.info(print1);
				inven.buffer.remove(0);
				serveTime--;
				for(Integer e: inven.buffer) {
					String print2 = e.intValue() + " ";
					LOG.info(print2);
				}
				inven.notifyAll();
			}
		}
		if(serveTime == 0) {
			String print3 ="\n*********\n" + Thread.currentThread().getName() + " is served*********";
			LOG.info(print3);
		}
	}
}