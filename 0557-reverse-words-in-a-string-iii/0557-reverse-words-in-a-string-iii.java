class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : str) {
            String reversedWord = reverseWord(word);
            result.append(reversedWord).append(" ");
        }
        return result.toString().trim();
    }

    public String reverseWord(String word){
        char[] chars = word.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
}