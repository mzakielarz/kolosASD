package cwiczenia_algorytmy;

public class DrogaAZ {

    static String[] miasta = {"Warszawa", "Katowice", "Zakopane", "Lwow", "Weieden", "Budapeszt", "Bukareszt", "Zagrzeb", "Sofia"};

    static int[][] polaczenia = {
            {0, 300, 402, 356, -1, -1, -1, -1, -1}, //0
            {300, 0, -1, -1, 440, 473, -1, -1, -1}, //1
            {402, -1, 0, -1, -1, 330, -1, -1, -1},  // 2
            {356, -1, -1, 0, -1, -1, 823, -1, -1},  // 3
            {-1, 440, -1, -1, 0, -1, -1, 430, -1},  // 4
            {-1, 474, 330, -1, -1, 0, 813, 365, 774}, // 5
            {-1, -1, -1, 823, -1, 813, 0, -1, 403}, // 6
            {-1, -1, -1, -1, 430, 365, -1, 0, 768}, //7
            {-1, -1, -1, -1, -1, 774, 403, 768, 0} //8
    };

    public static void main(String[] args) {
        droga();
    }

    static void droga() {

        int index = 0;
        int pol = 0;

        for (int i = 0; i < miasta.length; i++) {
            int p = 0;
            for (int j = 0; j < miasta.length; j++) {
                if (polaczenia[i][j] > 0) {
                    p++;
                }
            }
            if (p > pol) {
                pol = p;
                index = i;
            }
            System.out.println("Miasto: " + miasta[i] + " ma " + pol + " polonczen");
        }

        System.out.println(index);
        String odwiedzone = miasta[index] + " ";

        int optymalnieOdwiedzone = 0;
        int kilometry = 0;

        while (optymalnieOdwiedzone < 8) {
            int lindex = 0;
            int low = Integer.MAX_VALUE;
            for (int i = 0; i < miasta.length; i++) {
                if (polaczenia[index][i] < low && polaczenia[index][i] > 0 && !(odwiedzone.contains(miasta[i]))) {
                    low = polaczenia[index][i];
                    lindex = i;
                }
            }
            System.out.println(miasta[index] + "->" + miasta[lindex] + "(" + low + " km)");
            odwiedzone += miasta[lindex] + " ";
            index = lindex;
            kilometry += low;
            optymalnieOdwiedzone++;
        }
        System.out.println("Miasta w kolejnosci: ");
        System.out.println(odwiedzone);
        System.out.println("Droga: ");
        System.out.println(kilometry);
    }
}
