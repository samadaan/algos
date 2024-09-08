class Solution {
public:
    int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int a=1;
        int b=2;
        int c=0;
        for(int x=3;x<=n;x++){
            c=a+b;
            a=b;
            b=c;
        }
        return b;
        
    }
};