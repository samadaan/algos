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
    int[] in;
    int curr;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre=preorder;
        in=inorder;
        curr=0;
        inorderIndexMap = new HashMap<>();
        // Fill the map with inorder values and their indices
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return create(0, inorder.length-1);
    }
    TreeNode create(int left, int right){
        if(left>right)return null;
        // if(left==right) return new TreeNode(pre[curr++]);

        int idx=inorderIndexMap.get(pre[curr]);
        if(idx!=-1){
            TreeNode n=new TreeNode(pre[curr++]);
            n.left=create(left, idx-1);
            n.right=create(idx+1, right);
            return n;
        }
        return null;
    }

    int find(int l, int r){
        for(int idx=l;idx<=r;idx++){
            if(pre[curr]==in[idx]){
                return idx;
            }
        }
        return -1;
    }
}