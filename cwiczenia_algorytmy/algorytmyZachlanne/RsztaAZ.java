package cwiczenia_algorytmy.algorytmyZachlanne;

import java.util.Scanner;

public class RsztaAZ {
    public static void main(String[] args) {

        int[] M = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] L = {7, 0, 1, 1, 4, 1, 4, 7, 30};

        reszta(M, L);
    }

    static void reszta(int[] M, int[] L) {

        Scanner scanner = new Scanner(System.in);

        int zl, gr, r, i = 0;
        int[] zlicznaie = new int[M.length];

        System.out.println("Podaj reszte...");
        System.out.print("Zlote: ");
        zl = scanner.nextInt();
        System.out.print("Grosze: ");
        gr = scanner.nextInt();
        System.out.print("Reszta: ");
        r = zl * 100 + gr;

        while (r > 0 && i < M.length) {
            if (r >= M[i] && L[i] > 0) {
                System.out.print(M[i] / 100.0 + " ");
                zlicznaie[i]++;
                r = r - M[i];
                L[i]--;
            } else {
                i++;
            }
        }
        System.out.println();
        System.out.println("Liczba wydanych monet: ");
        System.out.print("Nominal:       Liczba monet:\n");
        for (int j = 0; j < M.length; j++) {
            System.out.println(M[j] / 100.0 + "         " + zlicznaie[j]);
        }

        if (r > 0) {
            System.out.println("Nie udalo sie wydac reszty! Zostalo: " + r / 100.0 + " zl");
        }
    }
}
