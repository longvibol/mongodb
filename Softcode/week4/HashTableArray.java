package com.algorithm.week4;

import java.util.Arrays;

public class HashTableArray {

	// Gold We create Hash Table but in the end we store it in Array
	/*
	 * K, V key : String Value: String Method: - put (key, value) - get (key) -
	 * remove (key) - hash (key)
	 * 
	 */

	private final static int SIZE = 10; // normal it is dynamic
	private Entry[] table; // We want to create our model to store only Key and Value
	private final Entry DELETED = new Entry("DELETED", null);

	public HashTableArray() {
		// initial value to table by constructor
		this.table = new Entry[SIZE];
	}

	// Method- Hash : convert from any input key to index
	private int hash(String key) {
		int hashValue = 0;
		// gold what to convert from Key to Index
		for (int i = 0; i < key.length(); i++) {
			hashValue = (hashValue + key.charAt(i) * i) % SIZE; // our algorithm but need to be in the rang [0-9] our
		}

		// System.out.println("Hash Value: " + hashValue); // size
		return hashValue;
	}

	// Method- Put (store value in Array)
	public void put(String key, String value) {		
		int index = hash(key);	

		// Fix hash collision
		// Linear Probing

		while(table[index]!=null && !table[index].key.equals(key)) {
			// បើតម្លៃវាស្មើរ វា update value ==> != value ==> add new value 
			index = (index+1)%SIZE;			
		}
		this.table[index] = new Entry(key, value);
		

	}

	// Method- GET
	public String get(String key) {

		int index = hash(key); // return 8
		while (table[index] != null) {
			if (table[index].key.equals(key)) {
				return table[index].value;
			}
			index = (index + 1) % SIZE;
		}
		return null;
	}

	// check index before remove

	public int indexDelet(int index) {
		for (int i = 0; i < table.length; i++) {
			System.out.println(table[i]);
		}
		return 0;
	}

	// Remove Method
	public void remove(String key) {
		int index = hash(key);
		System.out.println(index);

		while (table[index] != null) {
			if (table[index].key.equals(key)) {
				this.table[index] = DELETED;
				return;
			}

			index = (index + 1) % SIZE;
		}

	}

	// Netted class or we can called it is our type
	private static class Entry {

		String key;
		String value;

		Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[key=" + key + ", value=" + value + "]";
		}

	}

	public void print() {
		System.out.println(Arrays.toString(this.table));

		/*
		 * for(int i =0;i<table.length;i++) { if(table[i]!=null) { String key =
		 * this.table[i].key; int index = hash(key);
		 * System.out.println(this.table[i].key);
		 * System.out.println("Index duplicate: "+index); } }
		 * 
		 * System.out.println(this.table.length);
		 */
	}
}
