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
    int depth;
    int val;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode n=new TreeNode(val);
            n.left=root;
            return n;
        }
        this.depth=depth;
        this.val=val;
        addRow(root, 1);
        return root;
        
    }
    void addRow(TreeNode root, int d){
        if(root==null)return;
        if(d==depth-1){
            TreeNode l=root.left;
            root.left=new TreeNode(val);
            root.left.left=l;

            TreeNode r=root.right;
            root.right=new TreeNode(val);
            root.right.right=r;
        }
        addRow(root.left, d+1);
        addRow(root.right, d+1);

    }
}