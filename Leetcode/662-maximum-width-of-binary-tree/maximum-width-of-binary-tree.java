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
class Solution {
    class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode n, int i) {
            node = n;
            index = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int currentIndex = current.index;
                TreeNode node = current.node;

                if (i == 0) start = currentIndex;
                if (i == size - 1) end = currentIndex;

                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * currentIndex));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * currentIndex + 1));
                }
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }
}