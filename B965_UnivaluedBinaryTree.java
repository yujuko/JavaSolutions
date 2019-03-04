/*
965. Univalued Binary Tree

A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

 

Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false
 

Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].

*/

//solution:
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
    boolean result = true;
    public boolean isUnivalTree(TreeNode root) {        
        if(root == null)
            return result;
        if(root.left ==null && root.right!= null){
            if(root.val!=root.right.val)
                result = false;
            isUnivalTree(root.right);
        }
          if(root.left !=null && root.right== null){
            if(root.val!=root.left.val)
                result = false;
            isUnivalTree(root.left);
        }
        if(root.left !=null && root.right!=null){
            if( root.left.val != root.right.val || root.left.val != root.val ||root.right.val!=root.val)
                result = false;
            isUnivalTree(root.left);
            isUnivalTree(root.right);
        }
        return result;
    }
}