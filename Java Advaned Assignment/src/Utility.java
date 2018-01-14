public class Utility<T extends Comparable<? super T>> {
	
	public void sort(MyArrayList<T> s) {
		for (int i = 0; i<s.size()-1; i++) {
			int small = i;
			for(int j=i+1; j< s.size(); j++) {
				if (s.get(j).compareTo(s.get(small))<=0) {
                  small=j;
              }
			}
			s.swap(i, small);
        }
	}
}