package algorytmy;

public class asd {
    public static void main(String[] args) {
        System.out.println(BakterieDZ(12,1));
    }
    static int BakterieDZ(int liczbaBakter,int minuta){

        if(liczbaBakter < 12000){
            if (minuta % 2 == 0){
                if(minuta % 10 == 0){
                    System.out.println("minely 10 minuty " + liczbaBakter + " " + minuta);
                    return BakterieDZ((int) (liczbaBakter * 0.5),minuta + 1);
                }
                System.out.println("minely 2 minuty " + liczbaBakter + " " + minuta);
                return BakterieDZ(liczbaBakter * 2,minuta + 1);


            } else {
                return BakterieDZ(liczbaBakter, minuta + 1);
            }
        }else {

            System.out.println("liczbaBakteri == "+ 12*1000);
            return minuta;
        }

    }
}
