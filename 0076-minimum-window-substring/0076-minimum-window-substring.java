class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        //fill in t frquency 
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        //need and have approach is effective in space complexity
        // than get put in smap
        int need = tMap.size();
        int have = 0;

        //2 pointers left and right
        // if need == have  =====> shrink from left until (need!=have)
        int left = 0;
        int shrinkedLeft = 0;
        int count = Integer.MAX_VALUE;

        for (int right = 0; right <sLen; right++) {
            char ch = s.charAt(right);
            //populate 
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            //agar frequncy match hogayi
            if (tMap.containsKey(ch) && sMap.get(ch).intValue() == tMap.get(ch).intValue()) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < count) {
                    count = right - left + 1;
                    shrinkedLeft = left;
                }

                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);

                if (
                    tMap.containsKey(leftChar) &&
                    sMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()
                ) {
                    have--;
                }

                left++;
            }
        }

        if (count == Integer.MAX_VALUE) return "";

        return s.substring(shrinkedLeft, shrinkedLeft + count);
    }
}