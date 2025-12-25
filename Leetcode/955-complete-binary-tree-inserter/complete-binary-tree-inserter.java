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
class CBTInserter {

    private Queue<TreeNode> queue;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        queue = new LinkedList<>();
        this.root = root;
        queue.add(root);
        push();

    }

    private void push() {
        while (true) {
            TreeNode n = queue.peek();
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
            if (n.left != null && n.right != null) {
                queue.remove();
            } else {
                break;
            }
        }
    }

    public int insert(int val) {
        TreeNode node = queue.peek();
        if (node.left == null) {
            node.left = new TreeNode(val);
            queue.add(node.left);
            return node.val;
        }
        node.right = new TreeNode(val);
        queue.add(node.right);
        queue.remove();
        return node.val;

    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */