import java.util.Scanner;

public class FibSum {

    static Long sumOfFib(Long n) {
        long a = 0;
        long b = 1;
        long c = 0;
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += a;
            c = a + b;
            a = b;
            b = c;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        Long ans = sumOfFib(n);
        System.out.println(ans);

        // String resultString = String.valueOf(ans);

        // if (m >= 1 && m <= resultString.length()) {
        //     char nthDigit = resultString.charAt(m - 1);
        //     System.out.print(nthDigit);
        // } else {
        //     System.out.println("Invalid digit position");
        // }
    }
}
