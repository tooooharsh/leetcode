class Solution {
     private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
     }
       
    public boolean canMeasureWater(int x, int y, int target) {

        if(target> x+y) return false;

        return target % gcd(x, y) == 0;


        

    }
}