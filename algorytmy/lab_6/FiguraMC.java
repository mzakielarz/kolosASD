package algorytmy.lab_6;

import java.util.Random;

public class FiguraMC
{
    public static void main(String[] args)
    {
        Random los = new Random();
        int licz = 0;
        for (int i = 0; i < 100; i++)
        {
            double x = los.nextInt(1001)/1000.0;
            double y = los.nextInt(1001)/1000.0;
            if(y <= Math.pow(x,2))
                licz++;
        }
        System.out.println("POLE = "+(licz/100.0));
    }

}

