/*

349. Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/

//solution using HashSet: 

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        if(nums1.length ==0 ||nums2.length ==0){
            return new int[0];
        }
        for(Integer i: nums1){
            set.add(i);
        }
        for(Integer i: nums2){
            if(set.contains(i)){
                set2.add(i);
            }
        }
        
        int[] a = new int[set2.size()];
        int i = 0;
        for (Integer val : set2) 
        a[i++] = val;
        return a;
    }
}
