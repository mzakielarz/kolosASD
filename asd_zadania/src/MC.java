import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class MC {
    public static void main(String[] args) {
    figura2();
    figura();
    }
    // figura1
    static void figura(){
        Random los = new Random();
        int licz =0;


        for (int i = 0; i <100 ; i++) {
            double x = (double)los.nextInt(1001)/1000;
            double y = (double)los.nextInt(1001)/1000;
            if(y<=Math.sin(x)) licz++;
        }
        System.out.println("POLE: "+(licz/100.0));
    }
    //figura2
    static void figura2(){
        Random los = new Random();
        int licz =0;


        for (int i = 0; i <100 ; i++) {
            double x = (double)los.nextInt(0,701)/1000;
            double y = (double)los.nextInt(400,1101)/1000; // od 0.4 do 1.1

            if(y<=Math.pow(x/10.0,x)) licz++;
        }
        System.out.println("POLE: "+(licz/100.0));
    }
    // reszta
    static void reszta(){
        Random rand = new Random();
        int[] nominaly = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        final double RESZTA = 4.78;

        String najlepszeRozwiazanie = "";
        int najmniejMonet = Integer.MAX_VALUE;

        for (int i=0;i<100;i++) {

            int wGroszach = (int)(RESZTA*100);
            String rozwiazanie = "";
            int ileMonet = 0;

            while (true) {
                int nominal = nominaly[rand.nextInt(nominaly.length)];

                if (wGroszach-nominal>=0) {
                    wGroszach -= nominal;
                    rozwiazanie += (float)nominal/100 + " ";
                    ileMonet++;
                }

                if (wGroszach<=0) break;
            }

            if (ileMonet<najmniejMonet) {
                najlepszeRozwiazanie=rozwiazanie;
            }
        }

        System.out.println("Wydane monety:\n" + najlepszeRozwiazanie);
    }
    // ODGADYWANIE
    static void zgadywanie(){
        Random rand = new Random();
        String najlepszeRozwiazanie = "";
        int minRuchow = Integer.MAX_VALUE;

        for (int i=0;i<1000;i++) {
            int min=0, max = 1000;
            int liczba = rand.nextInt(max+1);
            String rozwiazanie = "Najlepszy tok:";
            int ruchy = 0;

            while (true) {
                int strzal = rand.nextInt(min, max+1);
                ruchy++;

                if (strzal>liczba) {
                    rozwiazanie += "\n" + strzal + " za duzo";
                    max = strzal;
                }

                if (strzal<liczba) {
                    rozwiazanie += "\n" + strzal + " za malo";
                    min = strzal;
                }

                if (strzal==liczba) {
                    rozwiazanie += "\n" + strzal + " to ta liczba";

                    if (ruchy<minRuchow) {
                        najlepszeRozwiazanie = rozwiazanie;
                        minRuchow=ruchy;
                    }
                    break;
                }
            }
        }
        System.out.println(najlepszeRozwiazanie);
    }
}

// lody

public static int lody(){
        final int[][] costs = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };
        int flavors = costs.length;
        int[] bestSeq = new int[flavors+1];
        int bestValue = Integer.MAX_VALUE;

        final int attempts=10;
        Random rand = new Random();


        for(int i=0; i<attempts;i++) {

            //losujemy 1 smak
            int start = rand.nextInt(6);
            int[] curSeq = new int[flavors+1];
            curSeq[0] = start;

            boolean[] selected = new boolean[flavors];
            selected[start] = true;
            int selectdCount = 1;
            //losujemy kolejne smaki
            while (selectdCount < flavors) {
                int x = rand.nextInt(6);
                if (selected[x]) continue; //Jeśli sie powtórzył to losuj inny
                curSeq[selectdCount] = x;
                selected[x] = true;
                selectdCount++;
            }
            //Wracamy do początkowego smaku
            curSeq[6] = start;


            //obliczanie wartości dla danej sekwencji
            int curValue = 0;
            for (int j = 0; j < curSeq.length - 1; j++) {
                curValue += costs[curSeq[j]][curSeq[j + 1]];
            }
            //zapisujemy najlepsze wartości
            if (curValue < bestValue) {
                bestValue = curValue;
                bestSeq = curSeq;
            }
        }
        //Wypisanie wyniku
        System.out.println("Najlepsze rozwiązanie");
        System.out.println("Smaki: ");
        for(int i = 0; i<bestSeq.length;i++){
            System.out.println(""+(bestSeq[i]+1));
        }
        System.out.println("Całkowity czas przestrojeń: "+bestValue);

        return bestValue;

    }
