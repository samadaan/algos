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
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        ans=new ArrayList<>();
        if(root==null)return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> a=new ArrayList<>();
            while(size-->0){
                TreeNode rm=queue.remove();
                a.add(rm.val);
                if(rm.left!=null)queue.add(rm.left);
                if(rm.right!=null)queue.add(rm.right);
            }
            ans.add(0, a);
        }
        return ans;
        
    }
}