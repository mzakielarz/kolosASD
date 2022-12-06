package Programowanie_dynamiczne;

public class A23_Przebieg_epidemii {
    public static void main(String[] args) {
        final int populacja = 100000;
        int[] tab = new int[100];
        int odporni = 0;

        tab[1] = 10;

        for (int i=2;i<tab.length;i++) {
            tab[i] = 3*tab[i-1];

            if (i>=8) {
                odporni += tab[i-7];
                tab[i] -= tab[i-7];
            }

            if (i>=22) {
                odporni -= tab[i-14];
            }

            if (tab[i]>populacja-odporni) {
                tab[i] = populacja-odporni;
            }

            if (tab[i]<=0) {
                System.out.println("Koniec " + i + " dnia");
                break;
            }
        }
    }
}
