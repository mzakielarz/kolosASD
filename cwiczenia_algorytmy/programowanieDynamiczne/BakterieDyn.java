package cwiczenia_algorytmy.programowanieDynamiczne;

public class BakterieDyn {


    public static void main(String[] args) {
        bakterie();
    }

    static void bakterie() {

        int minuty = 0;
        int[] liczbaBakteri = new int[100];

        liczbaBakteri[0] = 12;

        for (int i = 1; i < liczbaBakteri.length; i++) {
            liczbaBakteri[i] = liczbaBakteri[i - 1] * 2;
            for (int j = 1; j < liczbaBakteri.length; j++) {
                if (minuty == j * 10) {
                    liczbaBakteri[i] = liczbaBakteri[i] / 2;
                }
            }
            minuty = minuty + 2;

            if (liczbaBakteri[i] >= liczbaBakteri[0] * 1000) {
                System.out.println("Liczba bakteri zwiekszyla sie 1000 razy po: " + minuty + " minutach");
                break;
            }
        }

    }
}
