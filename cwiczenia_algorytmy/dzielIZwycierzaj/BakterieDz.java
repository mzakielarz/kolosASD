package cwiczenia_algorytmy.dzielIZwycierzaj;

public class BakterieDz {
    public static void main(String[] args) {
        double N = 12;
        double time = 0;
        int licznik = 1;
        bakterie(N, time, licznik);
    }

    static void bakterie(double n, double time, int licznik) {

        if (n < 12000) {

            if (time == 10 * licznik) {
                System.out.println("miniony czas: " + time);
                System.out.println("bakteri przed wymarciem: " + n);
                n = n / 2;
                System.out.println("bakterie wymarly przezylo: " + n);
                licznik++;
                bakterie(n, time, licznik);
            } else {
                time = time + 2;
                n = n * 2;
                System.out.println("miniony czas: " + time);
                System.out.println("liczba bakteri: " + n);
                bakterie(n, time, licznik);
            }
        } else if (n >= 12000) {
            System.out.println("Czas po jakim bakterie zwieksza swoja liczebnosc o 1000 razy: " + time + " minuty");
        }
    }
}
