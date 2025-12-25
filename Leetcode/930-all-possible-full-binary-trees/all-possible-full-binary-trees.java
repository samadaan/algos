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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0)
            return ans;

        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        TreeNode root = new TreeNode(0);

        int remNodes = n - 1;
        int leftNodes = 1;

        while (leftNodes < remNodes) {
            List<TreeNode> left = allPossibleFBT(leftNodes);
            List<TreeNode> right = allPossibleFBT(remNodes - leftNodes);
            for (TreeNode l : left) {
                root.left = l;
                for (TreeNode r : right) {
                    root.right = r;
                    ans.add(clone(root));
                }
            }
            leftNodes+=2;
        }
        return ans;
    }

    public TreeNode clone(TreeNode curr) {
        TreeNode clonedNode = new TreeNode(0);
        clonedNode.left = curr.left;
        clonedNode.right = curr.right;
        return clonedNode;
    }
}