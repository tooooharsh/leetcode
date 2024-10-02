class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        helper(0,target, output, new ArrayList<>(), candidates);
        return output;
        
    }

    public void helper(int start, int target, List<List<Integer>> output,
                         List<Integer>temp, int[] candidates ){



       if(target == 0){

        // idea is temp me add karte jaao kitni bhi baar
        //unless condition meet nai karenga wo output me nai jayega
         output.add(new ArrayList<>(temp));
       }

       if(target < 0){
        return;
       }
      

       for(int i=start; i<candidates.length; i++){


           temp.add(candidates[i]);
           //why i and not i+1? kitne baar bhi i le sakte hai
           //just minus that occarance from target
           helper(i, target - candidates[i], output, temp, candidates);
           temp.remove(temp.size()-1);

       }                     

    }
}