package com.algorithm.week3;
import java.util.Arrays;

// Homework3_MoveZeroToEnd
public class MoveZeroes_Week3 {
	public static void main(String[] args) {
		int[] numbers = {0, 1, 0, 3, 12};
        //int[] numbers = {0};
        //int[] numbers = {0, 0, 0, 1};
		
        moveZeroes(numbers);
        System.out.println("==> Move Zeroes To End: " + Arrays.toString(numbers));
	}
    // Method to move zeroes to the end of the array
    public static int[] moveZeroes(int[] nums) {
        int j = 0; // Index to place non-zero elements    
        
        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        // Fill the remaining positions with zeroes
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }        
        return nums;
    }

}
