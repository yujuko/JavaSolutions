
/*
589. N-ary Tree Preorder Traversal

Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:


Return its preorder traversal as: [1,3,5,6,2,4].

*/

//solution:
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
     List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null){
            return result; }
        result.add(root.val);
        for(int i = 0; i<root.children.size(); i++){
            preorder(root.children.get(i));
        }
        return result;
    }
}