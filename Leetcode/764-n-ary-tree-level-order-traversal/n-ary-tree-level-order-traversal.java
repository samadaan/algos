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
    List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(Node root) {
        ans = new ArrayList<>();
        traverse(root, 0);
        return ans;

    }

    void traverse(Node curr, int depth) {
        if (curr == null)
            return;
        if (depth == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(curr.val);
        for (Node child : curr.children) {
            traverse(child, depth + 1);
        }
    }
}