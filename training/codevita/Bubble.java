import java.util.*;

public class Bubble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ori = new int[n];
        int[] co = new int[n];
        
        for (int i = 0; i < n; i++) {
            ori[i] = sc.nextInt();
            co[i] = ori[i];
        }

        System.out.print(Math.min(coAs(ori, n), coDe(co, n)));
        
    }

    static int coDe(int[] a, int n) {
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    cnt++;
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return cnt;
    }

    static int coAs(int[] a, int n) {
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    cnt++;
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return cnt;
    }
}
