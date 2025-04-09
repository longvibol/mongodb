//Homework_Week3: ContainDuplicate
package com.algorithm.week3;
public class ContainDuplicateH3 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1,1 };		
		//int[] nums = { 1,2,3,4 };
		//int[] nums = { 1,1,1,3,3,4,3,2,4,2,0};	 	
		checkDuplicate(nums);		
	} 
	public static boolean checkDuplicate(int[] arr) {	
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {		
					System.out.println("Ture!");
					return true;
				} 
			}
		}	
		System.out.println("False!");
		return false;
	}
}