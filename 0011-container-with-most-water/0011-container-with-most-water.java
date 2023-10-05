class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length -1;
        int max= 0;

        while (left < right) {
        int lleft = height[left];
        int lright = height[right];
        int horizontal = right - left; 

        int min = Math.min(lleft, lright);
        int area = horizontal * min;
        max = Math.max(max, area);

        if (lleft < lright) {
            left++;
        } else {
            right--;
        }
    }

        return max;
        
    }
}