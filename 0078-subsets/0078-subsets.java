class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrackHelper(output, new ArrayList<>(), nums, 0);
        return output;


        
    }

    public void backtrackHelper(List<List<Integer>> outputSet,
     List<Integer> tempSet, int[] nums, int start ){

        //outputSet.add(new ArrayList<Integer>(tempSet));
        outputSet.add(new ArrayList<>(tempSet));
        for(int i= start; i< nums.length; i++){

            //ya to lo

            tempSet.add(nums[i]);

            backtrackHelper(outputSet, tempSet, nums, i+1);

            //i+1 kyu ki current index is included
            

            //ya mat lo (if dont take mean last wala nai liya so wo nikala)
            tempSet.remove(tempSet.size()-1);

        }

    }
}