public class DiZ {
    public static void main(String[] args) {
     //   zgadywanie(0,1000);
        plecak(6-1,10);
        rozrod(30);
        //  System.out.println(plecakreku(N-1,maxV));
    }
    // plecak
    final static int[] V = {6, 2, 3, 2, 3, 1};
    final static int[] W = {6, 4, 5, 7, 10, 2};
    static int vmax=10;
    static int plecak(int i,int v){
        if(i==0 && v<V[0]) return 0;
        if(i==0 && v>=V[0]) return W[0];
        if(i>0 && v<V[i]) return plecak(i-1,v);
        else return Math.max(plecak(i-1,v),W[i]+plecak(i-1,v-V[i]));

    }
    //ZGADYWANIE
    static int N = 456;
    static void zgadywanie(int a, int b){ // x to strzał
        int x = (a+b)/2;
        if(x==N){
            System.out.println("Czy myslisz o: "+x);
            System.out.println("Tak mysle o: "+x);
        }
        if(x>N){
            System.out.println("Czy myslisz o: "+x);
            System.out.println("Za dużo");
            zgadywanie(a,x-1);
        }
        if(x<N){
            System.out.println("Czy myslisz o: "+x);
            System.out.println("Za malo");
            zgadywanie(x+1,b);
        }
    }
    //KRÓLIKI
    static boolean sto, tysiac, dtys, stys, milion;
    public static int rozrod(int n){
        if(n ==1 || n ==2) return 1;
        int kroliki =  rozrod(n-1)+rozrod(n-2);
        if(kroliki>100 && sto==false){
            sto=true;
            System.out.println("Sto krolikow po: "+n);
        }
        if(kroliki>1000 && tysiac==false){
            tysiac=true;
            System.out.println("1000 krolikow po: "+n);
        }
        if(kroliki>10000 && dtys==false){
            dtys=true;
            System.out.println("10000 krolikow po: "+n);
        }
        if(kroliki>100000 && stys==false){
            stys=true;
            System.out.println("10000 krolikow po: "+n);
        }
        if(kroliki>1000000 && milion==false){
            milion=true;
            System.out.println("1000000 krolikow po: "+n);
        }


        return kroliki;
    }
    // plecak
 /*
    static int[] V={6, 2, 3, 2, 3, 1};
    static int[] W={6, 4, 5, 7, 10, 2};
    static int maxV = 10;
    static int N = 6;
    public static int plecakreku(int i, int v)
    {
        if(i==0 && v<V[0]) return 0;
        if(i==0 && v>=V[0]) return W[0];
        if(i>0 && v<V[i]) return plecakreku(i-1,v);
        else  return Math.max(plecakreku(i-1,v),+W[i]+plecakreku(i-1,v-V[i]));

    }*/

}
