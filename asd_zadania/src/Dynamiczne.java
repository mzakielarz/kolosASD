public class Dynamiczne {


    public static void main(String[] args) {
    // plecak();
       // katar();
        katar2();
    }
                  // plecak dynamiczny//
    public static void plecak(){
        final int[] objetosci = {6, 2, 3, 2, 3, 1};
        final int[] wartosci = {6, 4, 5, 7, 10, 2};
        final int MAX = 10;
        final int przedmioty = objetosci.length;
        int[][] tab = new int[przedmioty][MAX+1];

        for (int i=0;i<przedmioty;i++) {
            for (int v = 0; v <=MAX; v++) {
                if (i==0 && objetosci[i]> v) tab[i][v]=0;
                else if (i==0 && objetosci[i]<= v) tab[i][v] = wartosci[i];
                else if (i>0 && objetosci[i]> v) tab[i][v] = tab[i-1][v];
                else if (i>0 && objetosci[i]<= v) tab[i][v] = Math.max(tab[i - 1][v], wartosci[i] + tab[i - 1][v - objetosci[i]]);
            }
        }
// siurak haha cycuszki mmmmmm
        System.out.println(tab[przedmioty-1][MAX]);
    }

    // odgadywanie liczb
    private static int a = 0;
    private static int b = 1000;


    private static int[] numbers = new int[3];//index 0- guessed number; 1- smaller end; 2- bigger begin

    public static void guess(int N){

        numbers[0]=a;
        numbers[2]=b;
        while (true){
            numbers[1]=((numbers[0]+numbers[2])/2);
            if(numbers[1]==N){
                System.out.println("Ta liczba to: "+numbers[1]);
                break;
            }
            else if(numbers[1]<N){
                System.out.println("Za mało");
                numbers[0]=numbers[1]+1;
            }
            else if(numbers[1]>N){
                System.out.println("Za Dużo");
                numbers[2]=numbers[1]-1;

            }
        }

    }
    //króliki
    public static void kroliki(){
        final int N = 13;
        int[] tab = new int[N];
        tab[0] = 1;
        tab[1] = 1;

        for(int i=2;i<tab.length;i++) {
            tab[i] = tab[i-1] + tab[i-2];
        }
        System.out.println(tab[N-1]);
    }
    // bakteria
    static void bakterie() { // modyfikacja

        int minuty = 0;
        int[] liczbaBakteri = new int[100];

        liczbaBakteri[0] = 12;

        for (int i = 1; i < liczbaBakteri.length; i++) {
            liczbaBakteri[i] = liczbaBakteri[i - 1] * 2;
            for (int j = 1; j < liczbaBakteri.length; j++) {
                if (minuty == j * 10) {
                    liczbaBakteri[i] = liczbaBakteri[i] / 2;
                }
            }
            minuty = minuty + 2;

            if (liczbaBakteri[i] >= liczbaBakteri[0] * 1000) {
                System.out.println("Liczba bakteri zwiekszyla sie 1000 razy po: " + minuty + " minutach");
                break;
            }
        }

    }
    //łososie
    public static void lososie(){

        int lososie = 1000000;
        int[] tab = new int[7361];
        boolean dwa=false, trzy=false, dziesiec=false, sto=false;
        tab[0]=1000000;

        for(int i=1;i<tab.length;i++) {
            tab[i] = (int)(((tab[i-1]*Math.exp(0.003)*0.998)*0.998));

            if (!dwa && tab[i]<lososie/2) {
                System.out.println("Polowa: po " + i + " minutach");
                dwa = true;
            }
            if (!trzy && tab[i]<lososie/3) {
                System.out.println("Jedna trzecia: po " + i + " minutach");
                trzy = true;
            }
            if (!dziesiec && tab[i]<lososie/10) {
                System.out.println("Jedna dziesiata: po " + i + " minutach");
                dziesiec = true;
            }
            if (!sto && tab[i]<lososie/100) {
                System.out.println("Jedna setna: po " + i + " minutach");
                sto = true;
            }
            if (tab[i]<100) {
                System.out.println("Wymrze: po " + i + " minutach");
                break;
            }
        }
    }
    // QATAR
    public static void katar(){ // indexy o 1 do przodu bo ignoruje tab[0]
        final int populacja = 100000;
        int[] tab = new int[100];
        int odporni = 0;

        tab[1] = 10; // zarazeni

        for (int i=2;i<tab.length;i++) {
            tab[i] = 3*tab[i-1];
            System.out.println("ilosc odpornych: "+odporni);
            System.out.println("ilosc chorych dnia: "+i+ " jest "+tab[i]);

            if (i>7) {
                odporni += tab[i-7];
                tab[i] -= tab[i-7]; // od zarazonych odejmuje wyzdrowiałych
            }

            if (i>21) {
                odporni -= tab[i-14];
            }

            if (tab[i]>=populacja) {
                tab[i] =populacja ;
                System.out.println("Populacja: "+ tab[i]);
                break;

            }

            if (tab[i]<=0) {
                System.out.println("Koniec " + i + " dnia");
                break;
            }
        }
    }




        public static void katar2() {
            int chorzy = 10, dni = 0, odporni = 0, ile_dni = 0, populacja = 100000;
            int[] tab = new int[100];
            tab[0] = 10;
            while (true)
            {
                System.out.println("Jest " + chorzy + " chorych, mamy " + dni + " dzień kataru, jest to " + ile_dni + " dzien epidemi");
                if (dni <= 7) {
                    tab[ile_dni] = chorzy;
                    chorzy = chorzy * 3;
                    ile_dni++;
                    dni++;
                    if(populacja>100000)
                        populacja=100000;
                    if (ile_dni > 7)
                    {
                        odporni += tab[ile_dni - 7];
                        chorzy -= tab[ile_dni - 7];
                        populacja-=odporni+chorzy;
                        if(chorzy<0) chorzy=100000;
                        if(populacja<100000) populacja=0;
                    }
                    if (ile_dni > 21)
                    {
                        odporni -= tab[ile_dni - 21];
                        populacja += tab[ile_dni - 21];
                        if(odporni<0) odporni=0;
                        if(populacja>100000) populacja=100000;
                    }
                    tab[ile_dni] = chorzy;
                    if (chorzy > populacja)
                    {
                        chorzy=populacja;
                        System.out.println("Jest " + chorzy + " chorych, mamy " + dni + " dzień kataru, jest to " + ile_dni + " dzien epidemi");
                        System.out.println("Po " + ile_dni + " dniach liczba chorych wyniesie 100000");
                        System.out.println("Ludzi zdrowych jest " + odporni);
                        if (ile_dni > 7)
                        {
                            odporni += tab[ile_dni - 7];
                            chorzy -= tab[ile_dni - 7];
                            populacja-=odporni+chorzy;
                        }
                        if (ile_dni > 21)
                        {
                            odporni -= tab[ile_dni - 21];
                            populacja += tab[ile_dni - 21];
                        }
                    }
                }
                if(chorzy<=0)
                {
                    System.out.printf("Minelo" + ile_dni);
                    break;
                }
            }
        }
}




