class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            //System.out.println(sortedStr);
            
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());

            
             anagramMap.get(sortedStr).add(str);
             //System.out.println(anagramMap);
        }
        //return null;
        return new ArrayList<>(anagramMap.values());
        
    }
}