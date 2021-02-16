package learnsomething;

public class RabinKarp {
    public int handle(String str, String pattern) {
        int size1 = str.length();
        int size2 = pattern.length();

        // 哈希的时候需要用到进制计算，这里只涉及到26个字母所以使用26进制
        int d = 26;

        // 防止hash之后的值超出int范围，对最后的hash值取模
        // q取随机素数，满足q*d < INT_MAX就可以了
        int q = 144451;

        // str字串的hash值
        int strCode = str.charAt(0) - 'a';
        // pattern的hash值
        int patternCode = pattern.charAt(0) - 'a';
        // d的size2-1的幂，hash计算的上海公式会用到
        int h = 1;

        // 计算sCode，pCode，h
        for (int i = 1; i < size2; i++) {
            patternCode = (d * patternCode + pattern.charAt(i) - 'a' % q);
            // 计算第一个个字串的hash
            strCode = (d * strCode + str.charAt(i) - 'a') % q;
            h = (h * d) % q;
        }

        return -1;
    }
}
