class Solution {
    public int lengthOfLongestSubstring(String s) {
        int k = s.length();
        int o = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int left=0, right=0; right<k ; right++ ){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            o = Math.max(o, right - left + 1);
            
        }

        return o;

        
    }
}