package onetohundred.onetoten;

import java.util.Arrays;

public class SixZigZagConversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        if(len == 0 || numRows <= 1) {
            return s;
        }
        String[] ans = new String[numRows];
        Arrays.fill(ans, "");

        int row = 0;
        int de = 1;
        for (int i=0; i<s.length();i++){
            ans[row] += s.charAt(i);
            row += de;
            if(row > numRows) {
                row = numRows - 2;
                de = -1;
            }
            if(row < 0) {
                row = 1;
                de = 1;
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            buffer.append(ans[i]);
        }

        return buffer.toString();
    }
}
