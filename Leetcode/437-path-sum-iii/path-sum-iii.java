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
    // int ans;
    // int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        // ans = 0;
        // this.targetSum = targetSum;
        // List<Long> finalList = traverse(root);
        // for (long ele : finalList) {
        //     if (ele == targetSum) {
        //         ans++;
        //     }
        // }
        // return ans;

        Map<Long, Integer> prefixSumMap=new HashMap<>();
        prefixSumMap.put(0L, 1);
        return backtrack(root, 0L, targetSum, prefixSumMap);
    }
    int backtrack(TreeNode curr, long currentSum, int targetSum, Map<Long,Integer> map){
        if(curr==null)return 0;

        currentSum+=curr.val;
        
        int count=map.getOrDefault(currentSum-targetSum, 0);

        map.put(currentSum, map.getOrDefault(currentSum,0)+1);

        count+=backtrack(curr.left, currentSum, targetSum, map);
        count+=backtrack(curr.right, currentSum, targetSum, map);

        map.put(currentSum, map.getOrDefault(currentSum, 0)-1);
        
        return count;
    }


    
    
    
    // List<Long> traverse(TreeNode curr) {
    //     if (curr == null) {
    //         return new ArrayList<>();
    //     }
    //     List<Long> list1 = traverse(curr.left);
    //     List<Long> list2 = traverse(curr.right);
    //     List<Long> list3 = new ArrayList<>();
    //     list3.add((long)curr.val);
    //     for (long ele : list1) {
    //         if (ele == targetSum) {
    //             ans++;
    //         }
    //         list3.add(curr.val + ele);
    //     }
    //     for (long ele : list2) {
    //         if (ele == targetSum) {
    //             ans++;
    //         }
    //         list3.add(curr.val + ele);
    //     }
    //     return list3;

    // }
}