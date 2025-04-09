package com.algorithm.week1;

public class Rule4DropNonDominant {

	public static void main(String[] args) {
		int[] items = {2,4,5,6};
		printAllNumberPairSum(items);
	

	}
	
	public static void printAllNumberPairSum(int[] items) {
		for(int x :items) {
			System.out.println(x); //O(n)
		}
		
		for(int x : items) {
			for(int y: items) {
				System.out.println(x+y); // O(n ^ 2)
			}
		}
	}
	// BIG O(n + n^2)
	// BIG O(n^2)
	
	

}
