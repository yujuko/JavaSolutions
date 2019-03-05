import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*

897. Increasing Order Search Tree
Easy

199

225

Favorite

Share
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.

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
    public TreeNode increasingBST(TreeNode root) {
        
        TreeNode head = null, prev = null;
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        
        while(curr!=null || !stack.isEmpty()){
            //firstly push in all the left side node,
        	//if there is a right node in one of them, curr will jump to it at the bottom of the while loop
        	//and we will push it on the stack
        	//if not it will be null and we will pop the next left node
            while(curr!=null){
                stack.push(curr);
                curr= curr.left;
            }
           
            curr = stack.pop();
            
            if(head== null){
                head = curr;
            }
           
            if(prev != null){
                prev.right =curr;
            }
            curr.left = null;
            prev= curr;
            curr= curr.right; 
        }
        
        return head;

        
    }
}