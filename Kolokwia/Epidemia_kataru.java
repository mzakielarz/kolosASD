package Kolokwia;

public class Epidemia_kataru {
    public static void main(String[] args) {
        final double populacja = 100000;
        double[] tab = new double[1000];
        double odporni=0;
        tab[1] = 10;

        for (int i=2;i<tab.length;i++) {
            tab[i] = 2*tab[i-1];

            if (i>=8) {
                tab[i] -= tab[i-7];
                odporni += tab[i-7];
            }

            if (tab[i]> (populacja-odporni)) {
                tab[i] = populacja-odporni;
            }

            if (tab[i]>populacja/2) {
                System.out.println("Na katar zachoruje ponad pol populacji " + i + " dnia, beidzie wtedy " + tab[i] + " zarazonych");
                break;
            }
            System.out.println("Dzien "+i+" chorych: "+tab[i]);
        }
    }
}
