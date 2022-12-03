package cwiczenia_algorytmy.programowanieDynamiczne;

public class EpidemiaDyn {

    static int populacja = 100000;
    static int[] chorzy = new int[100];
    static int[] nowiChorzy = new int[100];
    static int[] zdrowi = new int[100];
    static int[] ozdrowiency = new int[100];


    public static void main(String[] args) {
        epidemia();
    }

    static void epidemia() {

        chorzy[0] = 10;
        nowiChorzy[0] = 10;
        zdrowi[0] = populacja - chorzy[0];

        System.out.println(0 + " dzien) zdrowi: " + zdrowi[0] + " chorzy: " + chorzy[0] + " nowi chorzy: " + nowiChorzy[0]);

        int dni = 20;
        for (int i = 1; i <= dni; i++) {
            if (i >= 7) {
                ozdrowiency[i] = chorzy[i - 7];
            }

            chorzy[i] = ((chorzy[i - 1] / 2) * 2 + chorzy[i - 1] - ozdrowiency[i]);
            nowiChorzy[i] = (chorzy[i] / 2) * 2;
            zdrowi[i] = populacja - chorzy[i];

            System.out.println(i + " dzien) zdrowi: " + zdrowi[i] + " chorzy: " + chorzy[i] + " nowi chorzy: " + nowiChorzy[i] + " ozdrowiency: " + ozdrowiency[i]);
            if (chorzy[i] >= populacja / 2) {
                System.out.println(i + " dzien) zdrowi: " + zdrowi[i] + " chorzy: " + chorzy[i] + " nowi chorzy: " + nowiChorzy[i] + " ozdrowiency: " + ozdrowiency[i]);
                System.out.println("Populacja chorych przekroczyla polowe! ");
                break;
            }
        }
    }
}
