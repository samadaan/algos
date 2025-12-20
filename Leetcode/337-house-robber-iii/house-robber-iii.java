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
    // Map<TreeNode, Integer> dpChosen;
    // Map<TreeNode, Integer> dpNotChosen;

    public int rob(TreeNode root) {
        // dpChosen = new HashMap<>();
        // dpNotChosen = new HashMap<>();
        // return Math.max(traverse(root, true), traverse(root, false));
        int[] s=sum(root);
        return Math.max(s[0], s[1]);
    }

    // int traverse(TreeNode curr, boolean canChoose){
    //     if(curr==null)return 0;
    //     if(canChoose && dpChosen.get(curr)!=null){
    //         return dpChosen.get(curr);
    //     }else if(dpNotChosen.get(curr)!=null){
    //         return dpNotChosen.get(curr);
    //     }
    //     int sum1 = traverse(curr.left, true)+traverse(curr.right, true);
    //     if(canChoose){
    //         int sum2 = curr.val + traverse(curr.left, false)+traverse(curr.right, false);
    //         dpChosen.put(curr, Math.max(sum1, sum2));
    //         return dpChosen.get(curr);
    //     }
    //      dpNotChosen.put(curr, sum1);
    //     return dpNotChosen.get(curr);
        
    // }

    int[] sum(TreeNode curr){
        if(curr==null)return new int[]{0,0};

        int[] left=sum(curr.left);

        int[] right=sum(curr.right);

        int sum1=curr.val+left[1]+right[1];
        int sum2=left[0]+right[0];

        return new int[]{Math.max(sum1, sum2), sum2};
    }
}