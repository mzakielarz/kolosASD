package cwiczenia_algorytmy.algorytmyZachlanne;

public class LodyAZ {
    static int[][] lody ={
            {0,7,20,21,12,23}, // 0
            {27,0,13,16,46,5}, // 1
            {53,15,0,25,27,6}, // 2
            {16,2,35,0,47,10}, // 3
            {31,29,5,18,0,4}, // 4
            {28,24,1,17,5,0},  // 5
    };
    public static void main(String args[]){

        l(1);
    }

    static void l(int startIndex){
        boolean[] uzyte = new boolean[lody.length];
        uzyte[startIndex] = true;
        int cIndex=startIndex;
        int used=0;
        int koszta=0;
        String lista="";
        lista+= String.valueOf(cIndex+1)+"->";

        while(used < 5){
            int low=99;
            int lIndex=0;

            for(int i=0; i< lody.length; i++){
                if(lody[cIndex][i] < low && lody[cIndex][i] > 0 && !uzyte[i]){
                    low=lody[cIndex][i];
                    lIndex=i;
                }
            }
            uzyte[lIndex]=true;
            cIndex=lIndex;
            koszta+=low;
            used++;
            lista+= String.valueOf(lIndex+1)+"->";
        }
        lista+= String.valueOf(startIndex+1);
        koszta+=lody[cIndex][startIndex];
        System.out.println("Proces przestrajania maszyny: ");
        System.out.println(lista);
        System.out.println("Czas przestrajania: ");
        System.out.println(koszta);
    }
}
