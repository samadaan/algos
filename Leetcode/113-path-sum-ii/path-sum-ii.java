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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();
        traverse(root, new ArrayList<>(), targetSum);
        return ans;
    }
    void traverse(TreeNode curr, List<Integer> list, int remSum){
        if(curr==null)return;
        list.add(curr.val);
        remSum-=curr.val;
        if(remSum==0 && curr.left==null && curr.right==null){
            ans.add(new ArrayList<>(list));
        }
        traverse(curr.left, list, remSum);
        traverse(curr.right, list, remSum);
        remSum+=curr.val;
        list.remove(list.size()-1);

    }
    List<Integer> clone(List<Integer> a){
        List<Integer> b=new ArrayList<>();
        for(Integer x:a){
            b.add(x);
        }
        return b;
    }
}