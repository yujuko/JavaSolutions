/*
303. Range Sum Query - Immutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

//solution: calculate all sum and return in every call:
//53 ms, 42.1 MB ,beat 99.5% - by arthur13
class NumArray {
int[] nums;

public NumArray(int[] nums) {
    for(int i = 1; i < nums.length; i++)
        nums[i] += nums[i - 1];
    
    this.nums = nums;
}

public int sumRange(int i, int j) {
    if(i == 0)
        return nums[j];
    
    return nums[j] - nums[i - 1];
}
}

//slow solution: calculate everytime 
// 243 ms, 59.3 MB
 class NumArray {
    
 public int[] data;

    
     public NumArray(int[] nums) {
         data = nums;
     }
    
     public int sumRange(int i, int j) {
         int sum = 0;
         while(i<=j){
             sum += data[i];
             i++;
         }
        
         return sum;
     }
 }

