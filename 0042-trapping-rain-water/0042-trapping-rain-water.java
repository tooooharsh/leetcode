class Solution {

    public int trap(int[] height) {
    int n = height.length;
    int sum = 0;

    int[] left = new int[n];
    int[] right = new int[n];

    int maxLeft = 0;
    int maxRight = 0;

    for (int i = 0; i < n; i++) {
        maxLeft = Math.max(maxLeft, height[i]);
        left[i] = maxLeft;
    }

    for (int i = n - 1; i >= 0; i--) {
        maxRight = Math.max(maxRight, height[i]);
        right[i] = maxRight;
    }

    for (int i = 0; i < n; i++) {
        int minHeight = Math.min(left[i], right[i]);
        sum += minHeight - height[i];
    }

    return sum;
}

    
}