class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        // int val = recurse(amount, coins);
        int val=memorize(dp, amount, coins);
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

    public int memorize(int[] cache, int remAmount, int[] coins){
        if(remAmount==0)return 0;
        if(cache[remAmount]!=-1){
            //System.out.println("remAmount "+remAmount +" cache "+cache[remAmount]);
            return cache[remAmount];
        }
        int min=Integer.MAX_VALUE;
        for(int c:coins){
            if(remAmount>=c){
                int val =  memorize(cache, remAmount-c, coins);
                if(val!=Integer.MAX_VALUE)val++;
                min=Math.min(min, val);
            }
        }
        return cache[remAmount]=min;
    }
}