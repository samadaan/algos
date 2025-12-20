/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    List<Node> connectArr;
    public Node connect(Node root) {
        connectArr=new ArrayList<>();
        traverse(root, 0);
        return root;
    }
    void traverse(Node curr, int depth){
        if(curr==null)return;
        if(depth==connectArr.size()){
            connectArr.add(curr);
        }else{
            Node prev=connectArr.get(depth);
            prev.next=curr;
            connectArr.set(depth, curr);
        }
        traverse(curr.left, depth+1);
        traverse(curr.right, depth+1);
    }
}