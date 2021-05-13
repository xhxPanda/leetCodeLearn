package decemberchallange;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> resultList = new ArrayList<>();
    List<String> currList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return resultList;
    }

    private void backTrack(String s, int l) {
        if (currList.size() > 0 && l >= s.length()) {
            List<String> r = new ArrayList<>(currList);
            resultList.add(r);
        }

        for (int i = l; i < s.length(); i++) {
            if(isPalindrome(s, l, i)) {
                if(l == i) {
                    currList.add(Character.toString(s.charAt(i)));
                } else {
                    currList.add(s.substring(l, i+1));
                }
                backTrack(s, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
