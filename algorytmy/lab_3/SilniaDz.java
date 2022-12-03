package algorytmy.lab_3;

public class SilniaDz {
    public static void main(String[] args) {
        final int N = 5; // liczymy n!
        System.out.println(silnia(N));
    }

    static int silnia(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * silnia(n - 1);
    }
}