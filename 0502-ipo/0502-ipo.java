class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        //minHeap me capital 
        //(why?)min-heap apan ko project with the lowest required capital dega jo hoga at the top.
        PriorityQueue<int []> minHeap = new PriorityQueue<>(
            (x,y)-> x[1] - y[1]
        );
        //max me profit 
        //(why?)max-heap apan ko project with the max possible profit dega jo hoga at the top.
        PriorityQueue<int []> maxHeap = new PriorityQueue<>(
            (x,y)-> y[0] - x[0]
        );
        
        // [profit, capital]
        for(int i=0; i<n; i++){
            minHeap.offer(new int[]{profits[i], capital[i]});
        }
        
        for (int i = 0; i < k; i++) {

            // Move all affordable projects to maxHeap
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= w) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            // Pick the most profitable available project
            w += maxHeap.poll()[0];
        }

        return w;
    }
}
