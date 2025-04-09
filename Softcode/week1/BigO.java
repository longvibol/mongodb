package com.algorithm.week1;

public class BigO {

	public static void main(String[] args) {
		String[] names = new String[] { "Nita", "Piseth", "Dara", "Thida", "Dara", "Vichect" };

//		findName(names);
		printFirstName(names);
	}

	// Big O(n) - Linear
	public static void findName(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == "Piseth") {
				System.out.println("Found Piseth");
			}
		}
	}
	

	
	public static void printFirstName(String[] names) {
		System.out.println("Print First Element = " + names[0]);
	}

}
