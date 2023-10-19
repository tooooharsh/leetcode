class Solution {
    public int findKthLargest(int[] nums, int k) {
        //minHeap for largest 
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();    
    }
}