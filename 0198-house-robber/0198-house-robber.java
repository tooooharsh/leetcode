class Solution {
    public int rob(int[] nums) {
        int t = nums.length;

        if(t<2) return nums[0];

        int[] dp = new int[t];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i=2; i<t; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        
        }

        return dp[t-1];
        
    }
}