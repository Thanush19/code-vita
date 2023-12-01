import java.util.Scanner;

public class TicketBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Read seating plan
        char[][] seatingPlan = new char[N][];
        for (int i = 0; i < N; i++) {
            seatingPlan[i] = scanner.nextLine().toCharArray();
        }

        // Read the list of groups
        String[] groupsString = scanner.nextLine().split(",");
        int[] groups = new int[groupsString.length];
        for (int i = 0; i < groupsString.length; i++) {
            groups[i] = Integer.parseInt(groupsString[i]);
        }

        // Read the cost of each seat in a row
        String[] costString = scanner.nextLine().split(" ");
        int[] cost = new int[costString.length];
        for (int i = 0; i < costString.length; i++) {
            if (!costString[i].equals("?")) {
                cost[i] = Integer.parseInt(costString[i]);
            }
        }

        // Read total collection
        int totalCollection = scanner.nextInt();

        // Calculate the cost of each seat in the missing row
        int totalCost = calculateTotalCost(cost, seatingPlan);
        int seatsLeft = 0;

        for (char[] row : seatingPlan) {
            for (char seat : row) {
                if (seat == '_') {
                    seatsLeft++;
                }
            }
        }

        int missingRowCost = (seatsLeft > 0) ? (totalCollection - totalCost) / seatsLeft : 0;

        // Print the seating arrangement after booking
        for (char[] row : seatingPlan) {
            for (char seat : row) {
                System.out.print(seat);
            }
            System.out.println();
        }

        // Print the number of seats left and priority groups not booked
        System.out.print(seatsLeft);
        for (int group : groups) {
            System.out.print(" " + group);
        }
        System.out.println();

        // Print the cost of each seat in the missing row
        System.out.println(missingRowCost);

        scanner.close();
    }

    // Helper method to calculate the total cost of booked seats
    private static int calculateTotalCost(int[] cost, char[][] seatingPlan) {
        int totalCost = 0;

        for (int row = 0; row < seatingPlan.length; row++) {
            for (int col = 0; col < seatingPlan[row].length; col++) {
                if (seatingPlan[row][col] != '_') {
                    int priority = seatingPlan[row][col] - '1';
                    totalCost += cost[priority];
                }
            }
        }

        return totalCost;
    }
}
