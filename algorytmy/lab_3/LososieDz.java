package algorytmy.lab_3;

public class LososieDz {
    static int populacja = 1000000;
    static int komunikat = 0;
    static double x=0;
    static public void main(String args[]){

        System.out.println(p(10000));
    }

    static public double p(int t){
        if(t == 1){
            return 1000000;
        }
        if(t > 1){

            //najpierw sie rodzą nowe, potem rekiny zjadaja 2 promile
            //potem 2 promile odplywaja

            x = (int) ((p(t-1)*Math.exp(0.003))*0.998)*0.998;

            if(x < populacja/2 && komunikat==0){
                System.out.println("W "+t+" minucie populacja lososi spadla ponizej polowy: "+x);
                komunikat++;
            }
            if(x < 100 && komunikat==1){
                System.out.println("W "+t+" minucie populacja lososi wymarla");
                komunikat++;
            }

            return x;
        }

        return 0;
    }
}