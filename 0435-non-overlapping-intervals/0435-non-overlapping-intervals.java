class Solution {


    
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // a-b ascending
        //b-a descending
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
              return a[1] - b[1];
            }
        });

       int count = 0; 
       int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Overlap, remove the interval with the larger end point
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                // No overlap, update the end point
                end = intervals[i][1];
            }
        }

        return count;





        
    }
}

