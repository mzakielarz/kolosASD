package cwiczenia_algorytmy.dzielIZwycierzaj;

public class KomaryDz2 {
    public static void main(String args[]) {
        k(1, 1000, 550, 450);

    }

    static void k(int n, int wszystkie, int samice, int samce) {
        // z tym zdychaniem to mozna zastosowac logike ze najpierw sie rodza nowe i potem zdychaja
        // albo ze najpierw zdychaja i potem sie rodza nowe, nie jest sprecyzowane wiec
        //zakladam ze najpierw zdcychaja
        if (samice > samce) {
            System.out.println(n + ") tydzien: wszystkie " + wszystkie + " samice " + samice + " samce " + samce);
            n++;
            samice *= 0.95; // 5% samic zdcyha
            samce *= 0.98; // 2% samcow zdycha
            wszystkie = (int) ((samice + samce) * 1.10); // wszystkie to te które przezly + 10% tych co przezylo
            double nowe = wszystkie * 0.10;
            samice += nowe * 0.55;
            samce += nowe * 0.45;

            k(n, wszystkie, samice, samce);
        } else {
            System.out.println("W tygodniu " + n + " samcow jest wiecej niz samic");
            System.out.println("samice: " + samice + " samce: " + samce);
        }
    }
}
