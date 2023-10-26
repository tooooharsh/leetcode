class Solution {
    public void rotate(int[] arr, int d) {
    // int n = arr.length;  // 1,2,3,4,5. d= 3
    // helper(arr, 0, d - 1); // first reverse till d ->  3,2,1,4,5
    // helper(arr, d, n - 1); // then reverse d to n -> 3,2,1,5,4
    // helper(arr, 0, n - 1); // now reverse entire -> 4,5,1,2,3

        int n = arr.length;  // 1,2,3,4,5. d= 3
        d = d % n; // In case d is larger than the length of the array

        helper(arr, 0, n - 1);  // Reverse the entire -> 54321
        helper(arr, 0, d - 1);  // Reverse till d -> 34521
        helper(arr, d, n - 1);  // Reverse d to n -> 34512
}

public static void helper(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
    
}