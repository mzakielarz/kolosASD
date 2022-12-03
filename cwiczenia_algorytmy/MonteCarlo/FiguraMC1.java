package cwiczenia_algorytmy.MonteCarlo;

import java.util.Random;

public class FiguraMC1 {
    public static void main(String[] args) {
        figura(100.0);
    }

    static void figura(double losowania){

        Random random = new Random();
        int licz = 0;

        for (int i =0;i<losowania;i++){
            double x = random.nextInt(1001)/1000.0;
            double y = random.nextInt(1001)/1000.0;
            if (y <= Math.pow(x, 2)) {
                licz++;
            }
        }
        System.out.println("Pole: " + licz/losowania);
    }
}
