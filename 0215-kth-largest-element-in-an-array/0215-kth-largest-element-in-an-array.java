class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int t: nums){
            q.offer(t);
            if(q.size()> k){
                q.poll();
            }
        }

        return q.peek();

        
    }
}