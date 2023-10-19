class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums); // O(n * log(n))

        int closestSum = Integer.MAX_VALUE;
        int closestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) { //  O(n * n)
          int left = i + 1;
          int right = nums.length - 1;

            while(left<right){
            int currentSum = nums[i] + nums[left] + nums[right];
            int currentDiff = Math.abs(currentSum - target);
            
            //update tje logic here
            if (currentDiff < closestDiff) {
                closestSum = currentSum;
                closestDiff = currentDiff;
            }

            if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    return closestSum;
}

//space - O(1)

}