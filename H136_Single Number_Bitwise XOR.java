/*

136. Single Number

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/

//solution usint bitwise XOR - from Nkeys:
/*
we use bitwise XOR to solve this problem :

first , we have to know the bitwise XOR in java

0 ^ N = N
N ^ N = 0

So..... if N is the single number

N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

= 0 ^ 0 ^ ..........^ 0 ^ N

= N

 */
public int singleNumber(int[] nums) {
    int ans =0;
    
    int len = nums.length;
    for(int i=0;i!=len;i++)
        ans ^= nums[i];
    
    return ans;
    
}

//solution with LinkedList:

 class Solution {
     public int singleNumber(int[] nums) {
         List<Integer> set = new LinkedList<>();
         for(int i : nums){
             if(set.contains(i)){
                 set.remove(set.indexOf(i));
             }
             else
                 set.add(i);
         }
         return set.get(0).intValue();
     }
 }