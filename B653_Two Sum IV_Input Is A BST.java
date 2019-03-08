/*

653. Two Sum IV - Input is a BST

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 

*/

//solution using arraylist

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//solution using Arraylist and Stack
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> numbers = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        
        while(!stack.isEmpty()||node!=null){
            
            while(node!=null){
                stack.push(node);                
                node = node.left;                   
            }
            
            node = stack.pop();
            numbers.add(node.val);
            node = node.right;
            
        }
        int i = 0;
        int j = numbers.size()-1;
        
        
        while(i<j){
            if(numbers.get(i)+numbers.get(j)==k)
                return true;
            if(numbers.get(i)+numbers.get(j)<k)
                i++;
             if(numbers.get(i)+numbers.get(j)>k)
                j--;
        }
        return false;
        
    }
}

//solution using Arraylist (add in order)
public boolean findTarget(TreeNode root, int k) {
    List<Integer> nums = new ArrayList<>();
    inorder(root, nums);
    for(int i = 0, j = nums.size()-1; i<j;){
        if(nums.get(i) + nums.get(j) == k)return true;
        if(nums.get(i) + nums.get(j) < k)i++;
        else j--;
    }
    return false;
}

public void inorder(TreeNode root, List<Integer> nums){
    if(root == null)return;
    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
}

//solution using HashSet:

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findSet(root, set, k);        
        
    }
    public boolean findSet(TreeNode node, HashSet<Integer> set, int k){
        if(node == null) return false;
        if(set.contains(k-node.val))
            return true;
        set.add(node.val);
        return findSet(node.left, set, k) || findSet(node.right, set, k);
    }
}

//     TreeNode first = null;
//     TreeNode second = null;    
//     public boolean findTarget(TreeNode root, int k) {                
        
//         if(root== null)
//             return false;
        
//         first = root;
        
//         if (first.val > (double)(1/2*k) ){
//             if(first.left!=null)
//                 second = first.left;
//             else
//                 return false;
//         }
//         if (first.val < (double)(1/2*k) ){
//             if(first.right!=null)
//                 second = first.right;
//             else
//                 return false;
//         }   
        
//         if(first.val == k)
//             return false;
        
//         if(findSum(k)== k)
//             return true;
        
//         while(findSum(k) > k){
//             if(first.left!=null)
//                 first = first.left;
//             else
//                 return false;
//         }
//         while(findSum(k) < k){
//             if(first.right!=null)
//                 first = first.right;
//             else
//                 return false;
//         }
//         return false;
        
//     }
    
//     public int findSum(int k){           
//             if(first.val+ second.val > k){
//                 while(second.left != null){
//                     second = second.left;      
//                 }
//                 return first.val+ second.val;  
//             }            
//              if(first.val+ second.val <k){
//                 while(second.right != null){
//                     second = second.right;                    
//                 }
//                 return first.val+ second.val;  
//              }
//     return first.val+ second.val;        
//     }
// }