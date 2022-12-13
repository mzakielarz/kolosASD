import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        System.out.println(PlecakRek(N-1,MAX_V));
//        PlecakDyn();
//        KrolikiRek(40);
//        KrolikiDyn();
//        LodziarniaZach();
//        LodziarniaMC();
//        PlecakMale();
//        PlecakCenna();
        PlecakIloraz();
    }

    static final int[] V = {6,2,3,2,3,1};
    static final int[] W = {6,4,5,7,10,2};
    static final int N = V.length;
    static final int MAX_V = 10;

    public static int PlecakRek(int i, int v) {
        if(i==0 && v<V[i]) return 0;
        if(i==0 && v>=V[i]) return W[i];
        if(i>0 && v<V[i]) return PlecakRek(i-1,v);
        return Math.max(PlecakRek(i-1,v),W[i]+PlecakRek(i-1,v-V[i]));
    }

    public static void PlecakDyn() {
        int tab[][] = new int[N][MAX_V+1];
        for(int i=0;i<N;i++) {
            for(int v=0;v<MAX_V+1;v++) {
                if(i==0 && v<V[i]) tab[i][v] = 0;
                if(i==0 && v>=V[i]) tab[i][v] = W[i];
                if(i>0 && v<V[i]) tab[i][v] = tab[i-1][v];
                if(i>0 && v>=V[i]) tab[i][v] = Math.max(tab[i-1][v],W[i]+tab[i-1][v-V[i]]);
            }
        }

        System.out.println(tab[N-1][MAX_V]);
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

    static final int[][] koszty = {
            {0,7,20,21,12,23},
            {27,0,13,16,46,5},
            {53,15,0,25,27,6},
            {16,2,35,0,47,10},
            {31,29,5,18,0,4},
            {28,24,1,17,5,0}
    };

    public static void LodziarniaZach() {
        int czas=0,czasTemp=0,start;
        int smaki = koszty.length;
        boolean[] bylo = new boolean[smaki];
        for(int i=0;i<smaki;i++) bylo[i] = false;
        int wiersz = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<smaki;i++) {
            for(int j=0;j<smaki;j++) {
                if(koszty[i][j]>0 && koszty[i][j]<min) {
                    min = koszty[i][j];
                    wiersz = i;
                }
            }
        }
        start = wiersz;
        bylo[wiersz] = true;
        System.out.println("Pierwszy smak: "+(start+1));
        int minIndex = -1;
        for(int i=0;i<smaki-1;i++) {
            min = Integer.MAX_VALUE;
            for(int j=0;j<koszty[0].length;j++) {
                if(koszty[wiersz][j]>0 && koszty[wiersz][j]<min && !bylo[j]) {
                    min = koszty[wiersz][j];
                    minIndex = j;
                    czasTemp = koszty[wiersz][j];
                }
            }
            wiersz = minIndex;
            bylo[wiersz] = true;
            czas += czasTemp;
            System.out.println("Nastepny smak: "+(wiersz+1));
        }
        czas+=koszty[wiersz][start];
        System.out.println("Ostatni smak: "+(start+1));
        System.out.println("Czas: "+czas);
    }

    public static void LodziarniaMC() {
        Random rand = new Random();
        int smaki = koszty.length;
        int bestSeq[] = new int[smaki+1];
        int bestValue = Integer.MAX_VALUE;
        int attempts = 1000;
        for(int i=0;i<attempts;i++) {
            int start = rand.nextInt(smaki);
            int[] curSeq = new int[smaki+1];
            curSeq[0] = start;
            curSeq[6] = start;

            boolean[] isSelected = new boolean[smaki];
            isSelected[start] = true;
            int selectedCount = 1;
            while(selectedCount<smaki) {
                int x = rand.nextInt(smaki);
                if(isSelected[x]) continue;
                else {
                    curSeq[selectedCount] = x;
                    isSelected[x] = true;
                    selectedCount++;
                }
            }

            int curValue = 0;
            for(int j=0;j<curSeq.length-1;j++) {
                curValue+=koszty[curSeq[j]][curSeq[j+1]];
            }

            if(curValue<bestValue) {
                bestValue = curValue;
                bestSeq = curSeq;
            }
        }

        System.out.println("Najlepsze rozwiazanie MC");
        System.out.print("Smaki: ");
        for(int i=0;i<bestSeq.length;i++) System.out.print((bestSeq[i]+1)+" ");
        System.out.println("\nCzas: "+bestValue);
    }

    public static void PlecakMale() {
        int sumaW=0,sumaV=0;
        boolean[] rozw = new boolean[N];
        for(int i=0;i<N;i++) rozw[i] = false;

        while(true) {
            int minV = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i=0;i<N;i++) {
                if(!rozw[i]) {
                    if(sumaV+V[i]<MAX_V && V[i]<minV) {
                        minV = V[i];
                        minIndex = i;
                    }
                }
            }

            if(minIndex>-1) {
                sumaV += V[minIndex];
                sumaW += W[minIndex];
                rozw[minIndex] = true;
            } else break;
        }

        System.out.println("Najlepsze rozwiazanie - NAJMNIEJSZE");
        System.out.println("Przedmioty: ");
        for(int i=0;i<N;i++) {
            if(rozw[i]) System.out.print((i+1)+" ");
        }
        System.out.println("\nWartosc: "+sumaW);
    }

    public static void PlecakCenna() {
        int sumaW=0, sumaV=0;
        boolean[] bylo = new boolean[N];
        for(int i=0;i<N;i++) bylo[i] = false;

        while(true) {
            int maxV = 0;
            int maxIndex = -1;
            for(int i=0;i<N;i++) {
                if(!bylo[i]) {
                    if(sumaV+V[i]<=MAX_V && W[i]>maxV) {
                        maxV = W[i];
                        maxIndex = i;
                    }
                }
            }

            if(maxIndex>-1) {
                sumaV+=V[maxIndex];
                sumaW+=W[maxIndex];
                bylo[maxIndex] = true;
            } else break;
        }

        System.out.println("Najlepsze rozwiazanie - CENNE");
        System.out.print("Przedmioty: ");
        for(int i=0;i<N;i++) if(bylo[i]) System.out.print((i+1)+" ");
        System.out.println("\nWartosc: "+sumaW);
    }

    public static void PlecakIloraz() {
        int sumaW=0,sumaV=0;
        boolean[] rozw = new boolean[N];
        for(int i=0;i<N;i++) rozw[i] = false;

        while(true) {
            double maxFrac = 0.0;
            int maxIndex = -1;
            for(int i=0;i<N;i++) {
                double frac = (double)W[i]/V[i];
                if(!rozw[i]) {
                    if(sumaV+V[i]<MAX_V && maxFrac<frac) {
                        maxFrac = frac;
                        maxIndex = i;
                    }
                }
            }

            if(maxIndex>-1) {
                sumaV+=V[maxIndex];
                sumaW+=W[maxIndex];
                rozw[maxIndex] = true;
            } else break;
        }

        System.out.println("Najlepsze rozwiazanie - ILORAZ");
        System.out.print("Przedmioty: ");
        for(int i=0;i<N;i++) if(rozw[i]) System.out.print((i+1)+" ");
        System.out.println("\nWartosc: "+sumaW);
    }
}