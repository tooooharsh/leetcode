class Solution {
    public int subarraySum(int[] nums, int k) {
int maxLength = 0;  
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);  

        for (int num : nums) {
            sum += num;
           //use technique k = k + x - x = (k+x) - x
            if (mp.containsKey(sum - k)) {
                maxLength += mp.get(sum - k);
            }

            // Update the frequency 
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return maxLength;




        
    }
}