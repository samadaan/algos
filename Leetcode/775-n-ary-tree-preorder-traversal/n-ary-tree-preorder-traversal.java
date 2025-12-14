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
    List<Integer> ans;
    public List<Integer> preorder(Node root) {
        ans=new ArrayList<>();
        traverse(root);
        return ans;
    }
    public void traverse(Node r){
        if(r==null)return;

        ans.add(r.val);

        for(Node child:r.children){
            traverse(child);
        }
        return;
    }

}