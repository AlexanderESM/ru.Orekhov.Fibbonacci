import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {
    //рекурсия

    public static BigInteger fibonacciRecursion(BigInteger index) {
        if (index.compareTo(BigInteger.ZERO) == 0)
            return BigInteger.ZERO;
        else if (index.compareTo(BigInteger.valueOf(1)) == 0)
            return BigInteger.ONE;
        else
            return fibonacciRecursion(index.subtract(BigInteger.ONE)).add(fibonacciRecursion(index.subtract(BigInteger.TWO)));
    }


    //цикл
    static BigInteger bigIntegerLoop(int n){
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(0);

        for (int j=2 ; j<=n ; j++){
            c =  a.add(b);
            a = b;
            b = c;
        }
        return (c);
    }

    //массив
    static BigInteger dynamicBigIntFib(int n){
        //массив для хранения чисел Фибоначчи.
        int f[] = new int[n+2]; // +1 дополнительный для обработки регистра, n = 0
        int i;

        // 0-й и 1-й номер серии - 0 и 1
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++){
            // Добавить 2 предыдущих номера в серии и сохранить его
            f[i] = f[i-1] + f[i-2];
        }
        return BigInteger.valueOf(f[n]);
    }

    //Мемоизация
    private static Map<Integer, BigInteger> memo = new HashMap<>();
    public static BigInteger fibMap(int n) {
        if (n <= 2)  return BigInteger.ONE;
        else if (memo.containsKey(n))
            return memo.get(n);

        else {
            BigInteger one = new BigInteger("1");
            BigInteger two = new BigInteger("2");
            BigInteger value = fibMap(n - 2).add(fibMap(n - 1));

            memo.put(n, value);
            return value;
        }
    }




    //(используя формулу
    public static int fibArithmetic(int n) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5)/2;
        int result = (int) ((Math.pow(phi, n) - Math.pow(-phi, -n))/squareRootOf5);
        return result;
    }


    public static void main(String[] args) {
        int n=10;
        //рекурсия
        System.out.println("by recursion="+fibonacciRecursion( BigInteger.valueOf(n) ));

        //цикл
        System.out.println("by loop="+bigIntegerLoop(n) );

        //массив
        System.out.println("by array="+dynamicBigIntFib(n) );

        //Мемоизация
        System.out.println("by Memoization ="+fibMap(n) );




        //формула
        System.out.println("by Formula="+ fibArithmetic(n) );


    }

}
