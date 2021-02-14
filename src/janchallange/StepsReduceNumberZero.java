package janchallange;

public class StepsReduceNumberZero {
    public int numberOfSteps (int num) {
        if(num < 3) return num;
        int step = 0;
        while(num != 0) {
            step ++;
            step += num & 1;
            num >>= 1;
        }
 
        return step - 1;
    }
}