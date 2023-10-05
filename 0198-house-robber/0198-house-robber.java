class Solution {
    public int rob(int[] nums) {

        int dp1 = 0;  
        int dp2 = 0;  
    
    for (int i = 0; i < nums.length; i++) {
        int current = Math.max(dp2 + nums[i], dp1); 
        dp2 = dp1;  
        dp1 = current;  
    }
    
    return dp1;  
        
    }
}