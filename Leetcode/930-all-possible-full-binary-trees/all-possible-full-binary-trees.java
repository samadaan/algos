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

    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0)
            return ans;

        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int remNodes = n - 1;
        int leftNodes = 1;

        while (leftNodes < remNodes) {
            List<TreeNode> left = allPossibleFBT(leftNodes);
            List<TreeNode> right = allPossibleFBT(remNodes - leftNodes);
            for (TreeNode l : left) {

                for (TreeNode r : right) {

                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
            leftNodes += 2;
        }
        memo.put(n, ans);
        return memo.get(n);
    }
}