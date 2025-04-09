package com.algorithm.week1;

public class RuleCalcuateBigO {

	public static void main(String[] args) {
		String[] names = new String[] { "Nita","Dara", "Thida", "Dara", "Vichect","Piseth"};
		
		findName(names);

	}
	
	public static void findName(String[] names) {
		
		for (int i = 0; i < names.length; i++) {
			System.out.println("running: " + (i+1));
			if (names[i] == "Piseth") {
				System.out.println("Found Piseth");
			}
		}
	}

}
