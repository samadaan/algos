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
    int[] pre;

    public TreeNode bstFromPreorder(int[] preorder) {
        pre = preorder;
        return traverse(0, pre.length - 1);

    }

    public TreeNode traverse(int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(pre[left]);
        }
        TreeNode node = new TreeNode(pre[left]);
        int rightGreaterIndex = findIndex(pre[left], left + 1, right);
        if (rightGreaterIndex == -1) {
            node.left = traverse(left + 1, right);
            return node;
        }
        node.left = traverse(left + 1, rightGreaterIndex - 1);
        node.right = traverse(rightGreaterIndex, right);
        return node;
    }

    private int findIndex(int val, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (pre[i] >= val) {
                return i;
            }
        }
        return -1;
    }

}