package algorytmy.lab_4;

public class Plecak {
    final static int N = 6; // liczba przedmiotów
    final static int MAX_V = 10; // objetość plecaka
    final static int[] V = {6, 2, 3, 2, 3, 1}; // objetości przedmiotów
    final static int[] W = {6, 4, 5, 7, 10, 2}; // wartości przedmiotów

    public static void main(String[] args) {

        int[][] tab = new int[N + 1][MAX_V + 1];

        for (int i = 0; i <= MAX_V; i++) {
            tab[0][i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= MAX_V; j++) {
                if (V[i - 1] <= j) {  //jeśli przedmiot zmieści się do plecaka
                    tab[i][j] = Math.max(W[i - 1] + tab[i - 1][j - V[i - 1]], tab[i - 1][j]);
                    // dany przedmiot możemy albo zapakowac albo nie wiec sprawdzamy w ktorym przypadku
                    // wartosc zapakowanych przedmiotow bedzie wieksza
                    // I) przypadek gdy pakujemy przedmiot: pakujemy kolejny(ity) przedmiot do plecaka
                    // a nastepnie dodajemy do niego wartos przedmiotu/przedmiotow ktore jeszcze mozemy do
                    // niego wlozyc sprwadzamy to poprzez odjecie objetosci obecnego przedmiotu od (itej) objetosci
                    // do jakiej mozemy zapakowac przedmioty (przedmioty ktore checy dodac sa w poprzedmim wierszu)
                    // II) przypadek gdy nie pakujemy przedmiotu: pakujemy poprzedni przedmiot/przedmioty
                    // jakie zapakowalismy we wczesniejszym wierszu i w tej samej kolumnie
                } else { // ta sama wartosc co dla przedmiot/przedmiotow w poprzednim wierszu i tej samej kolumnie
                    tab[i][j] = tab[i - 1][j];
                }

            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= MAX_V; j++) {
                int val = tab[i][j];
                if (val < 100) System.out.print(" ");
                if (val < 10) System.out.print(" ");
                System.out.print(val + "  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Maksymalna wartosc: " + tab[N][MAX_V]);
        System.out.println();
    }
}

