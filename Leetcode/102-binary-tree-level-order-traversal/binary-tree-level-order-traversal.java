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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans=new ArrayList<>();
        // traverse(root, 0);
        if(root==null){
            return ans;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> a=new ArrayList<>();
            while(size-->0){
                TreeNode rem=queue.remove();
                a.add(rem.val);
                if(rem.left!=null)queue.add(rem.left);
                if(rem.right!=null)queue.add(rem.right);
            }
            ans.add(a);
        }
        return ans;
        
    }
    // void traverse(TreeNode curr, int depth){
    //     if(curr==null)return;
    //     if(depth==ans.size()){
    //         ans.add(new ArrayList<>());
    //     }
    //     traverse(curr.left, depth+1);
    //     ans.get(depth).add(curr.val);
    //     traverse(curr.right, depth+1);
    // }

}