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
    int curr;
    Map<Integer, Integer> postOrderIndexMap;
    int[] pre;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postOrderIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postOrderIndexMap.put(postorder[i], i);
        }
        pre = preorder;
        curr = 0;
        return construct(0, pre.length - 1);
    }

    public TreeNode construct(int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex)
            return null;
        if (leftIndex == rightIndex)
            return new TreeNode(pre[curr++]);
        int val = pre[curr++];
        TreeNode n = new TreeNode(val);
        int leftChildIndex = postOrderIndexMap.get(pre[curr]);
        n.left = construct(leftIndex, leftChildIndex);
        n.right = construct(leftChildIndex + 1, rightIndex - 1);
        return n;

    }
}