package com.lucy;
//
// Given an array of size n, find the majority element. The majority element is the element that appears
// more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always exist in the array.
//
//        Example 1:
//
//        Input: [3,2,3]
//        Output: 3
//        Example 2:
//
//        Input: [2,2,1,1,1,2,2]
//        Output: 2
//

// Approach 1: Sorting
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
        
    }
}

// Approach 2: Brute Force
class Solution {
    public int majorityElement(int[] nums) {
        int i, j ;
        int maj =0 ;
        if( nums.length == 1){
            maj = nums[0];
        } else {
            for (i = 0; i < nums.length; i++) {
                int count = 0;
                int temp = nums[i];
                for (j = 0; j < nums.length; j++) {
                    if (temp == nums[j]) {
                        count++;
                    }
                }
                if (count > nums.length / 2) {
                    maj = temp;
                }
            }
        } return maj;

}
}

//Approach 3: Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 ;
        Integer cand = null;
        for (int num : nums){
            if ( count == 0 ){
                cand = num;
            }
            count += ( cand == num )? 1 : -1;
        }return cand;
    }
}
