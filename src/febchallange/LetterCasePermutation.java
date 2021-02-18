package febchallange;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> solution(String S) {
        List<String> res = new ArrayList<>();
        
        helper(S, 0, res, "");
        return res;
    }
    
     void helper(String str, int index, List<String> res, String curr){
        if(curr.length() == str.length()) {
            res.add(new String(curr));
            return;
        }
        if(index>=str.length()) return;
        
        char c = str.charAt(index);
        
        // exclude
        helper(str, index+1, res, curr+c);
        
        // include
        // for digit, nothing to do
        
        if(Character.isLowerCase(c)) {
            curr+=(char)(c-'a'+'A');
        }
        else if(Character.isUpperCase(c)) {
            curr+=(char)(c-'A'+'a');
        }
		
		helper(str, index+1, res, curr);

    }
}