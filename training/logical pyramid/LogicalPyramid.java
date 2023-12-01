import java.util.*;

public class LogicalPyramid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 6, b = 22;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%05d ", a);
                a = a + b;
                b += 16;
            }
            System.out.println();
        }
    }
}
