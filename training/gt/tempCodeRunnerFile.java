import java.util.*;

public class Fibo {

    static long fib(long n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long result = fib(n);
        System.out.println( result%10);
    }
}
