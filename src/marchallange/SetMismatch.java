package marchallange;

import java.util.HashSet;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        int corSum = (1 + nums.length) * nums.length / 2;
        int sum = 0;  
        
         for(int num: nums){
             if(set.contains(num)) {
                 res[0] = num;
             } else {
                 set.add(num);
                 sum+=num;
             }
         }
        res[1] = corSum - sum;
        return res;  
    }
}