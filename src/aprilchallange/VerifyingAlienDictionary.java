package aprilchallange;

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length == 0 || order == null || order.length() == 0) {
            return false;
        }
        int[] map = new int[26];
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            map[c - 'a'] = i;
        }

        for(int i = 0; i < words.length-1; i++) {
            if(compare(words[i], words[i+1], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String first, String second, int[] map) {
        int n = first.length();
        int m = second.length();
        for(int i = 0, j = 0; i < n && j < m; i++,j++){
            if(first.charAt(i) != second.charAt(j)) {
                return map[first.charAt(i) - 'a'] > map[second.charAt(j) - 'a'];
            }
        }
        return n-m > 0;
    }
}
