import java.util.Scanner;

public class SnakeAndLadder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] board = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.next();
            }
        }

        int[] dieInputs = new int[10];
        for (int i = 0; i < 10; i++) {
            dieInputs[i] = sc.nextInt();
        }

        int playerPosition = 1;
        int snakesEncountered = 0;
        int laddersEncountered = 0;

        for (int i = 0; i < 10; i++) {
            playerPosition += dieInputs[i];

            if (playerPosition <= 100) {
                int row = 9 - (playerPosition - 1) / 10;
                int col = (playerPosition - 1) % 10;
                String cell = board[row][col];

                if (cell.startsWith("S")) {
                    int snakePosition = Integer.parseInt(cell.substring(2, cell.length() - 1));
                    playerPosition = snakePosition;
                    snakesEncountered++;
                } else if (cell.startsWith("L")) {
                    int ladderPosition = Integer.parseInt(cell.substring(2, cell.length() - 1));
                    playerPosition = ladderPosition;
                    laddersEncountered++;
                }
                
            }
        }

        if (playerPosition == 100) {
            System.out.println("Possible " + snakesEncountered + " " + laddersEncountered);
        } else {
            System.out.println("Not possible " + snakesEncountered + " " + laddersEncountered + " " + playerPosition);
        }

    }
}
