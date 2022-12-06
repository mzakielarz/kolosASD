package Kolokwia;

public class Komary {
    public static void komary(int cykl, double wszystkie, double samce, double samice) {
        if (samce>=samice) {
            System.out.println("Liczba samcow przekroczy liczbe samic po " + cykl + " tygodniach");
            System.out.println("Bedzie wtedy " + wszystkie + " komarow");
        }
        else {
            double przyrost = wszystkie * 1.1;
            double roznica = przyrost-wszystkie;
            samce += 0.45 * roznica;
            samice += 0.55 * roznica;
            samce *= 0.98;
            samice *= 0.95;
            komary(cykl+1, samce+samice, samce, samice);
        }
    }

    public static void main(String[] args) {
        final int SAMCE = 450;
        final int SAMICE = 550;

        komary(1, SAMCE+SAMICE, SAMCE, SAMICE);
    }
}
