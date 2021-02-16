package learnsomething;

public class Hanoilmpl {

    private void hanoi(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("move:"+a+"-->"+c);
        } else {
            hanoi(n - 1, a,c,b);
            System.out.println("move:"+a+"-->"+c);
            hanoi(n-1, b,a,c);
        }
    }

}