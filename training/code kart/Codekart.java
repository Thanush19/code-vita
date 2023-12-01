import java.util.HashMap;
import java.util.Scanner;

class Codekart {
    static class Inventory {
        HashMap<String, Item> items;

        public Inventory() {
            this.items = new HashMap<>();
        }

        public boolean addItem(String itemName, int qty) {
            if (!items.containsKey(itemName)) {
                Item newItem = new Item();
                newItem.qty = qty;
                items.put(itemName, newItem);
                return true;
            } else {
                return false;
            }
        }

        public boolean removeItem(String itemName) {
            if (items.containsKey(itemName)) {
                items.remove(itemName);
                return true;
            } else {
                return false; // Item not found
            }
        }

        public int getItemQty(String itemName) {
            return items.containsKey(itemName) ? items.get(itemName).qty : 0;
        }

        public boolean incrementItemQty(String itemName, int qty) {
            if (items.containsKey(itemName)) {
                Item currentItem = items.get(itemName);
                currentItem.qty += qty;
                return true;
            } else {
                return false; // Item not found
            }
        }

        public boolean decrementItemQty(String itemName, int qty) {
            if (items.containsKey(itemName)) {
                Item currentItem = items.get(itemName);
                if (currentItem.qty - qty > 0) {
                    currentItem.qty -= qty;
                } else {
                    items.remove(itemName);
                }
                return true;
            } else {
                return false; // Item not found
            }
        }

        public boolean setItemCost(String itemName, double cost) {
            if (items.containsKey(itemName)) {
                Item currentItem = items.get(itemName);
                currentItem.cost = cost;
                return true;
            } else {
                return false; // Item not found
            }
        }
    }

    static class Item {
        int qty;
        double cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            Inventory inventory = new Inventory();
            Inventory cart = new Inventory();

            String command = scanner.nextLine().trim();
            while (!command.equals("END")) {
                String[] tokens = command.split(" ");
                String role = tokens[0];
                String operation = tokens[1];

                switch (role) {
                    case "CMD":
                        processStoreManagerCommand(operation, inventory, tokens);
                        break;
                    case "S":
                        processShopperCommand(operation, inventory, cart, tokens);
                        break;
                }

                command = scanner.nextLine().trim();
            }
        }
    }

    private static void processStoreManagerCommand(String operation, Inventory inventory, String[] tokens) {
        String itemName = tokens[3];
        int qty = Integer.parseInt(tokens[4]);
        double cost;

        switch (operation) {
            case "ADD":
                if (inventory.addItem(itemName, qty)) {
                    System.out.println(qty);
                } else {
                    System.out.println(-1);
                }
                break;
            case "REMOVE":
                if (inventory.removeItem(itemName)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
                break;
            case "GET_QTY":
                System.out.println(inventory.getItemQty(itemName));
                break;
            case "INCR":
                if (inventory.incrementItemQty(itemName, qty)) {
                    System.out.println(qty);
                } else {
                    System.out.println(-1);
                }
                break;
            case "DCR":
                if (inventory.decrementItemQty(itemName, qty)) {
                    System.out.println(qty);
                } else {
                    System.out.println(-1);
                }
                break;
            case "SET_COST":
                cost = Double.parseDouble(tokens[4]);
                if (inventory.setItemCost(itemName, cost)) {
                    System.out.println(String.format("%.1f", cost));
                } else {
                    System.out.println(-1);
                }
                break;
        }
    }

    private static void processShopperCommand(String operation, Inventory inventory, Inventory cart, String[] tokens) {
        String itemName = tokens[2];
        int qty = Integer.parseInt(tokens[3]);

        switch (operation) {
            case "ADD":
                if (cart.addItem(itemName, qty)) {
                    System.out.println(qty);
                } else {
                    System.out.println(-1);
                }
                break;
            case "REMOVE":
                if (cart.removeItem(itemName)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
                break;
            case "INCR":
                if (cart.incrementItemQty(itemName, qty)) {
                    System.out.println(qty);
                } else {
                    System.out.println(-1);
                }
                break;
            case "DCR":
                if (cart.decrementItemQty(itemName, qty)) {
                    System.out.println(qty);
                } else {
                    System.out.println(-1);
                }
                break;
            case "GET_ORDER_AMOUNT":
                double totalAmount = calculateOrderAmount(cart);
                if (totalAmount != -1) {
                    System.out.println(String.format("%.2f", totalAmount));
                } else {
                    System.out.println(-1);
                }
                break;
        }
    }

    private static double calculateOrderAmount(Inventory cart) {
        double totalAmount = 0.0;
        for (String itemName : cart.items.keySet()) {
            Item cartItem = cart.items.get(itemName);
            if (cartItem.qty > 0) {
                totalAmount += cartItem.cost * cartItem.qty;
            }
        }
        return totalAmount;
    }
}
