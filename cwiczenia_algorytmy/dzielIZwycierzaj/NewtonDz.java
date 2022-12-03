package cwiczenia_algorytmy.dzielIZwycierzaj;

public class NewtonDz {
    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        System.out.println(newton(N, K));
    }

    static int newton(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return newton(n - 1, k - 1) + newton(n - 1, k);
        }
    }
}
