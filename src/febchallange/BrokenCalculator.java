package febchallange;

public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (Y != X) {
            if (X >Y) return X - Y + count;
            
            if (Y % 2 != 0) Y += 1;
            else Y /= 2;
            
            count++;
        }
        
        return count;
    }
}