class Solution {
    public boolean canPartition(int[] nums) {

        //problem identification = 0-1 knapsack subset sum
        //if sum is odd then no chance
        // if s=even, then pass s/2 as target sum with array.
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return subSetSum(nums, sum / 2);
    }

    public boolean subSetSum(int[] nums, int s) {
        int n = nums.length;
        //standard top -down approach
        boolean[][] dp = new boolean[n + 1][s + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                if (i == 0) {
                    dp[i][j] = false; // upar ka row 0 set
                }
                if (j == 0) {
                    dp[i][j] = true;// then first column 1 set so that
                    //dp[i][j]= 1
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                //agar bag ke weight se kam weight hai to 2 choices
                //1 => pick => dp[i-1][j-nums[i-1]] (total weight se 
                // wo element ka weight minus kiya)
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] 
                    || dp[i - 1][j];
                    //or dont pick=> skip the element, weight jaise the
                } else {
                    //bag ke weight se jyada weight hai, so drop it.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][s];
    }
}
