import java.util.*;

public class Jumbled {
    static int getMathewNumber(int n) {
        return n * (2 * n - 1);
    }

    static int getJohnNumber(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();

            int m = sc.nextInt();

            if (t1 > t2 || m < 1) {
                System.out.println("Invalid Input");
                return;
            }
            int[] ans = new int[10];
            int k =0;

            for (int i = t1; i <= t2; i++) {
                int mathewNumber = getMathewNumber(i);
                int johnNumber = getJohnNumber(i);

                if (mathewNumber == johnNumber) {
                    ans[k++]=johnNumber;
                    System.out.println(johnNumber);
                }
            }

            if (m <= ans.length&&m>0) {
                System.out.println(ans[m - 1]);
            } else {
                System.out.println("No number is present at this index");
            }
        }
    }
}
