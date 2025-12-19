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
    List<Integer> list;
    int currIndex;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        currIndex = 0;
        traverse(root1);
        // for(int x:list){
        //     System.out.print(x+" ");
        // }
        //  System.out.println("---");
        boolean ans =  checkLeaf(root2);
        // System.out.println(currIndex);
        if( ans && currIndex >= list.size()){
            return true;
        }
        return false;
    }

    boolean checkLeaf(TreeNode curr) {
        if(curr==null)return true;
        if (currIndex >= list.size())
            return false;
        if (curr.left == null && curr.right == null) {
            if (list.get(currIndex) != curr.val) {
                return false;
            }
            currIndex++;
            return true;
        }
        return checkLeaf(curr.left) && checkLeaf(curr.right);

    }

    public void traverse(TreeNode curr) {
        if (curr == null)
            return;
        if (curr.left == null && curr.right == null) {
            list.add(curr.val);
            return;
        }
        traverse(curr.left);
        traverse(curr.right);
    }

}