package cwiczenia_algorytmy;

public class ResztaAZ {
    public static void main(String[] args) {
        reszta(7.53);
    }

    static void reszta(double r) {

        int[] M = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] L = {7, 0, 1, 1, 4, 1, 4, 7, 30};

        int[] zliczaj = new int[M.length];
        int i = 0;
        r = r * 100;
        System.out.println("Reszta: ");

        while (r > 0 && i < M.length) {
            if (r >= M[i] && L[i] > 0) {
                System.out.print(M[i] / 100.0 + " ");
                zliczaj[i]++;
                r = r - M[i];
                L[i]--;
            } else {
                i++;
            }
        }
        System.out.println();
        System.out.println("Wydane monety: ");
        System.out.println("Nominal: " + "Ilosc monet: \n");
        for (int j = 0; j < M.length; j++) {
            System.out.println(M[j] / 100.0 + "       " + zliczaj[j]);
        }

        if (r>0){
            System.out.println("Nie udalo sie wydac reszty! Zostalo " + r + " zl");
        }
    }
}
