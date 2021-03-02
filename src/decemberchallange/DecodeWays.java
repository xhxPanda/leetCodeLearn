package decemberchallange;

import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
    public int numDecodings(String s) {
        Set<String> strs = new HashSet<>();
        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i+1; j < i+3; j++) {
                strs.add(s.substring(i, j));
            }
        }
        
        int num = 0;
        for(String k : strs) {
            if(k.isEmpty()) {
                continue;
            }
            if(Integer.valueOf(k) <= 26) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        DecodeWays s = new DecodeWays();
        s.numDecodings("226");
    }
}