package algorytmy.lab_1;

public class Trojki {
    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        int c = 0;


        for (int x = 1; x <= 100; x++) {
            a++;
            for (int y = x + 1; y <= 100; y++) {
                b++;
                for (int z = y + 1; z <= 100; z++) {
                    c++;
                    if (x * x + y * y == z * z) System.out.println(x + " " + y + " " + z);
                }
            }
        }
        System.out.println();
        System.out.println(a + " + " + b + " + " + c + " = " + (a + b + c));
    }
}
