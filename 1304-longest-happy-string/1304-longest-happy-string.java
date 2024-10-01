class Solution {
    public String longestDiverseString(int a, int b, int c) {
       
       
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('a', a);
        hm.put('b', b);
        hm.put('c', c);

        StringBuilder sb = new StringBuilder();

      
        while (true) {
            char ch = helper(sb, hm);
            
            if (ch == ' ') {
                
                break;
            }

            
            sb.append(ch);
            hm.put(ch, hm.get(ch) - 1);
        }

        return sb.toString();
    }

   
    private char helper(StringBuilder sb, HashMap<Character, Integer> hm) {
        char nextChar = ' ';
        int count = -1;

        for (char ch : hm.keySet()) {
            if (hm.get(ch) > count && threeTimesOccuranceCheck(sb, ch)) {
                count = hm.get(ch);
                nextChar = ch;
            }
        }

         if (count == 0) {
            return ' ';
        }

        return nextChar;
    }

   
    private boolean threeTimesOccuranceCheck(StringBuilder sb, char ch) {
        int len = sb.length();
        if (len >= 2 && sb.charAt(len - 1) == ch && sb.charAt(len - 2) == ch) {
            return false; 
        }
        return true;
    }
}
        
    
