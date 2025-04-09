package com.algorithm.week4;

public class StringArrayDemo {

	public static void main(String[] args) {
		
		String test = "Welcom To Cambodia!";
		String stringReverst = revertString(test);
		
		System.out.println(test.charAt(0));
		System.out.println(stringReverst);
		
	}
	
	public static String revertString(String s) {
		String text = "";
		for(int i=s.length()-1;i>=0;i--) {
			text+=s.charAt(i);
		}		
		return text;
	}
}
