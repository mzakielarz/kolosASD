package cwiczenia_algorytmy.programowanieDynamiczne;

public class KomaryDyn {
    public static void main(String[] args) {
        komary();
    }

    static void komary() {

        double[] lSamcow = new double[100];
        double[] lSamic = new double[100];
        double[] populacja = new double[100];

        populacja[0] = 1000.0;
        lSamcow[0] = 450.0;
        lSamic[0] = 550.0;

        System.out.println(0 + " dzien) Samce: " + lSamcow[0] + " samice: " + lSamic[0] + " populacja: " + populacja[0]);

        int tygodnie = 30;
        for (int i = 1; i < tygodnie; i++) {

            if (lSamcow[i - 1] < lSamic[i - 1]) {
                populacja[i] = (int) (populacja[i - 1] + populacja[i - 1] * 0.1);
                double[] przyrost = new double[100];
                przyrost[i] = populacja[i - 1] * 0.1;

                double przyrostSamcow = przyrost[i] * 0.45;
                double przyrostSamic = przyrost[i] * 0.55;

                lSamcow[i] = (int) (lSamcow[i - 1] + przyrostSamcow);
                lSamic[i] = (int) (lSamic[i - 1] + przyrostSamic);

                double spadekSamcow = lSamcow[i - 1] * 0.02;
                double spadekSamic = lSamic[i - 1] * 0.05;

                lSamcow[i] = (int) (lSamcow[i - 1] + przyrostSamcow - spadekSamcow);
                lSamic[i] = (int) (lSamic[i - 1] + przyrostSamic - spadekSamic);

                System.out.println(i + " dzien) Samce: " + lSamcow[i] + " samice: " + lSamic[i] + " populacja: " + populacja[i]);

            } else if (lSamcow[i] == lSamic[i]) {
                System.out.println("Liczba samic i samcow zrowanala sie po: " + i + " tygodniach");
                System.out.println(i + " dzien) Samce: " + lSamcow[i] + " samice: " + lSamic[i] + " populacja: " + populacja[i]);
            } else if (lSamcow[i] == 0 || lSamic[i] == 0) {
                System.out.println("Liczba samic i samcow nie zrowna sie!");
                break;
            } else {
                System.out.println("Liczba samic i samcow nie zrowna sie!");

            }
        }

    }
}
