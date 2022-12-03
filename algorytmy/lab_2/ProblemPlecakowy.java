package algorytmy.lab_2;

public class ProblemPlecakowy {
    final static int N = 6; // permutacje n-elementowe
    private static int[] l = new int[N];
    static int[] V = new int[N];
    static int[] W = new int[N];
    final static int[] tab = new int[N];
    static int objetosc = Integer.MAX_VALUE;
    static int wartosc = 0;


    public static void main(String[] args) {

        V = new int[]{6, 2, 3, 2, 3, 1};
        W = new int[]{6, 4, 5, 7, 10, 2};

        permutacje(0);

        System.out.println();
        System.out.println("Najlepszy układ: ");
        for (int element : tab) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("najwieksza wartosc: " + wartosc);

    }

    static void permutacje(int i) {
        if (i == N) {
            int[] tab2 = new int[N];
            int obecnaObjetosc = 0;
            int obecnaWartosc = 0;
            for (int j = 0; j < N; j++) {
                tab2[j] = l[j] - 1;
                if (obecnaObjetosc <= 10) {
                    obecnaObjetosc += V[tab2[j]];
                    obecnaWartosc += W[tab2[j]];
                    if (obecnaObjetosc > 10) {
                        obecnaObjetosc = obecnaObjetosc - V[tab2[j]];
                        obecnaWartosc = obecnaWartosc - W[tab2[j]];
                        break;
                    }
                }

                System.out.print(tab2[j] + " ");
            }
            if (obecnaObjetosc < objetosc) {
                objetosc = obecnaObjetosc;
                System.arraycopy(tab2, 0, tab, 0, N);
            }
            if (obecnaWartosc > wartosc) {
                wartosc = obecnaWartosc;
                System.arraycopy(tab2, 0, tab, 0, N);
            }
            System.out.println("objetosc:" + obecnaObjetosc + " wartosc:" + obecnaWartosc);


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

