class Solution {
    public List<String> topKFrequent(String[] words, int k) {

          Map<String, Integer> stringCountMap = new HashMap<>();
        for (String str : words) {
            stringCountMap.put(str, stringCountMap.getOrDefault(str, 0) + 1);
        }

        List<String> uniqueWords = new ArrayList<>(stringCountMap.keySet());

        Collections.sort(uniqueWords, (word1, word2) -> {
            int count1 = stringCountMap.get(word1);
            int count2 = stringCountMap.get(word2);
            if (count1 != count2) {
                return count2 - count1; 
            } else {
                return word1.compareTo(word2); 
            }
        });

        return uniqueWords.subList(0, k);
    }

        //  Map<String, Integer> stringCountMap = new HashMap<>();
        //  for (String str : words) {
        //     if (stringCountMap.containsKey(str)) {
        //         int count = stringCountMap.get(str);
        //         stringCountMap.put(str, count + 1);
        //     } else {
        //         stringCountMap.put(str, 1);
        //     }
        // }

        //  ArrayList<String> stringList = new ArrayList<>();

       

        // for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
        //     int count = entry.getValue();
        //     if(count == k){
        //         stringList.add(entry.getKey());
        //     }
        // }

        // Collections.sort(stringList);

        // return stringList;


        
    
}