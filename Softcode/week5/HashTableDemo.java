package com.algorithm.week5;

public class HashTableDemo {

 
	public static void main(String[] args) {
		HashTableImprove hashTable = new HashTableImprove();
		
		hashTable.put("iphone", "Iphone");
		hashTable.put("iphonex", "my iphone");
		hashTable.put("oppo", "CC");

		
//		System.out.println("Key iphone:"+ hashTable.get("iphone"));
//		System.out.println("Key iphonex:"+ hashTable.get("iphonex"));
		
		System.out.println("-----After Delete some element-----");
		hashTable.remove("iphone");
//		hashTable.print();
		hashTable.put("iphonex", "my iphone");
		
//		hashTable.print();		
		
		System.out.println("Key iphone:"+ hashTable.get("#DELETED#"));
	}

}
