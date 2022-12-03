package algorytmy.lab_2;

public class ProblemNajkrutszejDrogi {

    //Program na kolokwium do znalezienia drogi przez wszystkie miasta z zad A19
    final static int N = 9; // permutacje n-elementowe
    private static int[] l = new int[N];
    static int[][] trasy = new int[N][N];
    static int Trasa;
    static int[] tab = new int[N + 1];

    public static void main(String[] args) {

        trasy = new int[][]
                {
                        {0, 300, 402, 356, 0, 0, 0, 0, 0},
                        {300, 0, 0, 0, 440, 474, 0, 0, 0},
                        {402, 0, 0, 0, 0, 330, 0, 0, 0},
                        {356, 0, 0, 0, 0, 0, 823, 0, 0},
                        {0, 440, 0, 0, 0, 0, 0, 430, 0},
                        {0, 474, 330, 0, 0, 0, 813, 365, 774},
                        {0, 0, 0, 823, 0, 813, 0, 0, 403},
                        {0, 0, 0, 0, 430, 365, 0, 0, 768},
                        {0, 0, 0, 0, 0, 774, 403, 768, 0}
                };

        permutacje(0);

        for (int element : tab) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Droga: " + Trasa);
    }

    static void permutacje(int i) {
        if (i == N) {

            int[] tab2 = new int[N + 1];
            int obecnaTrasa = 0;
            int x = 0;

            for (int j = 0; j < N; j++) {
                tab2[j] = l[j] - 1;
                if (j + 1 == N) {
                    x = tab2[0];
                } else {
                    x = l[j + 1] - 1;
                }
                if (trasy[tab2[j]][x] != 0) {
                    obecnaTrasa += trasy[tab2[j]][x];
                    System.out.print(tab2[j] + " ");
                }

            }

            if (obecnaTrasa > Trasa) {
                Trasa = obecnaTrasa;
                System.arraycopy(tab2, 0, tab, 0, N);
            }
            System.out.println(obecnaTrasa);

        } else {
            for (int j = 1; j <= N; j++) {
                int k;
                for (k = 0; k < i; k++)
                    if (l[k] == j) break;
                if (k == i) {
                    l[k] = j;
                    permutacje(i + 1);
                }
            }
        }
    }
}

