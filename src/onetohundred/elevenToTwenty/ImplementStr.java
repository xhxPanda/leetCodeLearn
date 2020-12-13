package onetohundred.elevenToTwenty;

public class ImplementStr {
    public int strStr(String haystack, String needle) {
         if(haystack.length()==0 && needle.length()==0)
            return 0;
        if(needle.length()==0)
            return 0;
        if(haystack.length()==needle.length())
            return haystack.equals(needle)?0:-1;
        
        for(int i=0;i<haystack.length();i++){
            if(haystack.substring(i,haystack.length()).startsWith(needle)){
                return i;
            }
        }
        
        return -1;
    }
}