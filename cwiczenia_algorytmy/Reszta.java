package cwiczenia_algorytmy;

import java.util.Scanner;

public class Reszta {

    final static double[] NOMINALY = {5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};

    public static void main(String[] args) {

        double reszta = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj reszte: ");

        reszta = scanner.nextDouble();

        String wynik = "Reszta:\n";

        for (int i = 0; i < NOMINALY.length; i++) {
            if (reszta >= NOMINALY[i]) {
                int obl = (int) Math.floor(reszta / NOMINALY[i]);
                wynik += NOMINALY[i] + " PLN x " + obl + "\n";
                reszta = (double) Math.round(100 * (reszta - (obl * NOMINALY[i]))) / 100;
            }
        }
        System.out.println(wynik);
    }
}
