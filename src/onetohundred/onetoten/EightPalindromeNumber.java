package onetohundred.onetoten;

public class EightPalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        String s = String.valueOf(x);
        if(s.length() == 1){
            return true;
        }

        int i=0, j=s.length()-1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
