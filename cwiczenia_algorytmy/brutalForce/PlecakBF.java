package cwiczenia_algorytmy.brutalForce;

public class PlecakBF {

    public static void main(String[] args) {

        int N = 6;
        int MAXV = 10;

        int[] V = {6, 2, 3, 2, 3, 1};
        int[] W = {6, 4, 5, 7, 10, 2};
        System.out.println(Plecak(N, MAXV, V, W));

    }

    static int Plecak(int N, int MAXV, int[] V, int[] W) {

        int maxW = 0;
        int v = 0;
        int w = 0;
        int[] tab = new int[N];
        int p1, p2, p3, p4, p5, p6;

        for (p1 = 0; p1 <= 1; p1++) {
            for (p2 = 0; p2 <= 1; p2++) {
                for (p3 = 0; p3 <= 1; p3++) {
                    for (p4 = 0; p4 <= 1; p4++) {
                        for (p5 = 0; p5 <= 1; p5++) {
                            for (p6 = 0; p6 <= 1; p6++) {
                                v = p1 * V[0] + p2 * V[1] + p3 * V[2] + p4 * V[3] + p5 * V[4] + p6 * V[5];
                                if (v <= MAXV) {
                                    w = p1 * W[0] + p2 * W[1] + p3 * W[2] + p4 * W[3] + p5 * W[4] + p6 * W[5];
                                }
                                if (w > maxW) {
                                    maxW = w;
                                    tab[0] = p1;
                                    tab[1] = p2;
                                    tab[2] = p3;
                                    tab[3] = p4;
                                    tab[4] = p5;
                                    tab[5] = p6;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Dla przedmiotow:");
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("Najwieksza wartosc to:");
        return maxW;
    }

}
