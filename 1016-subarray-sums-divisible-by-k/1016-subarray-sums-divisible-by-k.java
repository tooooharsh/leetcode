class Solution {
    public int subarraysDivByK(int[] nums, int k) {


        //.        4 5 0 -2 -3 1
        //sum 0.   4 9 9  7  4 5
        //rem 0.   4 4 4. 2. 4 0
        // if rem negative, do +k



        int ans =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int rem =0;

        for(int i=0; i< nums.length; i++){
            sum+= nums[i];
            rem = sum %k;
            if(rem<0){
                rem+=k;
            }

            if(map.containsKey(rem)){
                ans+= map.get(rem);
                map.put(rem, map.get(rem)+1);
            }else{
                map.put(rem,1);
            }

        }

        return ans;


        
    }
}