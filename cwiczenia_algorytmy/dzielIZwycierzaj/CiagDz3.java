package cwiczenia_algorytmy.dzielIZwycierzaj;

public class CiagDz3 {
    public static void main(String[] args) {
        int N = 5;
        System.out.println(ciag(N));
    }

    static int ciag(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return (ciag(n - 1) * ciag(n - 2)) * 3;
        }
    }
}
