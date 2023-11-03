class Solution {
    public int[][] merge(int[][] intervals) {
        //sorted for the first key ie shuru hone ka time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
        if (current[1] >= next[0]) {
                // Merge 
            current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap
                output.add(current);
                current = next;
            }
        }
        // Add all
        output.add(current);
        return output.toArray(new int[output.size()][]);
    }
}