package HashTables;

import java.util.LinkedList;

public class secondHashMap {
	
	private class Entry{
		int key;
		String value;
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	LinkedList<Entry> entries [] = new LinkedList[5];
	 
	
	public void put(int key, String value) {
		int index = hash(key);
		
		if (entries[index] == null) 
			entries[index] = new LinkedList<>();
			
			LinkedList<Entry> bucket = entries[index];
			
			for (Entry entry : bucket) 
				if(entry.key == key) {
					entry.value = value;
					return; }
				
			bucket.addLast(new Entry(key, value));
		}
	public String get(int key) {
		int index = hash(key);
		if (entries[index] == null ) {
			return null;
		}
		
		LinkedList<Entry> bucket = entries[index];
		for (Entry entry : bucket) {
			if(entry.key == key) {
				return entry.value;
			}
		}
		
		return null;
	}
	
	public void remove(int key) {
		int index = hash(key);
		if (entries[index] == null ) {
			throw new IllegalStateException();
		}
		
		LinkedList<Entry> bucket = entries[index];
		for (Entry entry : bucket) {
			
			if(entry.key == key) {
				bucket.remove(entry);
				return;
			}
		}
		
}
	private int hash(int key) {
		return Math.abs(key) % entries.length;
	}




}
