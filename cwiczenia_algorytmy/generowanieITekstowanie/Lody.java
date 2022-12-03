package cwiczenia_algorytmy.generowanieITekstowanie;

public class Lody {

    final static int N = 6;
    static int[] l = new int[N];
    static int[][] koszt = new int[N][N];
    static int[] tab = new int[N + 1];
    static int najmniejszyKoszt = Integer.MAX_VALUE;

    public static void main(String[] args) {

        koszt = new int[][]{
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };

        permutacje(0);
        System.out.println("Przejscia miedzy smakami: ");
        for (int element: tab){
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Najmniejszy koszt: ");
        System.out.println(najmniejszyKoszt);
    }

    static void permutacje(int i) {
        if (i == N) {

            int[] tab2 = new int[N + 1];
            int x = 0;
            int obecnyKoszy = 0;

            for (int j = 0; j < N; j++) {
                tab2[j] = l[j] - 1;
                if (j + 1 == N) {
                    x = tab2[0];
                } else {
                    x = l[j + 1] - 1;
                }

                obecnyKoszy += koszt[tab2[j]][x];
                System.out.print(tab2[j] + " ");
            }
            if (obecnyKoszy<najmniejszyKoszt){
                najmniejszyKoszt = obecnyKoszy;
                System.arraycopy(tab2,0,tab,0,N);
            }
            System.out.println();

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