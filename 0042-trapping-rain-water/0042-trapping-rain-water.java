class Solution {

    public int trap(int[] height) {

    // int n = height.length;
    // int sum = 0;

    // int[] left = new int[n];
    // int[] right = new int[n];

    // int maxLeft = 0;
    // int maxRight = 0;

    // for (int i = 0; i < n; i++) {
    //     maxLeft = Math.max(maxLeft, height[i]);
    //     left[i] = maxLeft;
    // }

    // for (int i = n - 1; i >= 0; i--) {
    //     maxRight = Math.max(maxRight, height[i]);
    //     right[i] = maxRight;
    // }

    // for (int i = 0; i < n; i++) {
    //     int minHeight = Math.min(left[i], right[i]);
    //     sum += minHeight - height[i];
    // }

    // return sum;


 int n = height.length -1;
        int left = 0;
        int right = n;
        int area = 0;
        int maxArea = 0;
        int lmax =0;
        int rmax=0;
        
        while(left<right){
            if(height[left]< height[right]){
                if(height[left]>lmax){
                    lmax= height[left];
                }else{
                    // area= (Math.min(rmax,lmax) - height[left])* (right - left);
                    // maxArea = Math.max(area, maxArea);
                    area += lmax - height[left];
                }
                left++;
            }else{
               
                if(height[right]>rmax){
                    rmax= height[right];
                }else{
                    // area= (Math.min(rmax,lmax) - height[left])* (right - left);
                    // maxArea = Math.max(area, maxArea);
                    area+= rmax - height[right];
                }
                right--;
                
            }
            
        }
        
        return area;
        

    
}
}