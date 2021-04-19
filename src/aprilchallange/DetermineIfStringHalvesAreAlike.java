package aprilchallange;

public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        String st = "aeiouAEIOU";
        int fir = 0, sec = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i < s.length() / 2) {
                fir += (st.indexOf(s.charAt(i)) >= 0 ? 1 : 0);
            }
            else sec += (st.indexOf(s.charAt(i)) >= 0 ? 1 : 0);
        }
        return fir == sec;
    }
}
