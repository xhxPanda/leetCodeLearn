package janchallange;

import java.util.Arrays;

public class BoatSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int result = 0;

        while (left < right) {
            result++;
            if(people[left] == people[right]) {
                left++;
            }
            right--;
        }

        return result;
    }
}
