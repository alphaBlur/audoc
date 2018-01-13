package producer.consumer;

import java.util.ArrayList;

public class Inventory {
	public int capacity=10;
	ArrayList<Integer> buffer;	
	public Inventory(int c) {
		//this.capacity = c;
		buffer= new ArrayList<Integer>(capacity);
	}

}
