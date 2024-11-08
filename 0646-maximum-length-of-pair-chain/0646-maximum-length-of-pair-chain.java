class Solution {
    public int findLongestChain(int[][] pairs) {
       

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));


        int current = Integer.MIN_VALUE;
        int max = 0;

        for (int[] p: pairs) {
            if (p[0] > current) {  
                current = p[1];   
                max++;           
            }
        }

        return max;
        
    }
}