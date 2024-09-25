class Solution {
    public int coinChange(int[] coins, int amount) {


        //why amount+1? 0 sathi 1 extra space at the beg. and set it to 0.
        int[] dp = new int[amount + 1];
        dp[0] = 0; 

        //since min coins aahet, set rest to global maxima
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE; 
        }

        // ata taking all eligible coins in account
        for (int coin : coins) {

            //first eligible coin to amount loop

            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) { 
                    //either pick dp[i] or dp[i minus juna coin
                    // to get min ans]
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
}
}