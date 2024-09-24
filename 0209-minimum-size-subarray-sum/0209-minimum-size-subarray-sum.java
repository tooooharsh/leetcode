class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        


       int n = nums.length;
        int count = Integer.MAX_VALUE;
        int ptr1 = 0;
        int sum = 0;

        for (int ptr2 = 0; ptr2 < n; ptr2++) {
            sum += nums[ptr2];

            while (sum >= target) {
                count = Math.min(count, ptr2 - ptr1 + 1);
                sum -= nums[ptr1];
                ptr1++;
            }
        }

        return count == Integer.MAX_VALUE ? 0 : count;

        
    }
}