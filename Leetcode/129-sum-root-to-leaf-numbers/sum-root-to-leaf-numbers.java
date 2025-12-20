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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        traverse(root, 0);
        return sum;
    }
    void traverse(TreeNode curr, int currNum){
        if(curr==null)return;
        currNum=currNum*10+curr.val;
        if(curr.left==null && curr.right==null){   
            sum+=currNum;
            return;
        }
        traverse(curr.left, currNum);
        traverse(curr.right, currNum);

    }
}