package algorytmy;

import java.util.Random;

public class LodyMC {
    public static void main(String[] args) {
        int losowania = 100;
        f(losowania);
    }

    static void f(int losowania) {

        final int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };

        Random random = new Random();
        int minSuma = Integer.MAX_VALUE;
        String najlepszeRozwiazanie = "";
        int start = -1;

        for (int i = 0; i < losowania; i++) {
            int suma = 0;
            String rozwiazanie = "";
            int wiersz = random.nextInt(koszty.length);
            int globalWiersz = wiersz;
            rozwiazanie += wiersz + 1 + " ";
            boolean[] zrobione = new boolean[koszty.length];
            zrobione[wiersz] = true;

            while (true) {
                int smak = random.nextInt(zrobione.length);
                if (!zrobione[smak] && koszty[wiersz][smak] > 0) {
                    suma += koszty[wiersz][smak];
                    zrobione[smak] = true;
                    wiersz = smak;
                    rozwiazanie += wiersz + 1 + " ";
                }

                boolean wszystko = true;
                for (int j = 0; j < zrobione.length; j++) {
                    if (!zrobione[j]) {
                        wszystko = false;
                    }
                }

                if (wszystko) {
                    if (minSuma > suma) {
                        minSuma = suma + koszty[wiersz][globalWiersz];
                        najlepszeRozwiazanie = rozwiazanie;
                        start = globalWiersz;
                    }
                    break;
                }
            }
        }
        System.out.println("Smaki w kolejnosci: " + najlepszeRozwiazanie + (start + 1));
        System.out.println("Koszt: " + minSuma);
    }
}

