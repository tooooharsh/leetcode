class Solution {

    private static boolean canEatAll(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        for (int bananas : piles) {
            hoursNeeded += (bananas + speed - 1) / speed;
        }
        return hoursNeeded <= h;
    }

    private static int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int bananas : piles) {
            max = Math.max(max, bananas);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {

         int left = 1;
         int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
        
    }
}