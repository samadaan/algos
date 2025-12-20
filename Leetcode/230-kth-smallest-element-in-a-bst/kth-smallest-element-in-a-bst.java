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
    int prev;
    int currIdx;
    int K;

    public int kthSmallest(TreeNode root, int k) {
        prev=-1;
        currIdx=0;
        K=k;
        traverse(root);
        return prev;

    }
    void traverse(TreeNode curr){
        if(curr==null)return;
        if(prev!=-1)return;
        traverse(curr.left);
        currIdx+=1;
        if(currIdx==K){
            prev=curr.val;
            return;
        }
        traverse(curr.right);
    }
}