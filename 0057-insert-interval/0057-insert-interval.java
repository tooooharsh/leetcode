class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

     List<int[]> result = new ArrayList<>();
        
        int a = newInterval[0];
        int b = newInterval[1];
        int i = 0;
        int n = intervals.length;
        
        while (i < n && intervals[i][1] < a) {
            result.add(intervals[i]);
            i++;
        }
        
        while (i < n && intervals[i][0] <= b) {
            a = Math.min(a, intervals[i][0]);
            b = Math.max(b, intervals[i][1]);
            i++;
        }

        result.add(new int[]{a, b});
        
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}