package com.algorithm.week4;

public class HashTableDemo {
	
	public static void main(String[] args) {
		
		HashTableArray hashTable = new HashTableArray();		
		hashTable.put("iphone", "This is my iphone");		
		
		//hashTable.put("dara", "Dara is my friend");		
		hashTable.put("iphonex", "This is my iphoneX");

		
		//hashTable.print();
		
		//hashTable.put("iphone", "This is my new iphone update");		
		//String value = hashTable.get("iphonex");
		
		String value = hashTable.get("iphonex");
		System.out.println("Value = " + value);
		
		hashTable.remove("iphone");		
		//System.out.println("first ==============");
		
		//hashTable.print();	
//		
		hashTable.remove("iphonex");
		//System.out.println("Second ==============");
		hashTable.print();	
//		
		
	}

}
