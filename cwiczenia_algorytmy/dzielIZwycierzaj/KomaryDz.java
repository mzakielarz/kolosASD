package cwiczenia_algorytmy.dzielIZwycierzaj;

public class KomaryDz {
    public static void main(String[] args) {
        double liczbaSamcow = 450;
        double liczbaSamic = 550;
        int time = 1;
        komar(liczbaSamcow, liczbaSamic, time);
    }

    static void komar(double liczbaSamcow, double liczbaSamic, int time) {

        double populacja = liczbaSamcow + liczbaSamic;
        if (liczbaSamcow < liczbaSamic) {
            time++;
            double przyrost = populacja * 0.1;

            double przyrostLiczbySamcow = przyrost * 0.45;
            double przyrostLiczbySamic = przyrost * 0.55;

            double spadekLiczbySamcow = liczbaSamcow * 0.02;
            double spadekLiczbySamic = liczbaSamic * 0.05;

            liczbaSamcow = liczbaSamcow - spadekLiczbySamcow + przyrostLiczbySamcow;
            liczbaSamic = liczbaSamic - spadekLiczbySamic + przyrostLiczbySamic;

            populacja = liczbaSamcow + liczbaSamic;

            System.out.println("Tydzien: " + time);
            System.out.println("Liczebnosc populacji: " + (int) populacja);
            System.out.println("Liczba samcow w populacji: " + (int) liczbaSamcow);
            System.out.println("Liczba samic w populacji: " + (int) liczbaSamic);

            komar(liczbaSamcow, liczbaSamic, time);

        } else if (liczbaSamcow == liczbaSamic) {
            System.out.println("Liczba samic i  samcow w populacji zrownala sie po: " + time + "tygodniach");
        } else System.out.println("Liczebnosc samcow i samic nie zrowna sie");
    }
}

