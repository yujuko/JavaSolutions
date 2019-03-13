/*
100. Same Tree

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

*/

//solution: Runtime: 2 ms, faster than 100.00% of Java online submissions for Same Tree.
//Memory Usage: 37 MB, less than 8.73% of Java online submissions for Same Tree.

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null)
            return true;
        if(p==null || q == null)
            return false;
        if(p.val!=q.val)
            return false;
        boolean left = false;
        boolean right = false;
        
        if(p.left!=null && q.left!=null)
            left = isSameTree(p.left, q.left);
        else if(p.left==null && q.left==null)
            left = true;
        if(p.right!=null && q.right!=null)
            right = isSameTree(p.right, q.right);
        else if(p.right==null && q.right==null)
            right = true;
        
        return left && right;
    }
}