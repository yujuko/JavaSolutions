/*

669. Trim a Binary Search Tree

Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1

*/

//Leetcode solution:

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
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if(root == null) 
                return null;
            
            if(root.val>R)
                return trimBST(root.left,L,R);
            
            if(root.val<L)
                return trimBST(root.right,L,R);
            
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
            
            return root;
                    
        }
}
//     TreeNode head = null, prev = null;
    
//     public TreeNode trimBST(TreeNode root, int L, int R) {
        
//         TreeNode curr = root;
        
//         if(curr == null){
//             return null;
//         }
    
        
//         if(curr.val>R){
//             if(curr.left == null){
//                  if(prev!=null)
//                      prev.right = null;
//             }   
//             curr = curr.left;
//             trimBST(curr,L,R);
//         }
//         if(curr.val<L){
//             if(curr.right == null){
//                  if(prev!=null)
//                      prev.left = null;
//             }   
//             curr = curr.right;
//             trimBST(curr,L,R);
//         }
//         else {
//             if(head == null){
//               head = curr;
//             }
//             prev = curr;
//             if(curr.left!=null)
//                 trimBST(curr.left,L,R);
//             if(curr.left!=null)
//                 trimBST(curr.right,L,R);
//         }
        
//         return head;
        
// }
// }