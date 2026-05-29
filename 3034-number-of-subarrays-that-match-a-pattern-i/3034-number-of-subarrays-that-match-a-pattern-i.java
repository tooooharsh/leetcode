class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count =0;
        int n = nums.length;
        int m = pattern.length;
        int start = nums[0];

        for (int i = 0; i <= n - m - 1; i++) {
            boolean match = true;

            for (int k = 0; k < m; k++) {
                if (pattern[k] == 1) {
                    if (nums[i + k + 1] <= nums[i + k]) {
                        match = false;
                        break;
                    }
                } else if (pattern[k] == 0) {
                    if (nums[i + k + 1] != nums[i + k]) {
                        match = false;
                        break;
                    }
                } else {
                    if (nums[i + k + 1] >= nums[i + k]) {
                        match = false;
                        break;
                    }
                }
            }

            if (match) {
                count++;
            }
        }

        return count;
        
        
    }
}