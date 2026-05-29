class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int n = nums.length;

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i=2; i< n; i++){
            int l1= arr1.get(arr1.size() -1);
            int l2= arr2.get(arr2.size() - 1);

            if(l1<l2){
                arr2.add(nums[i]);
            }else{
                arr1.add(nums[i]);
            }
        }

        int[] ans = new int[n];
        int k = 0;

        for (int num : arr1) {
            ans[k++] = num;
        }

        for (int num : arr2) {
            ans[k++] = num;
        }

        return ans;
        
    }
}