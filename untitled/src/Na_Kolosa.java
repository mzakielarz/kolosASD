import java.util.Random;

public class Na_Kolosa {
    public static void main(String[] args) {
   // zliczaj(45);
      //  plecakDyn();
      //  zliczaj(40);
      //  zliczajDyn();
     //   lodyMC();
      //  lodyZach();

        poObjetosci();
        poWartosci();
        poWspolczynniku();

    }
    // plecak rekurencyjny
    static final int[] V = {6,2,3,2,3,1};
    static final int[] W = {6,4,5,7,10,2};
    static final int N = V.length;
    static final int MAX_V = 10;
    static int przedmioty = V.length;

    static int plecak(int i, int v){
        if(i==0 && v<V[i]) return 0;
        if(i==0 && v>= V[i]) return W[0];
        if(i>0 && v<V[i]) return plecak(i-1,v);
        return Math.max(plecak(i-1,v),W[i]+plecak(i-1,v-V[i]));

    }
    // KRÓLIKI REKURENCYJNE
    static boolean sto, tysiac, dtys, stotys, milion;
    static int zliczaj(int n){
        if(n==0 || n==1) return 1;
        int kroliki = zliczaj(n-1)+zliczaj(n-2);

        if(kroliki>=100 && sto==false ){

            System.out.println("100 po: "+n);
            sto=true;
        }
        if(kroliki>=1000 && tysiac==false ){

            System.out.println("1000 po: "+n);
            tysiac=true;
        }
        if(kroliki>=10000 && dtys==false ){

            System.out.println("10000 po: "+n);
            dtys=true;
        }
        if(kroliki>=100000 && stotys==false ){

            System.out.println("100000 po: "+n);
            stotys=true;
        }
        if(kroliki>=1000000 && milion==false ){

            System.out.println("1000000 po: "+n);
            milion=true;
        }
      return kroliki;
    }
    // PLECAK DYNAMICZNY
    static void plecakDyn(){
        int[][] tab = new int[przedmioty][MAX_V+1];
        for (int i = 0; i <przedmioty ; i++) {
            for (int v = 0; v <=MAX_V ; v++) {
                if(i==0 && v<V[0]) tab[i][v] = 0;
                else if(i==0 && v>=V[0]) tab[i][v] = W[0];
                else if(i>0 && v<V[i]) tab[i][v] = tab[i-1][v];
                else tab[i][v] = Math.max(tab[i-1][v],W[i]+tab[i-1][v-V[i]]);
            }
        }
        System.out.println(tab[przedmioty-1][MAX_V]);
    }
    static boolean a, b, c, d, e;
    // KRÓLIKI DYNAMICZNE
    static void zliczajDyn() {

        int N = 40;
        int[] tab = new int[N];

        for (int i = 2; i < tab.length; i++) {
            tab[0] = 1;
            tab[1] = 1;
            tab[i] = tab[i - 1] + tab[i - 2];
            if (tab[i] >= 100 && a == false) {

                System.out.println("100 po: " + i);
                a = true;
            }
            if (tab[i] >= 1000 && b == false) {

                System.out.println("1000 po: " + i);
                b = true;
            }
            if (tab[i] >= 10000 && c == false) {

                System.out.println("10000 po: " + i);
                c = true;
            }
            if (tab[i] >= 100000 && d == false) {

                System.out.println("100000 po: " + i);
                d = true;
            }
            if (tab[i] >= 1000000 && e == false) {

                System.out.println("1000000 po: " + i);
                e = true;
            }
        }
        //  System.out.println(tab[N-1]);

    }
    // lody Monte Carlo
    static void lodyMC(){
        final int[][] koszty = {
                
                {0,7,20,21,12,23},
                {27,0,13,16,46,5},
                {53,15,0,25,27,6},
                {16,2,35,0,47,10},
                {31,29,5,18,0,4},
                {28,24,1,17,5,0}
        };
        int smaki = koszty.length;
       int[]najlepszaSekwencja = new int[smaki+1];
       int najlepszaWartosc = Integer.MAX_VALUE;
       int proby = 10;
       Random rand = new Random();
        for (int i = 0; i < proby; i++) {
            boolean[] czyBylo = new boolean[smaki];
            int[] aktualnaSekwencja = new int[smaki+1];
            int start = rand.nextInt(0,6);
            aktualnaSekwencja[0] = start;
            czyBylo[start] = true;
            int licznik = 1;
            while (licznik<smaki){
                int x = rand.nextInt(0,6);
                if(czyBylo[x]==true) continue;
                aktualnaSekwencja[licznik] = x;
                czyBylo[x] = true;
                licznik++;
            }
            aktualnaSekwencja[6] = start;
            int aktualnaWartosc = 0;
            for (int j = 0; j < aktualnaSekwencja.length-1; j++) {
                aktualnaWartosc += koszty[aktualnaSekwencja[j]][aktualnaSekwencja[j+1]];
            }
            if(aktualnaWartosc<najlepszaWartosc){
                najlepszaWartosc = aktualnaWartosc;
                najlepszaSekwencja = aktualnaSekwencja;
            }
        }
        for (int i = 0; i < najlepszaSekwencja.length; i++) {
            System.out.print(najlepszaSekwencja[i]+" ");
        }
        System.out.println(najlepszaWartosc);
    }
    // LODY ZACHLANNE
    static void lodyZach(){
        final int[][] koszty = {

                {0,7,20,21,12,23},
                {27,0,13,16,46,5},
                {53,15,0,25,27,6},
                {16,2,35,0,47,10},
                {31,29,5,18,0,4},
                {28,24,1,17,5,0}
        };
     int wiersz = 0, index = 0, czas = 0, tempczas=0;
     int start = 0;
     boolean[] czyBylo = new boolean[koszty.length];
        for (int i = 0; i < czyBylo.length; i++) {
            czyBylo[i] = false;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < koszty.length ; i++) {
            for (int j = 0; j < koszty.length ; j++) {
                if(koszty[i][j]>0 && koszty[i][j]<min){
                    min = koszty[i][j];
                    wiersz = i;
                }
            }
        }
        start = wiersz;
        czyBylo[wiersz] = true;
        System.out.println("Zaczynamy od:");
        System.out.println(wiersz);

        for (int i = 0; i < koszty.length-1 ; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < koszty[0].length ; j++) {
                if(koszty[i][j]>0 && koszty[i][j]<min && czyBylo[j]==false){
                    min = koszty[wiersz][j];
                    index = j;
                    tempczas = koszty[wiersz][j];
                }
            }

            wiersz = index;
            czyBylo[index] = true;
            czas += tempczas;
            System.out.println(wiersz);

        }
        //Przestrajamy na następny dzień
        czas+=koszty[wiersz][start];
        System.out.println(start+1);
        System.out.println("CZAS: "+czas);

    }


    static void poObjetosci(){
        final  int[] objetosci = {6, 2, 3, 2, 3, 1};
        final  int[] wartosci = {6, 4, 5, 7, 10, 2};
        final  int MAX = 10;
        final  int przedmioty = objetosci.length;

        boolean[] tab = new boolean[przedmioty];
        int objetosc = 0;
        int wartosc = 0;



        while(true){
            int poz = -1;
            int minObjetosc = Integer.MAX_VALUE;
            for (int i = 0; i < przedmioty; i++) {
                if(!tab[i] && objetosci[i]+objetosc<=MAX && objetosci[i]<minObjetosc ){
                    minObjetosc = objetosci[i];
                    poz = i;
                }
            }
            if(poz>-1){
                tab[poz] = true;
                wartosc += wartosci[poz];
                objetosc += objetosci[poz];
            }
            else break;
        }
        System.out.print("Przedmioty: ");
        for (int i=0;i<przedmioty;i++) if (tab[i]) System.out.print(i + " ");
        System.out.println("\tWartosc: " + wartosc);
    }

    public static void poWartosci(){
        final  int[] objetosci = {6, 2, 3, 2, 3, 1};
        final  int[] wartosci = {6, 4, 5, 7, 10, 2};
        final  int MAX = 10;
        final  int przedmioty = objetosci.length;
        int objetosc = 0;
        int wartosc = 0;
        boolean[] tab = new boolean[przedmioty];
        while (true){
            int poz = -1;
            int maxWartosc = Integer.MIN_VALUE;
            for (int i = 0; i < przedmioty; i++) {
                if(!tab[i] && objetosci[i]+objetosc<=MAX && wartosci[i]>maxWartosc){
                    poz = i;
                    maxWartosc = wartosci[i];
                }
            }
            if(poz>-1){
                tab[poz] = true;
                wartosc+=wartosci[poz];
                objetosc+=objetosci[poz];
            }
            else break;
        }
        System.out.print("Przedmioty: ");
        for (int i=0;i<przedmioty;i++) if (tab[i]) System.out.print(i + " ");
        System.out.println("\tWartosc: " + wartosc);
    }

    static void poWspolczynniku(){
        final  int[] objetosci = {6, 2, 3, 2, 3, 1};
        final  int[] wartosci = {6, 4, 5, 7, 10, 2};
        final  int MAX = 10;
        final  int przedmioty = objetosci.length;
        int objetosc = 0;
        int wartosc  = 0;
        boolean[] tab = new boolean[przedmioty];
        double[] wspolczynnik = new double[przedmioty];
        for (int i = 0; i < wspolczynnik.length; i++) {
            wspolczynnik[i] = wartosci[i]/objetosci[i];
        }
        while (true){
            double najwiekszyWspolczynnik = Double.MIN_VALUE;
            int poz = -1;
            for (int i = 0; i < przedmioty; i++) {
                if(!tab[i] && objetosc+objetosci[i]<=MAX && wspolczynnik[i]>najwiekszyWspolczynnik){
                    najwiekszyWspolczynnik = wspolczynnik[i];
                    poz = i;
                }
            }
            if(poz > -1){
                tab[poz] = true;
                wartosc += wartosci[poz];
                objetosc += objetosci[poz];
            }
            else break;
        }
        System.out.print("Przedmioty: ");
        for (int i = 0; i < przedmioty; i++) {
            if(tab[i]==true) System.out.print(i+" ");
        }
        System.out.print("Wartosc: "+wartosc);
    }
}
