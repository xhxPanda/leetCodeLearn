package marchallange;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyURLSolution {
    Map<String, String> map = new HashMap<>();

    public String encode(String longUrl) {
        char[] arr = new char[2];
        arr[0] = longUrl.charAt(0);
        arr[1] = longUrl.charAt(longUrl.length() - 1);
        String d = new String(arr);
        map.put(longUrl, d);
        return d;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(shortUrl))
                s.append(entry.getKey());
        }
        return s.toString();
    }
}
