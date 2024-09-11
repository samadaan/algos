class Solution {
    public int coinChange(int[] coins, int amount) {
        // int[] dp = new int[amount+1];
        // Arrays.fill(dp, -1);
        // int val = recurse(amount, coins);
        // int val=memorize(dp, amount, coins);
        // return val == Integer.MAX_VALUE?-1:val;
         int val=tabulate(amount, coins);
        return val == Integer.MAX_VALUE?-1:val;
    }
    // public int recurse(int remAmount, int[] coins){
    //     if(remAmount==0)return 0;
    //     int min=Integer.MAX_VALUE;
    //     for(int c:coins){
    //         if(remAmount>=c){
    //             min=Math.min(min, recurse(remAmount-c, coins));
    //             if(min!=Integer.MAX_VALUE)min++;
    //         }
    //     }
    //     return min;
    // }

    // public int memorize(int[] cache, int remAmount, int[] coins){
    //     if(remAmount==0)return 0;
    //     if(cache[remAmount]!=-1){
    //         //System.out.println("remAmount "+remAmount +" cache "+cache[remAmount]);
    //         return cache[remAmount];
    //     }
    //     int min=Integer.MAX_VALUE;
    //     for(int c:coins){
    //         if(remAmount>=c){
    //             int val =  memorize(cache, remAmount-c, coins);
    //             if(val!=Integer.MAX_VALUE)val++;
    //             min=Math.min(min, val);
    //         }
    //     }
    //     return cache[remAmount]=min;
    // }
    public int tabulate(int amount, int[] coins){
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                int currAmount=coins[j];
                if(i>=currAmount){
                    int newVal=dp[i-currAmount];
                    if(newVal!=Integer.MAX_VALUE)newVal++;
                    dp[i]=Math.min(dp[i], newVal);
                }
            }
        }
        return dp[amount];
    }
}