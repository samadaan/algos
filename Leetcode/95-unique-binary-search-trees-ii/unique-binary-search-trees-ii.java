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
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }
    List<TreeNode> genTrees(int left, int right){
        List<TreeNode> ans=new ArrayList<>();
        if(left>right){
            ans.add(null);
            return ans;
        }
        if(left==right){
            ans.add(new TreeNode(left));
            return ans;
        }
        for(int curr=left;curr<=right;curr++){
            List<TreeNode> leftNodes=genTrees(left, curr-1);
            List<TreeNode> rightNodes=genTrees(curr+1, right);
            for(TreeNode leftNode: leftNodes){
                for(TreeNode rightNode: rightNodes){
                    TreeNode currNode=new TreeNode(curr);
                    currNode.left=leftNode;
                    currNode.right=rightNode;
                    ans.add(currNode);
                }
            }
        }
        return ans;
    }
    TreeNode clone(TreeNode curr){
        TreeNode cloned=new TreeNode(curr.val);
        cloned.left=curr.left;
        cloned.right=curr.right;
        return cloned;
    }
}