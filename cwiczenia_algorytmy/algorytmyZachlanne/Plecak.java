package cwiczenia_algorytmy.algorytmyZachlanne;

public class Plecak {

    final static int N = 6;                // liczba przedmiotow
    final static int MAX_V = 10;           // objetosc plecaka

    final static int[] V = {1, 2, 3, 2, 3, 1};  // objetosci przedmiotow
    final static int[] W = {6, 4, 5, 7, 10, 2}; // wartosci przedmiotow

    public static void main(String[] args) {
        plecak();
    }

    static void plecak() {
        boolean[] rozw = new boolean[N];
        for (int i = 0; i < N; i++) {
            rozw[i] = false;
        }

        int sumW = 0;
        int sumV = 0;

        while (true) {
            int maxW = 0;
            int maxPoz = -1;
            for (int i = 0; i < N; i++) {
                if (!rozw[i]) {
                    if ((sumV + V[i] <= MAX_V) && (W[i] > maxW)) {
                        maxW = W[i];
                        maxPoz = i;
                    }
                }
            }

            if (maxPoz > -1) {
                rozw[maxPoz] = true;
                sumW = sumW + W[maxPoz];
                sumV = sumV + V[maxPoz];
            } else break;
        }

        System.out.println("Wartosc przedmiotwo w plecaku: " + sumW);
        System.out.println("Przedmioty w plecaku: ");

        for (int i = 0; i < N; i++) {
            if (rozw[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
