class Solution {
    public boolean containsDuplicate(int[] nums) {
       HashSet<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (res.contains(num)) {
                return true;  
            }
            res.add(num);
        }
        return false;
    }
}
