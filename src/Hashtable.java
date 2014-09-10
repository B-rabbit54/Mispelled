

import java.util.Iterator;


public class Hashtable<K, V> {
	private Entry<K,V>[] values;
	private int size;
	
	public Hashtable(int initialCapacity) {
		values = (Entry<K,V>[])new Entry[initialCapacity];
	}
	
	/**
	 * #3b. Implement this (1 point)
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		
		int hash = key.hashCode();
		
		if(values[hash] == null)
		{
			values[hash] = new Entry(key, value);
			size++;
		}
		else 
		{
			Entry<K,V> current = values[hash];
			Entry<K,V> previous = null;
			while(current != null && !current.key.equals(key))
			{
				previous = current;
				current = current.next;
				
			}
			previous.next = new Entry(key, value);
			
//			for(int i = 0; i < values.length; i++)
//			{
//				if(values[i].key.equals(key))
//				{
//					values[i] = new Entry(key, value);
//				}
//			}
		}
	}
	
	/**
	 * #3b. Implement this (1 point)
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int hash = key.hashCode();
		Entry<K,V> current = values[hash];
		//Entry<K,V> previous = null;
		while(current != null && !current.key.equals(key))
		{
			//previous = current;
			current = current.next;
			
		}
		return current.data;
	}

	/**
	 * #3c.  Implement this. (1 point)
	 * 
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		int hash = key.hashCode();
		Entry<K,V> current = values[hash];
		Entry<K,V> previous = null;
			Entry<K,V> temp = null;
		if(current == null)
		{
			return null;
		}
		else
		{
			
			while(current != null && !current.key.equals(key))
			{
				previous = current;
				current = current.next;
				
			}
			temp = current;
			previous.next = temp.next;
			return temp.data;
		}
		
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean containsKey(K key) {
		return this.get(key) != null; 
	}

	public Iterator<V> values() {
		return new Iterator<V>() {
			private int count = 0;
			private Entry<K, V> currentEntry;
			
			{
				while ( ( currentEntry = values[count] ) == null && count < values.length ) {
					count++;
				}
			}
			
//			@Override
//			public void forEachRemaining(Consumer<? super V> arg0) {
//			}

			@Override
			public boolean hasNext() {
				return count < values.length;
			}

			@Override
			public V next() {
				V toReturn = currentEntry.data;
				currentEntry = currentEntry.next;
				while ( currentEntry == null && ++count < values.length && (currentEntry = values[count]) == null );
				return toReturn;
			}

			@Override
			public void remove() {
			}
			
		};
	}
	
	private static class Entry<K, V> {
		private K key;
		private V data;
		private Entry<K,V> next;
		
		public Entry(K key, V data) {
			this.key = key;
			this.data = data;
		}
		
		public String toString() {
			return "{" + key + "=" + data + "}";
		}
	}
}