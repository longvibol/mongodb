package com.algorithm.week3;
import java.util.Arrays;

// Homework_Week3_Improve Function: pushEvenNumber 
public class MyArray {
	private int length;
	private int[] value;
	
	// Initialize array= empty array and length = 0
	public MyArray() {
		this.length = 0;
		this.value = new int[0];
	}	
	// Push Only Even Number to Array
	public void push(int element) {
		if (element % 2 != 0) {
			throw new RuntimeException("Not Even Number!");
		}		
		
		int[] newArray = new int[length + 1];
		for (int i = 0; i < length; i++) { // 1 : index : 0
			newArray[i] = value[i];
		}
		newArray[length] = element;
		length++;
		value = newArray;
	}
	
	/*
	// Push Only Even Number
	public void push1(int element) {
		if (element % 2 != 0) {
			throw new RuntimeException("Not even number!");
		}

		if (length == 0) {
			this.value = new int[0];
			value[length] = element; // assing index [0] = valueInput
			length++; // increase index
		} else {
			int[] newArray = new int[length + 1];

			for (int i = 0; i < length; i++) { // 1 : index : 0
				newArray[i] = value[i];
			}
			newArray[length] = element;
			length++;
			value = newArray;
		}

	}
	
	*/

	public int getLength() {
		return length;
	}

	public int[] getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "MyArray [length=" + length + ", value=" + Arrays.toString(value) + "]";
	}
	
	

}
