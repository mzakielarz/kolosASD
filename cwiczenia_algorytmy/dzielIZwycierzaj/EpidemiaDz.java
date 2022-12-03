package cwiczenia_algorytmy.dzielIZwycierzaj;

public class EpidemiaDz {
    public static void main(String[] args) {
        double chorzy = 10;
        int dzien = 1;
        int licznik = 1;
        epidemia(chorzy, dzien, licznik);
    }


    static void epidemia(double chorzy, int dzien, int licznik) {

        double zarazajacy = (int) (chorzy / 2);

        if (chorzy < (100000 / 2.0)) {
            dzien++;
            chorzy = chorzy + (zarazajacy * 2);
            if (dzien >= 7) {
                if (dzien == 7 || dzien == 8 ) {
                    double wyzdowiali = 10;
                    chorzy = chorzy - wyzdowiali;
                }

                if (dzien > 8 ) {
                    double wyzdrowiali =  10 * Math.pow(2,licznik);
                    licznik++;
                    chorzy = chorzy - wyzdrowiali;
                }
                System.out.println("dzien: " + dzien);
                System.out.println("liczba chorych: " + chorzy);
                epidemia(chorzy, dzien, licznik);
            } else {
                System.out.println("dzien: " + dzien);
                System.out.println("liczba chorych: " + chorzy);
                epidemia(chorzy, dzien, licznik);
            }
        }
    }
}
