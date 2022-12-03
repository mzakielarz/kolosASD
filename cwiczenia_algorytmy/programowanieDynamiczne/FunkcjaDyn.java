package cwiczenia_algorytmy.programowanieDynamiczne;

public class FunkcjaDyn {
    public static void main(String[] args) {
        final int N = 9; // n-ty wyraz ciągu
        System.out.println(Rekur(N));
    }

    static int Rekur(int n) {

        int[] tab = new int[n + 1];
        tab[1] = 1;
        if (n > 1) {
            tab[2] = 1;
        }
        for (int i = 3; i < tab.length; i++) {
            if (i % 3 == 0) {
                tab[i] = 2 * tab[i - 1];
            } else if (i % 3 == 1) {
                tab[i] = (int) Math.pow(tab[i - 2], 2);
            } else if (i % 3 == 2) {
                tab[i] = (int) Math.pow(2, tab[i - 3]);
            }
        }

        for (int j = 1; j < tab.length; j++) {
            System.out.print(tab[j] + " ");
        }
        System.out.println();
        System.out.println("Najwieksza wartosc: ");
        return tab[tab.length - 1];
    }
}

