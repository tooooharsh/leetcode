class Solution {
    public int maxProfit(int[] prices) {
        //  int minima = prices[0];
        //  int maxima = 0;
        // for(int i=1; i< prices.length; i++){  
        //    maxima = Math.max(maxima, prices[i] - minima);
        //    minima = Math.min(minima, prices[i]);
        // }
        // return maxima;

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; 
            } 
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; 
            }
        }

        return maxProfit;
    }
}