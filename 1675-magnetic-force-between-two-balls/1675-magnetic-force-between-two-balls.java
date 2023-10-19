class Solution {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int len = position.length;
        int left = 0;
        int right = position[len-1] - position[0];
        int output = -1;

        while(left<=right){

            int mid = left + (right-left)/2;

            if(helper(position, mid, m)){
                output = mid;
                left= mid+1;
            }else{
                right = mid-1;
            }

        }

        return output;

        
    }


    public boolean helper(int[] position, int mid, int m){

        int currentPosition = position[0];
        int count = 1;
        int n = position.length;

        for(int i=0; i<n; i++){
            if((position[i]-currentPosition)>= mid){
                count++;
                currentPosition = position[i];
            }
        }


        return count >= m;


    }




}