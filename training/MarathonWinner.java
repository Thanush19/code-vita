import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MarathonWinner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        Map<Integer, Integer> leadCount = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int totalLeadCount = 0;

            for (int j = 1; j < T; j += 2) {
                int[] steps = new int[T + 1];

                for (int k = 1; k <= T; k++) {
                    steps[k] = sc.nextInt();
                }

                int[] distance = new int[T + 1];
                for (int k = 1; k <= T; k++) {
                    distance[k] = distance[k - 1] + steps[k];
                }

                if (distance[j] >= distance[j - 1]) {
                    totalLeadCount++;
                }
            }

            leadCount.put(i, totalLeadCount);
        }

        int winner = findWinner(leadCount);

        System.out.println(winner);

    }

    private static int findWinner(Map<Integer, Integer> leadCount) {
        int maxLeadCount = Integer.MIN_VALUE;
        int winner = -1;

        for (Map.Entry<Integer, Integer> entry : leadCount.entrySet()) {
            int participant = entry.getKey();
            int lead = entry.getValue();

            if (lead > maxLeadCount || (lead == maxLeadCount && participant < winner)) {
                maxLeadCount = lead;
                winner = participant;
            }
        }

        return winner;
    }
}
