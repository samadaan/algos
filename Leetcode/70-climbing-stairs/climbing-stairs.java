class Solution {

    public int climbStairs(int n) {
        int prev=1;
        int curr=1;
        int temp;
        for(int i=2;i<=n;i++){
            temp=curr;
            curr=prev+curr;
            prev=temp;
            
        }
        return curr;
    }
}