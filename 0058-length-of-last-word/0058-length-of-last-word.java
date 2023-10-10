class Solution {
    public int lengthOfLastWord(String s) {

        String[] str= s.split("\\s+");
        int len = str.length;
    if (len > 0) {
        String lastWord = str[len - 1];
        return lastWord.length();
    } else {
        return 0; 
    }
    }
}