package algorytmy.lab_3;

public class FiboDz {
    public static void main(String[] args) {
        final int N = 5; // n-ty wyraz ciągu
        System.out.println(fibo(N));
    }

    static int fibo(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return fibo(n - 1) + fibo(n - 2);
    }
}//dany jest ciąg liczbowy którego pierwsze 3 wyrazy są dane koeljno 1,2,3 zaś każdy następny jest dany iloczynowi poprzedniego i sumy 2 poprzednich
//L(n)  ,n=1,2,3,
//L(n-1) * [L(n-2)+L(n-3)]

//1,n=1,2
//5, n=3
//L(n-1)+L(n-2), n=2k, k nazleży do Z+, k>=2 <--parzyste
//n=2k+1 <--nieparzyste

//(n)  {1 n=k,k=0
//(k)  {(n-1)+(n-1)
//     {(k-1)  (k)    0<k<n
//         {1
//L(k,n) = {L(k-1,n-1)+L(k,n-1)