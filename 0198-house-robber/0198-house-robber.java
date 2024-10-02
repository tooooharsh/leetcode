class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        
        int n = nums.length;
        int[] loot = new int[n];
        
        //memoize kiya for first 2 indices
        loot[0] = nums[0];
        loot[1] = Math.max(nums[0], nums[1]);
        
        // logic
        //looted 2 ho sakti either n-1 or n-2(we will add n into it)
        //case 1= loot till n-2 = total_loot - looted[n-2] + last wala since we have to maximize
        //case 2= loot till n-1= total_loot - looted[n-1]
        //max of case 1 and case 2
        // max(loot[n-2]+loot[n], loot[n-1])
        for (int i = 2; i < n; i++) {
            loot[i] = Math.max( loot[i-2]+ nums[i], loot[i-1]);
        }
        
        
        return loot[n-1];
    }
}