package com.algorithm.week3;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {

		int[] num = {0,1,0,3,12,1,89,1,0};
		//int[] num = { 0 };
		// int[] num = {0,0,0,1};
		
		int targetMoveToEnd = 0;

		int muchTarget = findNumberOfElmentInTarget(num, targetMoveToEnd);
		System.out.println("Array" + Arrays.toString(num));
		System.out.println("Array Length : " + num.length);

		int[] zeroArrayElement = new int[muchTarget];
		System.out.println("Number of target : " + zeroArrayElement.length);
		int[] a = new int[num.length - muchTarget];
		int j = 0;

		for (int i = 0; i < num.length; i++) {
			if (num[i] != targetMoveToEnd) {
				a[j] = num[i];
				j++;
			}
			if (j > (a.length - 1)) {
				break;
			}
		}
		for (int i = 0; i < num.length; i++) {
			if (i < a.length) {
				num[i] = a[i];
			} else {
				num[i] = targetMoveToEnd;
			}
		}
		System.out.println("==> Move Zero To End: " + Arrays.toString(num));
	}

	public static int findNumberOfElmentInTarget(int[] nums, int target) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				count++;
			}
		}
		return count;
	}

}
