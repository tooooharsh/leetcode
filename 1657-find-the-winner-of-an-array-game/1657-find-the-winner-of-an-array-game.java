class Solution {
    public int getWinner(int[] arr, int k) {
        int currentWinner = arr[0];

        int winCount = 0;
        int n = arr.length;

        
        if (k >= n) {
            return helper(arr);
        }

        for (int i = 1; i < n; i++) {
            if (currentWinner > arr[i]) {
                winCount++;
            } else {
                currentWinner = arr[i];
                winCount = 1;  
            }

           
            if (winCount == k) {
                return currentWinner;
            }
        }
        
        return currentWinner;
        
    }

    private static int helper(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}