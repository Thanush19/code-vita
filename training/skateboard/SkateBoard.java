import java.util.Scanner;

public class SkateBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        sc.nextLine(); 

        String[][] grid = new String[n][n];

        for (int row = 0; row < n; row++) {
            String line = sc.nextLine();
            String[] elements = line.split(",");

            for (int col = 0; col < n; col++) {
                grid[row][col] = elements[col];
            }
        }


        int ans = calculateSafeStartingPoints(n, grid);

        System.out.println(ans);

    }

    
    private static int calculateSafeStartingPoints(int n, String[][] grid) {
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (canReachFinalDestination(0, col, n, grid)) {
                count++;
            }
        }

        for (int row = 1; row < n; row++) {
            if (canReachFinalDestination(row, 0, n, grid)) {
                count++;
            }
        }

        return count;
    }

    private static boolean canReachFinalDestination(int row, int col, int n, String[][] grid) {
        if (grid[row][col].equals("D")) {
            return false;
        }

        if (grid[row][col].equals("F")) {
            return true;
        }

        for (char direction : grid[row][col].toCharArray()) {
            switch (direction) {
                case 'N':
                    if (row > 0 && canReachFinalDestination(row - 1, col, n, grid)) {
                        return true;
                    }
                    break;
                case 'E':
                    if (col < n - 1 && canReachFinalDestination(row, col + 1, n, grid)) {
                        return true;
                    }
                    break;
                case 'S':
                    if (row < n - 1 && canReachFinalDestination(row + 1, col, n, grid)) {
                        return true;
                    }
                    break;
                case 'W':
                    if (col > 0 && canReachFinalDestination(row, col - 1, n, grid)) {
                        return true;
                    }
                    break;
            }
        }

        return false;

    }
}
