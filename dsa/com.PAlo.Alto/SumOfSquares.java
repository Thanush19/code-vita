import java.util.ArrayList;
import java.util.Scanner;

class SumOfSquares {

    static long fib(Long a) {
        ArrayList<Long> ans = new ArrayList<>();
        Long s = 0L;
        Long b = 1L;
        Long c = 0L;
        ans.add(s);
        ans.add(b);
        for (Long i = 2L; i <= a; i++) {
            c = s + b;
            ans.add(c * c);
            s = b;
            b = c;
        }
        long sum = 0;
        for (Long i : ans) {
            sum += i;
        }
        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        long ans = fib(n);
        System.out.println(ans);
    }
}
