import java.util.Arrays;

public class MyArrayList<T> {
	
	private T obj[];
	private int s=0;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		obj = (T[]) new Object[1];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int q) {
		obj = (T[]) new Object[q];
	}
	public void add(T x) {
		if(obj.length-s < 1) {
			obj = Arrays.copyOf(obj, obj.length*2);
		}
		obj[s++]=x;	
	}
	public T remove(int x) {
		if(x>s) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T o = obj[x];
		int t=x;
		while(t != s-1) {
			obj[t]=obj[t+1];
			obj[t+1]=null;
			t++;
		}
		s--;
		return o;
	}
	public T get(int x) {
		if(x>s) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return obj[x];
	}
	public int size() {
		return s;
	}
	public void swap(int i, int j) {
		T te = obj[i];
		obj[i]=null;
		obj[i]=obj[j];
		obj[j]=null;
		obj[j]=te;
		
	}
}
