// class Solution {
//     public int[][] kClosest(int[][] points, int k) {

//         PriorityQueue<int[]> minHeap = new PriorityQueue<>(
//             (a, b) -> Integer.compare(dist(a), dist(b))
//         );

//         for (int[] p : points) {
//             minHeap.offer(p);
//         }

//         int[][] res = new int[k][2];
//         for (int i = 0; i < k; i++) {
//             res[i] = minHeap.poll();
//         }

//         return res;
//     }

//     private int dist(int[] p) {
//         return p[0] * p[0] + p[1] * p[1];
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points, (a, b) -> 
            Integer.compare(dist(a), dist(b))
        );

        return Arrays.copyOfRange(points, 0, k);
    }

    private int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}

