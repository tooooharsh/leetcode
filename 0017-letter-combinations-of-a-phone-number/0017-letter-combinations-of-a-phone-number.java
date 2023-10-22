class Solution {
    public List<String> letterCombinations(String digits) {

        TreeMap<Character, String> phoneMap = new TreeMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        // Input: digits = ""
        // Output: []
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }



        helper(digits, 0, phoneMap, "", combinations);

        return combinations;
        
    }

    private void helper(String digits, int index, TreeMap<Character, String> phoneMap, String current, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(current);
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        for (char letter : letters.toCharArray()) {
            helper(digits, index + 1, phoneMap, current + letter, combinations);
        }
    } 
}