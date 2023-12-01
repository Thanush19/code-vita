import java.util.*;

public class HoleAndBalls {
    static int[] count(int[] b, int[] h) {
        int[] ans = new int[b.length];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < h.length; i++) {
            mp.put(i+1, 0);
        }

        for (int i = 0; i < b.length; i++) {
            int ball = b[i];
            boolean placed = false;
            for (int j = h.length - 1; j >= 0; j--) {
                int hole = h[j];
                if (ball <= hole && mp.get(j + 1) < (j + 1)) {
                    ans[i] = j + 1;
                    mp.put(j + 1, mp.get(j + 1) + 1);
                    placed = true;
                    break;
                }
            }
            

            if (!placed) {
                ans[i] = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); 
        int[] holes = new int[n];
        int[] balls = new int[m];

        for (int i = 0; i < n; i++) {
            holes[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            balls[i] = sc.nextInt();
        }

        int[] result = count(balls, holes);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
