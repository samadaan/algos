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
    List<Integer> arr;
    public boolean findTarget(TreeNode root, int k) {
        arr=new ArrayList<>();
        traverse(root);

        // for(int x:arr){
        //     System.out.print(x+" ");
        // }
        // System.out.println(k);
        return search(0,k,0);
    }
    void traverse(TreeNode curr){
        if(curr==null)return;
        traverse(curr.left);
        arr.add(curr.val);
        traverse(curr.right);
    }
    boolean search(int index, int targetValue, int found){
        if(found==2){
            return false;
        }
        if(index>=arr.size()){
            return false;
        }
        if(arr.get(index)==targetValue && found==1){
            return true;
        }
        return search(index+1, targetValue, found) || search(index+1, targetValue-arr.get(index), found+1);
       
    }
}