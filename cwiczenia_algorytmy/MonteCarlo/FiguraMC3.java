package cwiczenia_algorytmy.MonteCarlo;

import java.util.Random;

public class FiguraMC3 {

    public static void main(String[] args) {
        figura(100.0);
    }

    static void figura(double losowania) {

        Random random = new Random();
        int licz = 0;
        int min = 400;
        int max = 1100;

        for (int i = 0; i < losowania; i++) {
            double x = random.nextInt(701) / 1000.0;
            double y = (random.nextInt(max - min + 1) + min) / 1000.0;
            if (y <= Math.pow((x / 10.0), x)) {
                licz++;
            }
        }
        System.out.println("Pole: " + licz / losowania);
    }
}
