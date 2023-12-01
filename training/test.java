import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: N K A
        int N = sc.nextInt();
        int K = sc.nextInt();
        double A = sc.nextDouble();

        // Input: Stock Prices
        double[] prices = new double[N];
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextDouble();
        }

        // Input: Profit Percentages
        double[] percentages = new double[N];
        for (int i = 0; i < N; i++) {
            percentages[i] = sc.nextDouble();
        }

        // Calculate profit for each stock and sort them in descending order
        double[] profits = new double[N];
        for (int i = 0; i < N; i++) {
            profits[i] = calculateProfit(K, prices[i], percentages[i]);
        }

        // Calculate maximum profit
        double maxProfit = 0;
        for (int i = 0; i < N && A > 0; i++) {
            int quantity = Math.min(K, (int) (A / prices[i]));
            maxProfit += calculateProfit(quantity, prices[i], percentages[i]);
            A -= quantity * prices[i];
        }

        // Round to the nearest integer and print the result
        System.out.println(Math.round(maxProfit));
    }

    // Function to calculate profit for a given quantity, price, and percentage
    static double calculateProfit(int quantity, double price, double percentage) {
        return quantity * (percentage * price / 100);
    }
}
