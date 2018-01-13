		import java.util.HashMap;
		import java.util.Iterator;
		import java.util.LinkedList;
		import java.util.Map;
		
		@SuppressWarnings("serial")
		public class MyLinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>{
				
			LinkedList<KeyValue<K,V>> l;
			
			public MyLinkedHashMap() {
				l = new LinkedList<KeyValue<K,V>>();		
			}
			
			public V getValue(K k) {
				return super.get(k);
			}
			
			public V putEntry(K k, V v) {
				if(super.containsKey(k)!=true) {			
					l.add(new KeyValue<K, V>(k,v));
				}
				else {
					Iterator<KeyValue<K, V>> it = l.iterator();
					while(it.hasNext()) {
						KeyValue<K, V> kv = (KeyValue<K, V>) it.next();
						if(kv.equals(new KeyValue<K, V>(k,v))) {
							kv.setV(v);
						}
					}
				}				
				return super.put(k, v);
			}
			
			public void display() {
				Iterator<KeyValue<K, V>> it = l.iterator();
				while(it.hasNext()) {
					System.out.println(it.next().toString());			
				}		
			}
			
			public String removeEntry(K key) {
				if(super.containsKey(key)) {
					Iterator<KeyValue<K, V>> it = l.iterator();
					while(it.hasNext()) {
						KeyValue<K, V> kv = (KeyValue<K, V>) it.next();
						if(kv.equals(new KeyValue<K, V>(key,super.get(key)))) {
							it.remove();
						}
					}			
				}
				super.remove(key);
				return null;
			}
			
			public static void main(String[] args) {
				MyLinkedHashMap<Integer,String> obj = new MyLinkedHashMap<Integer,String>();
				obj.putEntry(2, "two");
				obj.putEntry(3, "three");
				obj.putEntry(1, "one");
				obj.putEntry(4, "four");
				
				obj.display();
				
				
				
				System.out.println(obj.getValue(3));
				
				obj.putEntry(2, "TWO");
				
				obj.display();
				
				System.out.println(obj.getValue(2));
				System.out.println(obj.getValue(1));
				
				obj.removeEntry(2);
				
				obj.display();
				
				
			}
			
			static class KeyValue<K,V>{
				K k;
				V v;
				
				public KeyValue(K k, V v) {
					this.k = k;
					this.v = v;			
				}
				public void setV(V v2) {
					this.v = v2;
				}
				K getKey() {
					return this.k;
				}
		
				public boolean equals(KeyValue<K, V> kv) {
					if(kv.getKey() == this.k)
						return true;
					else
						return false;
				}
				
				@Override
				public String toString() {
					System.out.println("Key: "+this.k+" Value v: "+ this.v);
					return "";
				}
			}
		}
