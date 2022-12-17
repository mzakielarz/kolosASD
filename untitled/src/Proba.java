import java.util.Random;

public class Proba {
    public static void main(String[] args) {
      //  KrolikiDyn();
       // System.out.println("?????????");
       // KrolikiRek(40);
        lodyZach();
      //  lodyMC();

        poObjetosci();
        poWartosci();
        poWspolczynniku();
    }
    static boolean Hun=false,Thous=false,TenTh=false,HunTh=false,Mil=false;
    public static int KrolikiRek(int i) {
        int kroliki = 0;
        if(i==0 || i==1) return 1;
        else kroliki = KrolikiRek(i-1)+KrolikiRek(i-2);

        if(kroliki>=100 && !Hun) {
            System.out.println("Kroliki przekroczyly 100 w "+i+" miesiacu i jest ich dokladnie "+kroliki);
            Hun = true;
        }
        if(kroliki>=1000 && !Thous) {
            System.out.println("Kroliki przekroczyly 100 w "+i+" miesiacu i jest ich dokladnie "+kroliki);
            Thous = true;
        }
        if(kroliki>=10000 && !TenTh) {
            System.out.println("Kroliki przekroczyly 100 w "+i+" miesiacu i jest ich dokladnie "+kroliki);
            TenTh = true;
        }
        if(kroliki>=100000 && !HunTh) {
            System.out.println("Kroliki przekroczyly 100 w "+i+" miesiacu i jest ich dokladnie "+kroliki);
            HunTh = true;
        }
        if(kroliki>=1000000 && !Mil) {
            System.out.println("Kroliki przekroczyly 100 w "+i+" miesiacu i jest ich dokladnie "+kroliki);
            Mil = true;
        }

        return kroliki;
    }

    public static void KrolikiDyn() {
        int kroliki[] = new int[40];
        for(int i=0;i< kroliki.length;i++) {
            if(i==0 || i==1) kroliki[i] = 1;
            else kroliki[i] = kroliki[i-1]+kroliki[i-2];
            if(kroliki[i]>=100 && !Hun) {
                System.out.println("Jest wiecej niz 100 krolikow w "+i+" miesiacu i dokladna liczba to "+kroliki[i]);
                Hun = true;
            }
            if(kroliki[i]>=1000 && !Thous) {
                System.out.println("Jest wiecej niz 100 krolikow w "+i+" miesiacu i dokladna liczba to "+kroliki[i]);
                Thous = true;
            }
            if(kroliki[i]>=10000 && !TenTh) {
                System.out.println("Jest wiecej niz 100 krolikow w "+i+" miesiacu i dokladna liczba to "+kroliki[i]);
                TenTh = true;
            }
            if(kroliki[i]>=100000 && !HunTh) {
                System.out.println("Jest wiecej niz 100 krolikow w "+i+" miesiacu i dokladna liczba to "+kroliki[i]);
                HunTh = true;
            }
            if(kroliki[i]>=1000000 && !Mil) {
                System.out.println("Jest wiecej niz 100 krolikow w "+i+" miesiacu i dokladna liczba to "+kroliki[i]);
                Mil = true;
            }
        }
    }
    public static void lodyZach(){
        final int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };
        int czas=0;
        int tempczas=0;
        int start;
        boolean[] bylo= new boolean[koszty.length];
        for(int i =0;i<bylo.length;i++){
            bylo[i]=false;
        }
        int wiersz=0;
        int min = Integer.MAX_VALUE;

        //Sprawdzamy pierwszy smak
        for (int i=0;i<koszty.length;i++) {
            for (int j=0;j<koszty.length;j++) {
                if ( koszty[i][j]>0 && koszty[i][j]<min) {
                    wiersz=i;
                    min=koszty[i][j];
                }
            }
        }
        start=wiersz;
        System.out.println("Smaki:");
        System.out.println(wiersz+1);
        bylo[wiersz]=true;
        int minIndex =-1;

        //Sprawdzamy na jakie smaki kolejno przerobić
        for(int i=0;i< koszty.length-1;i++){
            min=Integer.MAX_VALUE;
            for(int j=0;j< koszty[0].length;j++){
                if(koszty[wiersz][j]<min &&koszty[wiersz][j]>0 && bylo[j]==false){
                    min=koszty[wiersz][j];
                    minIndex=j;
                    tempczas=koszty[wiersz][j];
                }
            }
            wiersz=minIndex;
            bylo[minIndex]=true;
            czas+=tempczas;
            System.out.println(wiersz+1);
        }

        //Przestrajamy na następny dzień
        czas+=koszty[wiersz][start];
        System.out.println(start+1);
        System.out.println("CZAS: "+czas);
    }
    public static int lodyMC(){
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

    //PLECAK ZACHŁANNY

    final static int[] objetosci = {6, 2, 3, 2, 3, 1};
    final static int[] wartosci = {6, 4, 5, 7, 10, 2};
    final static int MAX = 10;
    final static int przedmioty = objetosci.length;


    public static void poObjetosci() {

        boolean[] tab = new boolean[przedmioty];
        for (boolean e : tab) e = false;

        int objetosc = 0;
        int wartosc = 0;

        while (true) {
            int najmniejszaObjetosc = Integer.MAX_VALUE;
            int pozycja = -1;

            for (int i=0;i<przedmioty;i++) {
                if (!tab[i] && objetosc+objetosci[i]<=MAX && objetosci[i]<najmniejszaObjetosc) {
                    najmniejszaObjetosc = objetosci[i];
                    pozycja = i;
                }
            }

            if (pozycja>-1) {
                tab[pozycja] = true;
                wartosc += wartosci[pozycja];
                objetosc += objetosci[pozycja];
            } else break;
        }

        System.out.print("Przedmioty: ");
        for (int i=0;i<przedmioty;i++) if (tab[i]) System.out.print(i + " ");
        System.out.println("\tWartosc: " + wartosc);
    }

    public static void poWartosci() {
        boolean[] tab = new boolean[przedmioty];
        for (boolean e : tab) e = false;

        int objectosc = 0;
        int wartosc = 0;

        while (true) {
            int pozycja=-1;
            int maksymalnaWartosc = Integer.MIN_VALUE;

            for (int i=0;i<przedmioty;i++) {
                if (!tab[i] && wartosci[i]>maksymalnaWartosc && objetosci[i]+objectosc<=MAX) {
                    maksymalnaWartosc = wartosci[i];
                    pozycja = i;
                }
            }

            if (pozycja>-1) {
                tab[pozycja] = true;
                wartosc += wartosci[pozycja];
                objectosc += objetosci[pozycja];
            } else break;
        }

        System.out.print("Przedmioty: ");
        for (int i=0;i<przedmioty;i++) if (tab[i]) System.out.print(i + " ");
        System.out.println("\tWartosc: " + wartosc);
    }

    public static void poWspolczynniku() {
        boolean[] tab = new boolean[przedmioty];
        for (boolean e : tab) e = false;

        double[] wspolczynniki = new double[przedmioty];
        for (int i=0;i<przedmioty;i++) wspolczynniki[i] = wartosci[i]/objetosci[i];

        int wartosc=0;
        int objetosc=0;

        while(true) {
            int pozycja = -1;
            double najWspolczynnik = Double.MIN_VALUE;

            for (int i=0;i<przedmioty;i++) {
                if (!tab[i] && najWspolczynnik<wspolczynniki[i] && objetosc+objetosci[i]<=MAX) {
                    pozycja = i;
                    najWspolczynnik=wspolczynniki[i];
                }
            }

            if (pozycja>-1) {
                wartosc += wartosci[pozycja];
                objetosc += objetosci[pozycja];
                tab[pozycja] = true;
            } else break;
        }

        System.out.print("Przedmioty: ");
        for (int i=0;i<przedmioty;i++) if (tab[i]) System.out.print(i+" ");
        System.out.println("\tWartosci: " + wartosc);
    }
}
