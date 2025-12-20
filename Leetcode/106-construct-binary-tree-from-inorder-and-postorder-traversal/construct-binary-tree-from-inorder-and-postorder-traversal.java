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
    int[] in;
    int[] post;
    Map<Integer, Integer> inToidxMap;
    int curr;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        curr=postorder.length-1;
        in=inorder;
        post=postorder;
        inToidxMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inToidxMap.put(inorder[i], i);
        }
        return create(0, inorder.length-1);
        
    }
    TreeNode create(int l, int r){
        if(l>r)return null;

        int val=post[curr--];
        int idx=inToidxMap.get(val);

        TreeNode n=new TreeNode(val);
        n.right=create(idx+1, r);
        n.left=create(l, idx-1);

        return n;
    }
}