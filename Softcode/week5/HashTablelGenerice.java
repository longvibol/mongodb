package com.algorithm.week5;

import java.util.Arrays;

public class HashTablelGenerice {

	private Entry[] table;
	private static final int INITIAL_SIZE = 10;
	private static final double LOAD_THRESHOLD = 0.7;
	private static Entry DELETED = new Entry("#DELETED#", null);
	private int counter;

	public HashTablelGenerice() {
		this.table = new Entry[INITIAL_SIZE];
		counter = 0;
	}

	private int hash(String key, int tableSize) {
		int hashValue = 0;
		// gold what to convert from Key to Index
		for (int i = 0; i < key.length(); i++) {
			hashValue = (hashValue + key.charAt(i) * i) % tableSize; // our algorithm but need to be in the rang [0-9]
																		// our
		}
		// System.out.println("Hash Value: " + hashValue); // size
		return hashValue;
	}

	public void put(String key, String value) {
		// Check if need to increase size
		if (counter >= table.length * LOAD_THRESHOLD) {
			resize();
		}
		// Find index
		int index = hash(key, table.length);

		// Find firstDeletedIndex
		int firstDeletedIndex = -1; // for reuse Slot: we find what is the first index we have deleted

		// In case there is hash collision
		System.out.println("hash index: " + index);

		while (table[index] != null) { // have value
			if (table[index] == DELETED) {
				if (firstDeletedIndex == -1) {
					firstDeletedIndex = index; // Mark as deleted slot
					//System.out.println("First Delete index: " + firstDeletedIndex);
				}
			} else if (table[index].key.equals(key)) {
				table[index].value = value; // Update existing value
				return;
			}
			index = (index + 1) % table.length;
		}

		if (firstDeletedIndex != -1) {
			table[firstDeletedIndex] = new Entry(key, value);
		} else {
			table[index] = new Entry(key, value);
		}

		counter++;
		System.out.println(counter);
	}

	private void resize() {

		int newSize = table.length * 2;
		Entry[] newTable = new Entry[newSize];

		// we need to copy from the old Entry where the vale != null
		// rehash, re-input
		for (Entry entry : this.table) {
			if (entry != null && entry != DELETED) {
				int index = hash(entry.key, newSize);
				// fix hash collision by linear probing
				while (newTable[index] != null) {
					index = (index + 1) % newSize;
				}
				newTable[index] = entry; // new Entry(entry.key, entry.value);
			}

		}
		this.table = newTable; // Update Reference Table
		System.out.println("New Size: " + newSize);
	}

	public void print() {
		System.out.println(Arrays.toString(table));

	}

	public String get(String key) {
		int index = hash(key, table.length);

		while (table[index] != null) {
			if (table[index].key.equals(key)) {
				return table[index].value;
			}
			index = (index + 1) % table.length;
		}
		return null;
	}

	public void remove(String key) {
		int index = hash(key, table.length);
		while (table[index] != null) {
			if (table[index].key.equals(key)) {
				table[index] = DELETED;
				counter--;
				return;
			}
			index = (index + 1) % table.length;
		}
	}
	
	// Entry is our Type want to store 
	public static class Entry {
		String key;
		String value;

		Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "key=" + key + "," + "value=" + value;
		}
	}

}
