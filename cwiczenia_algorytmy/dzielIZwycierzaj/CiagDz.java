package cwiczenia_algorytmy.dzielIZwycierzaj;

public class CiagDz {

    public static void main(String[] args) {
        int N = 5;
        System.out.println(ciag(N));
    }

    static int ciag(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 3;
        } else {
            return ciag(n - 1) + ciag(n - 2);
        }
    }
}
