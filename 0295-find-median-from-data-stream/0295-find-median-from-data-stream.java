class MedianFinder {

    // Lower half - MAX heap
    PriorityQueue<Integer> lower;

    // Upper half - MIN heap
    PriorityQueue<Integer> upper;

    public MedianFinder() {

        lower = new PriorityQueue<>(Collections.reverseOrder());

        upper = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Decide which half
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.offer(num);
        } else {
            upper.offer(num);
        }

        // Step 2: Balance heaps
        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        }

        if (upper.size() > lower.size()) {
            lower.offer(upper.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (lower.size() > upper.size()) {
            return lower.peek();
        }

        // Even number of elements
        return ((double) lower.peek() + upper.peek()) / 2.0;
    }
}