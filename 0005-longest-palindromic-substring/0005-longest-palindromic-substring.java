class Solution {
    public String longestPalindrome(String s) {
        
        if(s.length() <= 1) return s;


        int max_len = 1;
        int n = s.length();
        int st = 0;
        int end = 0;
        
        // Odd  = keep both start and end at centre and check using left right pointers
        for(int i = 0; i < n-1; ++i){
            int l = i, r = i;
            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--; 
                    r++;
                }else
                    break;
            }

            int len = r-l-1;
            if(len > max_len){
                max_len = len;
                st = l+1;
                end = r-1;
            }
        }
        
        // Even length = end = start+1;
        for(int i = 0; i < n-1; ++i){
            int l = i, r = i+1;
            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--; r++;
                }else
                    break;
            }
            int len = r-l-1;
            if(len > max_len){
                max_len = len;
                st = l+1;
                end = r-1;
            }
        }
        
        return s.substring(st, end + 1);
        
    }
}