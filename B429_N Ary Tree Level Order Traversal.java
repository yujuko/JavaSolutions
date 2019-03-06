/*

429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:


We should return its level order traversal:

[
     [1],
     [3,2,4],
     [5,6]
]
 

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.

*/


//solution using queue:

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> total = new ArrayList<List<Integer>>();    
        Queue<Node> queue = new LinkedList<>();
        Node node = null;
        
        if(root == null)
            return total;
        
        queue.add(root);        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> single = new ArrayList<>(); 
                while(size!=0){
                    node = queue.remove();
                    for(int i =0; i<node.children.size(); i++){
                         queue.add(node.children.get(i));
                    }
                    single.add(node.val);
                    size--;
                }
            total.add(single);        
        }
        return total;
    }
}

