import java.util.Scanner;

public class Zachlanny {
    public static void main(String[] args) {
        // zaloga();
        // lody();
        reszta();

    }

    static void zaloga(){
        final int[][] kosmonauci = {
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };

        //Zachlannie po iloscie dziedzin znanych przez astronautow
        final int[] sumaDziedzin = new int[kosmonauci.length];
        boolean[] poleca = new boolean[kosmonauci.length];
        boolean[] zaliczoneDziedziny = new boolean[kosmonauci[0].length];

        for (int j = 0; j < kosmonauci.length ; j++) {
            for (int k = 0; k <kosmonauci[0].length ; k++) {
                sumaDziedzin[j]+=kosmonauci[j][k];
            }
        }
        int i=0;
        while (true) {
            int pozycja = -1;
            if (i<5) {
                if ( !poleca[i]) {
                    pozycja = i; // i=0 pozycja=0
                }

                if (pozycja > -1) {
                    poleca[pozycja] = true;

                    for (int j = 0; j < zaliczoneDziedziny.length; j++) {  if (kosmonauci[pozycja][j] == 1) zaliczoneDziedziny[j] = true;}

                }

                boolean czyZaliczone = true;

                for (int j = 0; j < zaliczoneDziedziny.length; j++) {  if(!zaliczoneDziedziny[j]) czyZaliczone=false;}

                if (czyZaliczone) break; // czy mamy wszystkich astro
                else i++;
            }
        }
        System.out.print("Moga poleciec: ");
        for (i=0;i<kosmonauci.length;i++) if (poleca[i]) System.out.print(i+1 + " ");
    }
    // LOuDY
    public static void lody(){

        final int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 1, 0,  4 },
                {28, 24, 5, 17, 5,  0}
        };
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
        System.out.println("Smaki:");
        System.out.println(wiersz+1);
        bylo[wiersz]=true;
        int minIndex =-1;

        //Sprawdzamy na jakie smaki kolejno przerobić
        for(int i=0;i< koszty.length-1;i++){
            min=Integer.MAX_VALUE;
            for(int j=0;j< koszty.length;j++){
                if(koszty[wiersz][j]<min &&koszty[wiersz][j]>0 && bylo[j]==false){
                    min=koszty[wiersz][j];
                    minIndex=j;
                }
            }
            wiersz=minIndex;
            bylo[minIndex]=true;
            System.out.println(wiersz+1);
        }

        //Sprawdzamy na jaki smak przestroić na końcu
        for(int i=0;i< koszty.length;i++){
            if(koszty[wiersz][i]<min &&koszty[wiersz][i]>0){
                min=koszty[wiersz][i];
                minIndex=i;
            }
        }
        System.out.println(minIndex+1);
    }

    // RESZTA
    public static void reszta() {
        final int[] M = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        final int[] L = {1, 2, 0, 7, 2, 2, 5, 2, 10};
        int zl, gr, r, i = 0;
        int[] ile_monet = new int[9];
        r = 2137;
        while (r > 0) {
            if (r >= M[i] && L[i] != 0) {
                System.out.print(M[i] / 100.0 + " ");
                r -= M[i];
                ile_monet[i]++;
                L[i]--;
            } else
                i++;
            if (i == M.length) break;
        }
        if (r > 0) System.out.println("Nie mogę wydać: " + r);
        System.out.println();
        for (int j = 0; j < M.length; j++) {
            System.out.println("Nominał " + M[j] + " wydany będzie:" + ile_monet[j]);
        }
        System.out.println("W kasie zostało:");
        for (int j = 0; j < ile_monet.length; j++) {
            System.out.println(((double) M[j] / 100) + "zł, sztuk: " + ile_monet[j]);
        }
    }


}
