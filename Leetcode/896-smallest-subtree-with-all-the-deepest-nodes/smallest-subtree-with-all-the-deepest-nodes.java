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
    Map<TreeNode, TreeNode> parentMap;
    Queue<TreeNode> deepestNodes;
    int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        parentMap = new HashMap<>();
        deepestNodes = new LinkedList<>();
        maxDepth = -1;
        fill(root, 0, null);
        if (deepestNodes.size() == 1) {
            return deepestNodes.remove();
        }
        while (!deepestNodes.isEmpty()) {
            int size = deepestNodes.size();
            Set<TreeNode> visitedNodes = new HashSet<>();
            while (size-- > 0) {
                TreeNode n = deepestNodes.remove();
                TreeNode par = parentMap.get(n);
                if (!visitedNodes.contains(par)) {
                    visitedNodes.add(par);
                    deepestNodes.add(par);
                }
            }
            if (deepestNodes.size() == 1) {
                return deepestNodes.remove();
            }
        }
        return null;

    }

    void fill(TreeNode curr, int depth, TreeNode par) {
        if (curr == null)
            return;
        if (depth > maxDepth) {
            maxDepth = depth;
            deepestNodes.clear();
            deepestNodes.add(curr);
        } else if (depth == maxDepth) {
            deepestNodes.add(curr);
        }
        parentMap.put(curr, par);
        fill(curr.left, depth + 1, curr);
        fill(curr.right, depth + 1, curr);
    }
}