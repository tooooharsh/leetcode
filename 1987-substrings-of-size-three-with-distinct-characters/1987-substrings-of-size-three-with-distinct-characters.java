class Solution {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            
            if (i >= 3) {
                char x = s.charAt(i - 3);
                mp.put(x, mp.get(x) - 1);
                if (mp.get(x) == 0) {
                    mp.remove(x);
                }
            }

    
            if (i >= 2 && mp.size() == 3) {
                ans++;
            }
        }

        return ans;
        
    }
}