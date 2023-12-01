import java.util.*;

public class SortingBoxes {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int effort = 2 * a[k - 1] * getMin(a) + getMax(a) * getMin(a);
            System.out.println(effort);
        }
    }

    static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            min = Math.min(min, value);
        }
        return min;
    }

    static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            max = Math.max(max, value);
        }
        return max;
    }
}
