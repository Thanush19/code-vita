import java.util.*;

public class MazeRunner {
    public static final int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int C = scanner.nextInt();

        int[][] maze = new int[R][C];

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                maze[i][j] = scanner.nextInt();
            }
        }

        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        System.out.println(findShortestPath(maze, r1, c1, r2, c2));
    }

    public static int findShortestPath(int[][] maze, int r1, int c1, int r2, int c2) {
        int R = maze.length;
        int C = maze[0].length;

        int[][][] dp = new int[R][C][3];

        for (int[][] d : dp) {
            for (int[] dd : d) {
                Arrays.fill(dd, INF);
            }
        }

        dp[r1][c1][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r1, c1, 0, 0});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            int danger = point[2];
            int dist = point[3];

            if (row == r2 && col == c2) {
                return dist;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C && maze[newRow][newCol] != 1) {
                    int newDanger = danger + (maze[newRow][newCol] == 3 ? 1 : 0);

                    if (newDanger <= 2 && dist + 1 < dp[newRow][newCol][newDanger]) {
                        dp[newRow][newCol][newDanger] = dist + 1;
                        queue.offer(new int[]{newRow, newCol, newDanger, dist + 1});
                    }
                }
            }
        }

        return -1;
    }
}