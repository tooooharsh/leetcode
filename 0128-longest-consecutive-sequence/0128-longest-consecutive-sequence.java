class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxima = 0;

       
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;          
                int currentMaxima = 1;   

               
                while (set.contains(current + 1)) {
                    current++;
                    currentMaxima++;  
                }

                maxima = Math.max(maxima, currentMaxima);
            }
        }

        return maxima;
    }
        
    
}