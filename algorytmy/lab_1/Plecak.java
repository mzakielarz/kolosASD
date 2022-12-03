package algorytmy.lab_1;

public class Plecak {

    final static int N = 6;
    final static int MAXV = 10;

    final static int[] V = {6, 2, 3, 2, 3, 1};
    final static int[] W = {6, 4, 5, 7, 10, 2};

    public static void main(String[] args) {
        int maxW = 0;
        int v, w = 0;
        int b1, b2, b3, b4, b5, b6;
        int[] tab = new int[N];
        for (b1 = 0; b1 <= 1; b1++) {
            for (b2 = 0; b2 <= 1; b2++) {
                for (b3 = 0; b3 <= 1; b3++) {
                    for (b4 = 0; b4 <= 1; b4++) {
                        for (b5 = 0; b5 <= 1; b5++) {
                            for (b6 = 0; b6 <= 1; b6++) {
                                v = b1 * V[0] + b2 * V[1] + b3 * V[2] + b4 * V[3] + b5 * V[4] + b6 * V[5];
                                if (v <= MAXV) {
                                    w = b1 * W[0] + b2 * W[1] + b3 * W[2] + b4 * W[3] + b5 * W[4] + b6 * W[5];
                                }
                                if (w > maxW) {
                                    maxW = w;
                                    tab[0] = b1;
                                    tab[1] = b2;
                                    tab[2] = b3;
                                    tab[3] = b4;
                                    tab[4] = b5;
                                    tab[5] = b6;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Wartosc przedmiotow w plecaku to: " + maxW);
        System.out.println("W plecaku sa przedmioty o numerach: ");
        for (int i = 0; i < N; i++) {
            if (tab[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }
}
