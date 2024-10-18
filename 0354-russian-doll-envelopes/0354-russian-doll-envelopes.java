class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int t = envelopes.length;
        //base condition
        if (envelopes == null || t == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int[] h = new int[t];
        for (int i = 0; i < t; i++) {
            h[i] = envelopes[i][1];
        }

        return helper(h);
    }

    private int helper(int[] h) {
        List<Integer> dp = new ArrayList<>();
        for (int ht : h) {
            int tmp = binarySearch(dp, ht);
            if (tmp == dp.size()) {
                dp.add(ht);
            } else {
                dp.set(tmp, ht);
            }
        }
        return dp.size();
    }

    private int binarySearch(List<Integer> dp, int target) {
        int low = 0, high = dp.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (dp.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
        
    
}