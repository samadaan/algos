/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    Stack<Integer> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        push(root);

    }

    public int next() {
        if (hasNext()) {
            return stack.pop();
        }
        return -1;

    }

    public boolean hasNext() {
        if (stack.size() != 0)
            return true;
        return false;

    }

    void push(TreeNode curr) {
        if(curr==null)return;
        push(curr.right);
        stack.push(curr.val);
        push(curr.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */