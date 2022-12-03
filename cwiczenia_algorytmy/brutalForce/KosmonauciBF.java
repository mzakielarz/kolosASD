package cwiczenia_algorytmy.brutalForce;

import algorytmy.lab_1.Kosmonauci;

public class KosmonauciBF {
    public static void main(String[] args) {
        int N = 5;

        int[][] astronaci = {
                {1, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        System.out.println(Kosmonauci(N, astronaci));
    }


    static int Kosmonauci(int N, int[][] astronaci) {

        int pracaA, pracaB, pracaC, pracaD;
        int k1, k2, k3, k4, k5;
        int[] tab = new int[N];

        for (k1 = 0; k1 <= 1; k1++) {
            for (k2 = 0; k2 <= 1; k2++) {
                for (k3 = 0; k3 <= 1; k3++) {
                    for (k4 = 0; k4 <= 1; k4++) {
                        for (k5 = 0; k5 <= 1; k5++) {
                            pracaA = k1 * astronaci[0][0] + k2 * astronaci[1][0] + k3 * astronaci[2][0] + k4 * astronaci[3][0] + k5 * astronaci[4][0];
                            pracaB = k1 * astronaci[0][1] + k2 * astronaci[1][1] + k3 * astronaci[2][1] + k4 * astronaci[3][1] + k5 * astronaci[4][1];
                            pracaC = k1 * astronaci[0][2] + k2 * astronaci[1][2] + k3 * astronaci[2][2] + k4 * astronaci[3][2] + k5 * astronaci[4][2];
                            pracaD = k1 * astronaci[0][3] + k2 * astronaci[1][3] + k3 * astronaci[2][3] + k4 * astronaci[3][3] + k5 * astronaci[4][3];
                            if (pracaA == 1 && pracaB == 1 && pracaC == 1 && pracaD == 1) {
                                tab[0] = k1;
                                tab[1] = k2;
                                tab[2] = k3;
                                tab[3] = k4;
                                tab[4] = k5;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Poleca astronauci: ");
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 1) {
                System.out.println("k" + (i+1));
            }
        }
        return 0;
    }
}
