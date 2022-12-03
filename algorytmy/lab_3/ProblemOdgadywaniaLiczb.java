package algorytmy.lab_3;

import java.util.Random;

public class ProblemOdgadywaniaLiczb {

    public static void main(String[] args) {

        int max = 1000;
        int min = 0;
        int licznik = 0;
        Random random = new Random();
        int liczbaWylosowana = random.nextInt(max);
        System.out.println(liczbaWylosowana);
        System.out.println(Odgadywanie(min, max, liczbaWylosowana, licznik));

    }

    static int Odgadywanie(int min, int max, int liczbaWylosowana, int licznik) {

        int p = (min + max) / 2;

        if (liczbaWylosowana < p) {
            licznik++;
            System.out.print("za duzo");
//            max = p; //wersja pierwotna
            max = p - 1; //wersja lepsza
            System.out.println(" przedzial " + "(" + min + "," + max + ") ");
            Odgadywanie(min, max, liczbaWylosowana, licznik);
        } else if (liczbaWylosowana > p) {
            licznik++;
            System.out.print("za malo");
//            min = p; //wersja pierwotna
            min = p + 1; //wersja lepsza
            System.out.println(" przedzial " + "(" + min + "," + max + ") ");
            Odgadywanie(min, max, liczbaWylosowana, licznik);
        } else {
            licznik++;
            System.out.print("tak");
            System.out.println(" przedzial " + "(" + min + "," + max + ") ");
            System.out.println("minimalna liczba prob:" + licznik);
        }


        return 0;
    }
}
