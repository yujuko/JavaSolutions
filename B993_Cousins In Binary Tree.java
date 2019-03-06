/*

993. Cousins in Binary Tree

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.


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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode node = null;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return false;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size  = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            while(size!=0){
                node = queue.remove();
                if(node.left!=null && node.right!=null){
                    if(node.left.val == x && node.right.val == y)
                      return false;
                    if(node.left.val == y && node.right.val == x)
                     return false;
                }
                if(node.val == x)
                    xFound = true;
                if(node.val == y)
                    yFound = true;
                if(node.left!= null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                size--;
            }
            if(xFound!=yFound)
                return false;
            if(xFound == true && yFound == true)
                return true;
        }
        return false;
    }
}