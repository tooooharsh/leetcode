class Solution {
    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) { 
            int onesCount = 0;
            for (int num : nums) {
                onesCount += (num >> i) & 1;
            }
            int zerosCount = n - onesCount;
            totalDistance += onesCount * zerosCount;
        }
        return totalDistance;
    }
    
}