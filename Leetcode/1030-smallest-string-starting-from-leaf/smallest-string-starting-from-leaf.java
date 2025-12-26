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
    List<Integer> ans;
    List<Integer> path;

    public String smallestFromLeaf(TreeNode root) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        traverse(root);
        String ansString = "";
        for (int i = ans.size() - 1; i >= 0; i--) {
            char x = (char) ('a' + ans.get(i));
            System.out.print(x);
            ansString += x;
        }
        return ansString;
    }

    private void traverse(TreeNode curr) {
        if (curr == null)
            return;
        path.add(curr.val);
        traverse(curr.left);
        traverse(curr.right);
        if (curr.left == null && curr.right == null) {
            check();
        }
        path.remove(path.size() - 1);
    }

    private void check() {
        if (path.size() == 0) {
            return;
        }
        if (ans.size() == 0) {
            ans = clone(path);
            return;
        }
        int a = ans.size() - 1;
        int p = path.size() - 1;
        while (p >= 0 && a >= 0) {
            // System.out.print("p " + p + " a " + a + "\n");
            if (path.get(p) < ans.get(a)) {
                ans = clone(path);
                return;
            } else if (path.get(p) > ans.get(a)) {
                return;
            }
            p--;
            a--;
        }
        if (a >= 0) {
            ans = clone(path);
        }

    }

    private List<Integer> clone(List<Integer> inp) {
        List<Integer> out = new ArrayList<>();
        for (Integer i : inp) {
            out.add(i);
        }
        return out;
    }
}