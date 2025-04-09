package com.algorithm.week1;

public class Rule3DifferentTermOfInput {

	public static void main(String[] args) {
		int[] items = {2,3,5,6,7};
		
		printFirstItemThenFirstHalfThenSayHello100Time(items);

	}

	// O(n) 
	private static void printFirstItemThenFirstHalfThenSayHello100Time(int[] items) {
		System.out.println("Print First Item " + items[0]); // O(1)
		
		int middleItems = (int)Math.floor(items.length/2.0); // O(1)
		
		int index =0; //O(1)
		
		while(index <middleItems) {
			System.out.println(items[index]);
			index++;
		} // O(n/2)
		
		for(int i =0 ;i<100;i++) {
			System.out.println("Hello Camboida");
		} // O(100)
		
	}
	//BIG O = O(3 + 2x n/2 + 100) = O(n) 
	
	public static void compressBoxTwice(int[] boxes) {
		for(int x :boxes) {
			System.out.println(x); // o(n)
		}
		
		for(int x :boxes) {
			System.out.println(x+"#"); // o(n)
		}
		
		//BigO = O(2n) => O(n) (n^2) 
	}
	
	

}
