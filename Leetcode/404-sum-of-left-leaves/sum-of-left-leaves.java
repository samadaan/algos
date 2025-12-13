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
    int ans=0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root, false);
        return ans;

    //     if(root.left==null && root.right==null)return 0;
    //     List<TreeNode> queue=new LinkedList<>();
    //     queue.add(root);
    //     int ans=0;
    //     while(queue.size()>0){
    //         int size=queue.size();
    //         boolean flag=true;
    //         while(size-->0){
    //             TreeNode node=queue.remove(0);
    //             if(node.left==null && node.right==null && flag){
    //                 ans+=node.val;
    //                 flag=false;
    //             }
    //             queue.add(node.left);
    //             queue.add(node.right);
    //         }
    //    }
    //    return ans;
        
    }
    public void traverse(TreeNode curr, boolean left){
        if(curr==null)return;
        if(left && curr.left==null && curr.right==null){
            ans+=curr.val;
        }
        traverse(curr.left, true);
        traverse(curr.right, false);
    }
}