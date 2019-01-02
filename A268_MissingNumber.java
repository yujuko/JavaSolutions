//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//        Example 1:
//
//        Input: [3,0,1]
//        Output: 2
//        Example 2:
//
//        Input: [9,6,4,2,3,5,7,0,1]
//        Output: 8
//        Note:
//        Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//My solution:
//(too slow) tried HashSet but need to convert int[] into Integer[] since asList won't take int
class Solution  {
    public int missingNumber(int[] nums) {

        List<Integer> numsCp = new ArrayList<>();
        for(int number : nums){
            numsCp.add(number);
        }
        for(int i = 0 ; i< numsCp.size() ; i++){
            if (!numsCp.contains(i)){
                return i;
            }
        }
        return numsCp.size();
    }
}

//1.XOR

public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
        }
        return res;
        }
//2.SUM

public int missingNumber(int[] nums) { //sum
        int len = nums.length;
        int sum = (0+len)*(len+1)/2;
        for(int i=0; i<len; i++)
        sum-=nums[i];
        return sum;
        }

//3.Binary Search

public int missingNumber(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
        }
        return left;
        }