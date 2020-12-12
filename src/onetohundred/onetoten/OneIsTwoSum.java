package onetohundred.onetoten;

public class OneIsTwoSum {
    public int[] handle(int[] numbs, int target) {
        int[] a = new int[2];
        for(int i=0; i<numbs.length; i++){
            for(int j=i+1; j<numbs.length; j++){
                if(numbs[i] + numbs[j] == target){
                    a[0] = j;
                    a[1] = i;
                    break;
                }
            }
        }
        return a;
    }
}
