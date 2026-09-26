class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight); // heaviest package
            high += weight;              // ship everything in one day
        }

        int answer = high;

        while (low <= high) {

            int capacity = low + (high - low) / 2;

            if (canShip(weights, days, capacity)) {

                // This capacity works.
                // But we want the MINIMUM capacity.
                answer = capacity;
                high = capacity - 1;

            } else {

                // Capacity too small.
                low = capacity + 1;
            }
        }

        return answer;
    }


    private boolean canShip(int[] weights, int allowedDays, int capacity) {

        int daysNeeded = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight <= capacity) {

                // Put package on today's ship
                currentLoad += weight;

            } else {

                // Today's ship is full.
                // Start a new day.
                daysNeeded++;
                currentLoad = weight;
            }
        }

        return daysNeeded <= allowedDays;
    }
}