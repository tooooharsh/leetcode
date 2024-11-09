class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n+1][n+1];

        for(int gap=0; gap<n ; gap++){
            for(int i=0, j=gap; j<n; i++,j++){
                if(gap == 0){
                  dp[i][j] = true;
                }else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                        dp[i][j]= (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true);
                }

                if(dp[i][j]==true){
                        count++;
                    
                }

                

            }

        }


        return count;


        
    }
}