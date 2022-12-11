public class Dyn {
    public static void main(String[] args) {
       // plecak();
        //kroliki();
       // plecak2();
      //  kroliki2();


    }
    // plecak
    static void plecak(){
         int[] V={6, 2, 3, 2, 3, 1};
         int[] W={6, 4, 5, 7, 10, 2};
         int N=6;
         int przedmioty = V.length;
         final int maxv =10;
         int[][] tab = new int[przedmioty][maxv+1];
        for (int i = 0; i < N; i++) {
            for (int v = 0; v <= maxv; v++) {
                if(i==0 && v<V[i]) tab[i][v] = 0;
                else if(i==0 && v>=V[i]) tab[i][v] = W[i];
                else if(i>0 && v<V[i]) tab[i][v] = tab[i-1][v];
                else if(i>0 && v>=V[i]) tab[i][v] = Math.max(tab[i-1][v],W[i] + tab[i-1][v-V[i]]);
            }
        }
        System.out.println(tab[przedmioty-1][maxv]);

    }
    // KRÓLIKI
    static void kroliki(){
        int N = 13;
        int[] tab = new int[N];
        tab[0]=1;
        tab[1]=1;
        for (int i = 2; i < tab.length ; i++) {
            tab[i]= tab[i-1]+tab[i-2];
        }
        System.out.println(tab[N-1]);
    }
    // plecak
    static void plecak2(){
        int[] V={6, 2, 3, 2, 3, 1};
        int[] W={6, 4, 5, 7, 10, 2};
        int maxv=10;
        int przedmioty = V.length;
        int[][] tab = new int[przedmioty][maxv+1];
        for (int i = 0; i <przedmioty ; i++) {
            for (int v = 0; v <= maxv; v++) {
                if(i==0 && v<V[i]) tab[i][v] =0;
                else if(i==0 && v>=V[i]) tab[i][v] =W[i];
                else if(i>0 && v<V[i]) tab[i][v] = tab[i-1][v];
                else if (i>0 && v>=V[i]) tab[i][v] = Math.max(tab[i-1][v],W[i]+tab[i-1][v-V[i]]);
            }
        }
        System.out.println(tab[przedmioty-1][maxv]);
    }
    // KRÓLIK
   static  boolean sto;
    static void kroliki2(){

        int N = 15;
        int[] tab = new int[N];
        tab[0]=1;
        tab[1]=1;
        for (int i = 2; i < tab.length; i++) {
            tab[i] = tab[i-1]+tab[i-2];
        }
        System.out.println(tab[N-1]);
    }


}
