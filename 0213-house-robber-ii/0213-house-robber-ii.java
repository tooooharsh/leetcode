class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];
        
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));

        
    }

    public int robHelper(int[] nums, int start, int end) {

       if (start == end) return nums[start];
        
        int n = end - start + 1;
        int[] dp = new int[n];
        
        
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        
       
        for (int i = 2; i < n; i++) {
            //catch is to have a starting point defined
            dp[i] = Math.max(dp[i-1], nums[start + i] + dp[i-2]);
        }
        
        return dp[n-1];

    }
}