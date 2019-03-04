/*
590. N-ary Tree Postorder Traversal

Given an n-ary tree, return the postorder traversal of its nodes' values.

For example, given a 3-ary tree:



Return its postorder traversal as: [5,6,3,2,4,1].

 
Note:

Recursive solution is trivial, could you do it iteratively?


*/


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

//recursive:
class Solution 1 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root==null)
            return result;
        for(int i = 0; i< root.children.size(); i++){
            postorder(root.children.get(i));
        }
        result.add(root.val);
        
        return result;
    }
}
//iterative: using Stack 
class Solution 2 {
    
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();  
        Stack<Node> stack = new Stack<>();        
        if(root==null)
            return result;
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            result.add(pop.val);
            for(int i=0 ; i<pop.children.size();i++){
                stack.push(pop.children.get(i));    
            }            
        }
        Collections.reverse(result);
        return result;
    }
}