package com.algorithm.week1;

public class Rule2RemoveContant {

	public static void main(String[] args) {

		int[] items = { 2, 4, 5, 6 };
		// want to print : (2,2), (2,4), (2,5), (2,6)
		
		printPairOfElement(items);
	}

	public static void compressBoxTwice(int[] boxes1, int[] boxes2) {
		for (int x : boxes1) {
			System.out.println(x); // o(n)
		}

		for (int x : boxes2) {
			System.out.println(x + "#"); // o(m)
		}
		// BigO(n+m)
	}

	public static void printPairOfElement(int[] items) {
		for (int i = 0; i < items.length; i++) { //O(n)
			for (int j = 0; j < items.length; j++) { // O(n)
				System.out.println("("+items[i]+","+items[j]+")");
			}
		}
	}
	
	//BIG O (n*n) = O(n^2)

}
