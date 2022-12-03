package cwiczenia_algorytmy.dzielIZwycierzaj;

public class CiagDz2 {
    public static void main(String[] args) {
        double N = 8;
        System.out.println(ciag(N));
    }

    static double ciag(double n) {
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 4;
        } else {
            return (ciag(n - 1) * ciag(n - 2)) / 2;
        }

    }
}
