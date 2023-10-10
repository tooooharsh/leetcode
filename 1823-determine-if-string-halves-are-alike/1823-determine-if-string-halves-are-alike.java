class Solution {

    public boolean isVowel(char c){
        if(c== 'a' || c== 'e' || c== 'i' || c== 'o' || c== 'u' || c== 'A' || c== 'E' || c== 'I' || c== 'O' || c== 'U'){
            return true;
        }
        return false;
        }
    

    public boolean halvesAreAlike(String s) {

    int length = s.length();
    int mid = length / 2;
    int countA = 0;
    int countB = 0;

    for (int i = 0; i < length; i++) {
        char c = s.charAt(i);
        if (isVowel(c)) {
            if (i < mid) {
                countA++;
            } else {
                countB++;
            }
        }
    }

    return countA == countB;

        
    }
}