package cwiczenia_algorytmy;

public class FunkcjaDyn {
    public static void main(String[] args) {
        int N = 9;
        System.out.println(funkcja(N));
    }

    static int funkcja(int n) {

        int[] tab = new int[n + 1];
        tab[1] = 1;
        if (n > 1) {
            tab[2] = 1;
        }

        for (int i = 3; i < tab.length; i++) {
            if (i % 3 == 0) {
                tab[i] = 2 * tab[i - 1];
            }
            if (i % 3 == 1) {
                tab[i] = (int) Math.pow(tab[i - 2], 2);
            }
            if (i % 3 == 2) {
                tab[i] = (int) Math.pow(2, tab[i - 3]);
            }
        }
        System.out.println("ciag:");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        System.out.println("n-ty wyraz ciagu: ");
        return tab[tab.length - 1];
    }
}
