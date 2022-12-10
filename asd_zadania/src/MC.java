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
