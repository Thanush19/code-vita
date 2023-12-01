import java.util.Scanner;

public class Staircase {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int ncrFormula(int n, int r) {
        if (r > n) {
            return 0;
        } else {
            return factorial(n) / (factorial(r) * factorial(n - r));
        }
    }

    public static void printCombinations(int n, int r) {
        System.out.println("Possible Combinations for R = " + r + ", N = " + n + ":");
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    System.out.print("(" + i + "," + j + "," + k + ") & (");
                    int l = 1;
                    while (l <= n) {
                        if (l != i && l != j && l != k) {
                            System.out.print(l);
                            if (l < n - 2) {
                                System.out.print(",");
                            }
                        }
                        l++;
                    }
                    System.out.println(")");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of R: ");
        int r = scanner.nextInt();

        int result = ncrFormula(n, r);
        System.out.println("C(" + n + ", " + r + ") = " + result);

        printCombinations(n, r);
    }
}