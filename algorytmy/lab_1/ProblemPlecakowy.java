package algorytmy.lab_1;

public class ProblemPlecakowy {
    public static void main(String[] args) {

        final int N = 6;
        final int MAXV = 10;

        final int[] V = {6, 2, 3, 2, 3, 1};
        final int[] W = {6, 4, 5, 7, 10, 2};

        int maxW = 0;
        int v = 0, w = 0;

        int[] tab = new int[N + 1];
        int s = (int) Math.pow(2, N);
        int[][] test = new int[s][N];
        int[] info = new int[N];
        for (int l = 0; l < s; l++) {
            for (int i = 0; i < N; i++) {
                if (tab[i] == 1) {
                    test[l][i] = V[i];
                }
            }

            int i = 0;
            do {
                if (tab[i] == 1) {
                    tab[i] = 0;
                    i++;
                } else {
                    tab[i] = 1;
                    break;
                }
            } while (true);
        }

        for (int l = 0; l < s; l++) {
//            System.out.print("{ ");
            for (int i = 0; i < N; i++) {
                v += test[l][i];
            }
            if (v <= MAXV) {
//                System.out.print(v);
                for (int i = 0; i < N; i++) {
                    if (test[l][i] != 0) {
                        w += W[i];
                    }
                }
                if (w > maxW) {
                    maxW = w;
                    for (int i = 0; i < N; i++) {
                        if (i != 0 && i != 5)
                            info[i] = i;
                    }
                }
                w = 0;
            }
            v = 0;
//            System.out.println("}");
        }
        System.out.println("Wartosc przedmiotow w plecaku to: " + maxW);
        System.out.println("W plecaku sa przedmioty o numerach: ");
        for (int j : info) {
            System.out.print(j + " ");
        }

    }
}


