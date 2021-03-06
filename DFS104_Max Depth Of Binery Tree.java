/* 104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

3
/ \
9  20
/  \
15   7

return its depth = 3.
*/


//solution:

// Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            // TreeNode node= queue.remove();
            int size = queue.size(); 
            //we need a size variable to check if the childs added at the same time/on the same level have all been went throhgt then we can add one. 
            while(size >0){
               TreeNode node= queue.remove(); 
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right); 
                size--;
                
            }
            depth+=1;           
        }
     return depth;   
    }
    
}
    
    


