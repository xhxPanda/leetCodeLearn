package janchallange;

public class ConcatenationConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        long sum = 0;

        for(int i = 1; i <= n; i++){
            sum = ((sum << Integer.toBinaryString(i).length()) + i) % 1000000007;
        }

        return (int) sum;
    }
}
