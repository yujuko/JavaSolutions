/*
108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/

//solution using recursion:(array copy of range increases run time)
//Runtime: 1 ms, faster than 31.31% of Java online submissions for Convert Sorted Array to Binary Search Tree.
//Memory Usage: 37.2 MB, less than 99.22% of Java online submissions for Convert Sorted Array to Binary Search Tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {       
        if(nums.length == 0)
            return null;
        if(nums.length ==1){
            TreeNode root = new TreeNode(nums[0]);
            return root;
        }
        TreeNode root = new TreeNode(nums[(int)(nums.length*0.5)]);
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1 , nums.length));
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0, nums.length/2));
        return root;                    
    }
}

//solution using helper
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
//Memory Usage: 38.1 MB, less than 17.21% of Java online submissions for Convert Sorted Array to Binary Search Tree.

class Solution {
public TreeNode sortedArrayToBST(int[] num) {
    if (num.length == 0) {
        return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
}

public TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
        return null;
    }
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
}
}