/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int ans=0;
    public int maxDepth(Node root) {
        inorder(root,1);
        return ans;
    }
    public void inorder(Node curr, int currDepth){
        if(curr==null)return;

        if(currDepth>ans){
            ans=currDepth;
        }

        for(Node child:curr.children){
            inorder(child, currDepth+1);
        }
    }
}