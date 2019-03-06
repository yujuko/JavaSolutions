/*

872. Leaf-Similar Trees

Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.


For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 

Note:

Both of the given trees will have between 1 and 100 nodes.

*/

//solition using stack:
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> r1 = checkLeaf(root1);
        ArrayList<Integer> r2 = checkLeaf(root2);
        if(r1.size()!=r2.size()){
            return false;
        }
        for(int i=0; i<r1.size() ;i++){
            if(r1.get(i)!=r2.get(i))
                return false;
        }
        return true;

    }
    
    public ArrayList<Integer> checkLeaf(TreeNode root){
        ArrayList<Integer> leaves = new ArrayList<>();
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr.left==null && curr.right == null){
                leaves.add(curr.val);
            }
            curr = curr.right;
        }
        return leaves;       
        
    }
}

//Leetcode solution: space:O(logN)
public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s1 = new Stack<>();
    
    s1.push(root1); 
    s2.push(root2);
    
    while (!s1.empty() && !s2.empty())
        if (dfs(s1) != dfs(s2)) 
        	return false;
    
    return s1.empty() && s2.empty();
}

public int dfs(Stack<TreeNode> s) {
    while (true) {
        TreeNode node = s.pop();
        if (node.right != null) s.push(node.right);
        if (node.left != null) s.push(node.left);
        if (node.left == null && node.right == null) return node.val;
    }
}