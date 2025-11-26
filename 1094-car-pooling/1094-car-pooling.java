class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (x,y) -> x[2] - y[2]
        );

        int current = 0;

        for(int[] i: trips){
            int num = i[0];
            int from = i[1];
            int to= i[2];

            while(!minHeap.isEmpty() && minHeap.peek()[2] <= from){
            current-=minHeap.poll()[0];
            }
            current+=num;
            if(current > capacity){
                return false;
            }
            minHeap.offer(i);
        }
        return true;
    }
}
