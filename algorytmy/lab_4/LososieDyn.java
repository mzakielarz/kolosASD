package algorytmy.lab_4;

public class LososieDyn {
    public static void main(String args[]){
        System.out.println(p(10000,1000000));
    }

    static public double p(int t, int populacja){
        double[] tab = new double[t-1];
        tab[0] = populacja;
        int k =0;

        for(int i=1; i < t-1; i++){
            tab[i] = (int) ((tab[i-1]*Math.exp(0.003)*0.998)*0.998);
            if(tab[i] < populacja/2 && k==0){
                System.out.println("Populacja lososi spadla ponizej polowy w " +
                        i+" minucie i wynosi: "+tab[i]);
                k++;
            }
            if(tab[i] < 100 && k==1){
                System.out.println("Populacja lososi wymarla w "+i+" minucie");
                k++;
            }
        }

        return tab[t-2];
    }
}