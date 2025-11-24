class Solution {
    public int findKthLargest(int[] nums, int k) {
     PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
     for(int t: nums){
        minHeap.offer(t);
        if(minHeap.size()>k){
            minHeap.poll();
        }
     }

     return minHeap.peek();


        
    }
}