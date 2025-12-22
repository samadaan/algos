/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parentMap;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap=new HashMap<>();
        fillParents(root, null);
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        queue.add(target);
        visited.add(target);
        int currentDistance=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(currentDistance==k){
                while(size-->0){
                    TreeNode n=queue.remove();
                    ans.add(n.val);   
                }
                return ans;
            }
            
            while(size-->0){
                TreeNode n=queue.remove();

                checkAndAdd(n.left, visited, queue);
                checkAndAdd(n.right, visited, queue);
                checkAndAdd(parentMap.get(n), visited, queue);
            }
            currentDistance++;
        }
        return ans;
    }
    void checkAndAdd(TreeNode node, Set<TreeNode> visited, Queue<TreeNode> queue){
        if(node!=null && !visited.contains(node)){
            queue.add(node);
            visited.add(node);
        }
    }
    void fillParents(TreeNode curr, TreeNode parent){
        if(curr==null)return;

        parentMap.put(curr, parent);
        fillParents(curr.left, curr);
        fillParents(curr.right, curr);
    }
}