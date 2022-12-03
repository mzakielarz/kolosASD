package algorytmy.lab_1;

public class ProblemZalogiStatkuKosmicznego {
    static final int N = 5;
    static int s = (int) Math.pow(2, N);

    static int[][] praca = new int[s][4];

    public static void main(String[] args) {
        int[] tab = new int[N + 1];

        int[][] astronaci = {
                {1, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        int[][] jacyastronaci = new int[s][N];
        // Stack<Integer> praca = new Stack<>();
        for (int l = 0; l < s; l++) {
            for (int i = 0; i < N; i++) {

                for (int x = 0; x < 4; x++) {
                    if (tab[i] == 1) {
                        praca[l][x] += astronaci[i][x];
                    }
                }
                if (tab[i] == 1) {
                    jacyastronaci[l][i] = 1;
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

        int suma = 0;
        for (int l = 0; l < s; l++) {
            for (int x = 0; x <= 4; x++) {
                suma += jacyastronaci[l][x];
            }
            if (suma <= 2) {
                for (int w = 0; w <= 4; w++) {
                    if (praca[l][0] > 0 && praca[l][1] > 0 && praca[l][2] > 0 && praca[l][3] > 0) {
                        if (jacyastronaci[l][w] != 0) {
                            System.out.print("astronata " + "k" + (w + 1) + " ");
                        }
                        // System.out.print(praca[l][w]);
                    }
                }
                System.out.println(" ");
            }
            suma = 0;
        }
    }
}


