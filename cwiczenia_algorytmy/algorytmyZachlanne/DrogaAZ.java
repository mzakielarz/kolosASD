package cwiczenia_algorytmy.algorytmyZachlanne;

public class DrogaAZ {
    static String[] miasta = {"Warszawa","Katowice","Zakopane","Lwow","Weieden","Budapeszt","Bukareszt",
            "Zagrzeb","Sofia"};
    static int[][] polaczenia = {
            {0,300,402,356,-1,-1,-1,-1,-1}, //0
            {300,0,-1,-1,440,473,-1,-1,-1}, //1
            {402,-1,0,-1,-1,330,-1,-1,-1},  // 2
            {356,-1,-1,0,-1,-1,823,-1,-1},  // 3
            {-1,440,-1,-1,0,-1,-1,430,-1},  // 4
            {-1,474,330,-1,-1,0,813,365,774}, // 5
            {-1,-1,-1,823,-1,813,0,-1,403}, // 6
            {-1,-1,-1,-1,430,365,-1,0,768}, //7
            {-1,-1,-1,-1,-1,774,403,768,0} //8
    };

    static public void main(String args[]){
        d();
    }

    static void d(){
        // Szukanie najlepszego miasta na start
        int index=0;
        int pol=0;
        for(int i=0; i<miasta.length; i++){
            int p=0;
            for(int j=0; j< miasta.length; j++){
                if(polaczenia[i][j] > 0) {
                    p++;
                }
            }
            if(p > pol) {
                pol = p;
                index = i;
            }
            if(p==1) System.out.println(miasta[i]+" ma "+p+" polaczenie");
            else System.out.println(miasta[i]+" ma "+p+" polaczenia");

        }

        //Szukanie trasy
        //boze wybacz mi za to co zaraz napisze
        int obecnyKraj = index;
        System.out.println(obecnyKraj);
        String odwiedzone = "";
        odwiedzone+=miasta[index]+" ";
        int ODWIEDZONEKURWA = 0;
        int kilometry=0;

        while(ODWIEDZONEKURWA < 8){
            int lindex=0;
            int low=1000;
            // szuka najmniejszej trasy + sprawdza czy miasto bylo juz odwiedzone
            for(int i=0; i<9; i++){
                if(polaczenia[obecnyKraj][i] < low && polaczenia[obecnyKraj][i] > 0 && !(odwiedzone.contains(miasta[i]))){
                    low=polaczenia[obecnyKraj][i];
                    lindex=i;
                }
            }
            System.out.println(miasta[obecnyKraj]+" -> "+miasta[lindex]+" ("+low+"km)");
            odwiedzone+=miasta[lindex]+" ";
            obecnyKraj=lindex;
            kilometry+=low;
            ODWIEDZONEKURWA++;
        }
        System.out.println("Odwiedzone miasta (w kolejnosci): ");
        System.out.println(odwiedzone);
        System.out.print("Zrobione kilometry: ");
        System.out.println(kilometry);

    }

}