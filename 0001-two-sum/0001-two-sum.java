class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int num = nums[i];
            int more_needed = target - num;

             if (map.containsKey(more_needed)) {
                return new int[]{map.get(more_needed), i};
            }

            map.put(nums[i], i);


        }

        return new int[0];




        
    }
}