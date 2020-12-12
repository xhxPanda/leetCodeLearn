package decemberchallange;

public class RemoveDuplicatesTwo {
    public int removeDuplicates(int[] numbs) {
        int i = 0;
        for (int num : numbs) {
            if (i < 2 || num > numbs[i - 2]) {
                numbs[i++] = num;
            }
        }
        return i;
    }
}
