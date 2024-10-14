class Solution {
    public int maxWidthRamp(int[] nums) {

        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        
        for (int i = 1; i < n; i++) {
            if ( nums[s.peek()] > nums[i] ) {
                s.push(i);
            }
        }
        
        int ans = 0;
        
        for (int j = n - 1; j >= 0; j--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[j]) {
                ans = Math.max(ans, j - s.pop());
            }
        }
        
        return ans;
        
    }
}