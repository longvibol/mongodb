package com.algorithm.week2;


public class Homework1 {
	
	/*	
	public static void main(String[] args) throws Exception {
		String[] names = { "A", "B", "C", "D", "E", "F", "G" };
		names = deleteElementByIndex(names, 6);
		System.out.println(Arrays.toString(names));
	}
	
	*/
	// HomeWork_Week2: DeleteElementByIndex_Update
	public String[] deleteElementByIndex2(String[] arr, int indexToDelete) {
		String[] newArray = new String[arr.length - 1];
		int indextArr = arr.length;

		if (indexToDelete >= arr.length) {
			throw new RuntimeException("Please input index below <" + indextArr);
		}		
		if (indexToDelete <0) {
			throw new RuntimeException("The IndexToRemove cannot be below zero");
		}		
	//Remove element logic in Array 
		for (int i = 0; i < indexToDelete; i++) {
			newArray[i] = arr[i];
		}
		for (int i = indexToDelete; i < newArray.length; i++) {
			newArray[i] = arr[i + 1];
		}
		return newArray;

	}
	
	public String[] deleteElementByIndex(String[] arr, int indexToDelete) {
		String[] newArray = new String[arr.length - 1];
		int indextArr = arr.length;

		if (indexToDelete >= arr.length) {
			throw new RuntimeException("Please input index below <" + indextArr);
		}		
		if (indexToDelete <0) {
			throw new RuntimeException("The IndexToRemove cannot be below zero");
		}	
		
		for(int i =0;i<newArray.length;i++) {
			if(i<indexToDelete) {
				newArray[i] = arr[i];
			}else {
				newArray[i] = arr[i + 1];
			}
		}
		
		return newArray;

	}

}
