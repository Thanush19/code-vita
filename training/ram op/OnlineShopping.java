import java.util.*;

class OnlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input values
        int n = sc.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }

        int[] claim = new int[n];
        for (int i = 0; i < n; i++) {
            claim[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String[] itemsInfo = sc.nextLine().split(" |:");
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < itemsInfo.length; i += 2) {
            String itemName = itemsInfo[i].trim();
            int cost = Integer.parseInt(itemsInfo[i + 1].trim());
            items.add(new Item(itemName, cost));
        }
        
        // Calculate the total available tokens
        int totalAvailableTokens = calculateTotalAvailableTokens(tokens, claim);

        // Calculate the maximum tokens Mithra can have after using the bumper offer
        int maxTokens = calculateMaxTokens(tokens, claim, k);

        // Find the items with minimal wastage
        List<String> selectedItems = findItemsWithMinimalWastage(items, maxTokens - totalAvailableTokens);

        // Print the result
        for (String item : selectedItems) {
            System.out.println(item);
        }

        sc.close();
    }

    private static int calculateTotalAvailableTokens(int[] tokens, int[] claim) {
        int totalAvailableTokens = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (claim[i] == 0) {
                totalAvailableTokens += tokens[i];
            }
        }
        return totalAvailableTokens;
    }

    private static int calculateMaxTokens(int[] tokens, int[] claim, int k) {
        int maxTokens = 0;
        for (int i = 0; i <= tokens.length - k; i++) {
            int currentTokens = calculateTokensInRange(tokens, claim, i, i + k - 1);
            maxTokens = Math.max(maxTokens, currentTokens);
        }
        return maxTokens;
    }

    private static int calculateTokensInRange(int[] tokens, int[] claim, int start, int end) {
        int currentTokens = 0;
        for (int i = start; i <= end; i++) {
            if (claim[i] == 0) {
                currentTokens += tokens[i];
            }
        }
        return currentTokens;
    }

    private static List<String> findItemsWithMinimalWastage(List<Item> items, int wastage) {
        List<String> selectedItems = new ArrayList<>();
        Collections.sort(items);

        for (Item item : items) {
            if (item.cost <= wastage) {
                selectedItems.add(item.name);
                wastage -= item.cost;
            } else {
                break; // No need to check further, as items are sorted by cost
            }
        }

        return selectedItems;
    }

    static class Item implements Comparable<Item> {
        String name;
        int cost;

        public Item(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public int compareTo(Item other) {
            return this.name.compareTo(other.name);
        }
    }
}
