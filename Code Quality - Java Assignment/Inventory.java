package producer.consumer;

import java.util.ArrayList;

public class Inventory {
	private int capacity=10;
	ArrayList<Integer> buffer;	
	public Inventory(int c) {
		this.capacity = c;
		buffer= new ArrayList<>(capacity);
	}
	public Inventory() {
		buffer= new ArrayList<>(capacity);
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int c) {
		this.capacity = c;
	}

}
