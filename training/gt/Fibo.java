import java.util.*;

 class Fibo {

    static long fib(long n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int a =0;
        int b =1;
        int c =0;
        for(long i =2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long result = fib(n);
        System.out.println( result%10);
    }
}
