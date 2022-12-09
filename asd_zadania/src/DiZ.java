import javax.sound.midi.Soundbank;
import java.util.Random;

public class DiZ {
    public static void main(String[] args) {
      //  System.out.println(plecak(przedmioty-1,10));
       /* System.out.println(liczba);
        zgadywanie(0,1000);*/
       // zliczaj(40);
      //  rozrod(1,0);
      //  ekosystem(MAX,0);
      //  System.out.println(newton(5,3) );
        komary(0,1000,450,550);
    }




    //plecak
    int obj=10; //obj max plecaka
    final static int przedmioty = 6;
    final static  int[] V = {6,2,3,2,3,1}; // obj przedmitów
    final static int[] W= {6,4,5,7,10,2}; // wartość przedmiotów

    public static int plecak(int i, int obj){

            if(i==0 && V[0]> obj) return 0;
            if(i==0 && V[0]<= obj) return W[0];
            if(i>0 && V[i]> obj) return plecak(i-1, obj);
            else return Math.max(plecak(i-1, obj),W[i] + plecak(i-1, obj -V[i]));


    }
    // dane do zgadywania:
    static Random rand = new Random();
    static int liczba = rand.nextInt(0,1001);
    // odgadywanie liczb
    public static void zgadywanie(int a, int b){

        int x = (a+b)/2; // srodek przedziału
        if(liczba==x) {
            System.out.println("Czy myślisz o: "+x);
            System.out.println("Tak. Ta liczba to: "+x);
        }
        if(liczba > x) {
            System.out.println("Czy myślisz o: "+x);
            System.out.println("Nie, Szukam większej liczby");
            zgadywanie(x+1,b);
        }
        if(liczba<x){
            System.out.println("Czy myślisz o:"+x);
            System.out.println("Nie, szukam mniejszej liczby");
            zgadywanie(a,x-1);
        }

    }
    static boolean sto, tysiac, diesiectys, milion;


    public static int zliczaj(int n) {
        if (n==1 || n==2) return 1;
        int kroliki = zliczaj(n-1) + zliczaj(n-2);

        if (kroliki > 100 && !sto) {
            System.out.println("Sto: " + n);
            sto = true;
        }

        if (kroliki > 1000  && !tysiac) {
            System.out.println("Tysiac: " + n);
            tysiac=true;
        }

        if (kroliki > 10000  && !diesiectys) {
            System.out.println("Dziesiec tysiecy: " + n);
            diesiectys=true;
        }

        if (kroliki > 1000000  && !milion) {
            System.out.println("Milion: " + n);
            milion=true;
        }

        return kroliki;
    }




    //bakterie
    static boolean thousand, tenthousand, hundredthousand, million;

    public static void rozrod(int bakterii, int minuty) {

        if (bakterii>1000 && !thousand) {
            thousand=true;
            System.out.println("Tysiac razy: po " + minuty + " minutach");
        }

        if (bakterii>10000 && !tenthousand) {
            tenthousand=true;
            System.out.println("Dziesięc tysięcy razy: po " + minuty + " minutach");
        }

        if (bakterii>100000 && !hundredthousand) {
            hundredthousand=true;
            System.out.println("Sto tysięcy razy: po " + minuty + " minutach");
        }

        if (bakterii>1000000 && !million) {
            million=true;
            System.out.println("Milion razy: po " + minuty + " minutach");
            return;
        }

        rozrod(2*bakterii, minuty+2);
    }
        //ŁOSOSIE xDDDDD

    static boolean dwa;
    final static int MAX = 1000000;

    public static void ekosystem(int lososie, int min) {
        if (lososie < MAX / 2 && !dwa) {
            System.out.println("Polowa: po " + min + " minutach");
            dwa = true;
        }
        if (lososie < 100) {
            System.out.println("Populacja wymrze po " + min + " minutach");
            return;
        }

        lososie = (int) (((lososie * Math.exp(0.003)) * 0.998) * 0.998);
        ekosystem(lososie, min + 1);


    }
    // newton
    public static int newton(int n, int k){
        if (k==n || k==0) return 1;
        if(k>n) System.out.println("Brak rozwiązań");
        return newton(n-1,k-1)+newton(n-1,k);
    }

    // KOMARY
    public static void komary(int cykl, double wszystkie, double samce, double samice) { // aka łososie
        if (samce>=samice) {
            System.out.println("Liczba samcow przekroczy liczbe samic po " + cykl + " tygodniach");
            System.out.println("Bedzie wtedy " + wszystkie + " komarow");
        }
        else {
            double roznica = wszystkie*0.1;
            samce += 0.45 * roznica;
            samice += 0.55 * roznica;
            samce *= 0.98;
            samice *= 0.95;

            komary(cykl+1, samce+samice, samce, samice);
        }
    }
    // katar
    public static void katar(int chorzy, int dni){
        ////////////////////////////
    }

}
