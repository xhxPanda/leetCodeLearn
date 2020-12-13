package onetohundred.elevenToTwenty;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> strList = new ArrayList<String>();
        build(strList, "", 0, 0, n);
        return strList;
    }
    
    public void build(List<String> list, String str, int i, int j, int n){
        if(str.length() == n*2){
            list.add(str);
            return;
        }
        if(i < n){
            build(list, str+"(", i+1, j, n);
        }
        if(j < i){
            build(list, str+")", i, j+1, n);
        }
    }
}