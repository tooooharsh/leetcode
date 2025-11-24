class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (x,y) -> y[1] - x[1]
        );
        if(a >0){
            maxHeap.offer(new int[] {'a', a});
        }
        if(b >0){
            maxHeap.offer(new int[] {'b', b});
        }
        if(c>0){
            maxHeap.offer(new int[] {'c', c});
        }

        while (!maxHeap.isEmpty()) {
            int[] maxOccurrance = maxHeap.poll();    
            char maxOcc1 = (char) maxOccurrance[0];
            int n = sb.length();

            if (n >= 2 
            && sb.charAt(n - 1) == maxOcc1 
            && sb.charAt(n - 2) == maxOcc1) {
                if (maxHeap.isEmpty()) {
                    break;  
                }

                //now look for next best possible option
                int[] secondMaxOccuranceArray = maxHeap.poll();
                char secondMaxChar = (char) secondMaxOccuranceArray[0];
                sb.append(secondMaxChar);
                //1 hataya us array se
                secondMaxOccuranceArray[1]--;
                //naya count assign kara heap ko
                if (secondMaxOccuranceArray[1] > 0) {
                    maxHeap.offer(secondMaxOccuranceArray);
                }
                //most important step
                //since 2nd most sb me nikal gaya, max firse available hua
                //so firse put kara
                maxHeap.offer(maxOccurrance);

            } else {
                
                sb.append(maxOcc1);
                //1 hataya
                maxOccurrance[1]--;
                //naya count assign kara heap ko
                if (maxOccurrance[1] > 0) {
                    maxHeap.offer(maxOccurrance);
                }
            }
        }

        return sb.toString();
    }
}
