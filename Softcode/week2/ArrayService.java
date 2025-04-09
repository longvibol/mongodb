package com.algorithm.week2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayService {

	public static void main(String[] args) {

		String[] names = { "A", "B", "C", "D", "E", "F", "G" };
		// names = push(names, "Vibol");
//		System.out.println(Arrays.toString(names));

//		names = addToSpecificIndex(names, "Dany", 1);
//		System.out.println(Arrays.toString(names));

		names = deleteElementByIndex(names, -1);
//		System.out.println(Arrays.toString(names));

	}
	
	// HomeWork_Week2: DeleteElementByIndex
	  public static String[] deleteElementByIndex1(String[] arr, int indexToAdd) {

	    String[] newArray = new String[arr.length - 1];

	    if (indexToAdd >= arr.length) {	      
	      int indextArr = arr.length;
	      System.out.println("Please input index below < " + indextArr);	      
	      return newArray;

	    } else {
	      for (int i = 0; i < indexToAdd; i++) {
	        newArray[i] = arr[i];
	      }
	      for (int i = indexToAdd; i < newArray.length; i++) {
	        newArray[i] = arr[i + 1];
	      }
	    }
	    return newArray;

	  }


	public static String[] deleteElementByIndex(String[] arr, int indexToAdd) {

		String[] newArray = new String[arr.length - 1];

		if (indexToAdd >= arr.length || indexToAdd<0) {
			int indextArr = arr.length;
			System.out.println("Please input index below < " + indextArr);
			return newArray;

		} else {
			for (int i = 0; i < indexToAdd; i++) {
				newArray[i] = arr[i];
			}
			for (int i = indexToAdd; i < newArray.length; i++) {
				newArray[i] = arr[i + 1];
			}
			System.out.println("Array: " + Arrays.toString(arr));
			System.out.println("After Deleted Array: " + Arrays.toString(newArray));

		}
		return newArray;

	}

	public static String[] addToSpecificIndex(String[] arr, String newItem, int indexToAdd) {
		String[] newArray = new String[arr.length + 1];

		// Step 1: copy below index to add
		for (int i = 0; i < indexToAdd; i++) {
			newArray[i] = arr[i];
		}

		// Step 2: add value to new array
		newArray[indexToAdd] = newItem;

		// Step 3: copy value to after add

		for (int i = indexToAdd + 1; i < newArray.length; i++) {
			newArray[i] = arr[i - 1];
		}

		return newArray;
	}

	public static String[] push(String[] name, String newItem) {
		String[] newArray = new String[name.length + 1];
		for (int i = 0; i < name.length; i++) {
			newArray[i] = name[i];
		}
		newArray[name.length] = newItem;
		return newArray;
	}

}
