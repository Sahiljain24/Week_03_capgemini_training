class Item {
    
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    // Add item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    // Add item at a specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 1) {
            newItem.next = head;
            head = newItem;
            return;
        }
        Item current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newItem.next = current.next;
        current.next = newItem;
    }

    // Remove an item by Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item current = head, prev = null;
        while (current != null && current.itemId != itemId) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Item with ID " + itemId + " not found.");
            return;
        }
        prev.next = current.next;
    }

    // Update the quantity of an item by Item ID
    public void updateItemQuantity(int itemId, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(int itemId, String itemName) {
        Item current = head;
        boolean found = false;
        while (current != null) {
            if (current.itemId == itemId || current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: ID: " + current.itemId + ", Name: " + current.itemName +
                        ", Quantity: " + current.quantity + ", Price: " + current.price);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalValue() {
        Item current = head;
        double totalValue = 0;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Display all items
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item current = head;
        while (current != null) {
            System.out.println("ID: " + current.itemId + ", Name: " + current.itemName +
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    // Sort the inventory by Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, criteria, ascending);
    }

    private Item mergeSort(Item head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, criteria, ascending);
        Item right = mergeSort(nextToMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private Item sortedMerge(Item a, Item b, String criteria, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        int compare;
        if (criteria.equalsIgnoreCase("name")) {
            compare = a.itemName.compareToIgnoreCase(b.itemName);
        } else {
            compare = Double.compare(a.price, b.price);
        }

        if ((ascending && compare <= 0) || (!ascending && compare > 0)) {
            result = a;
            result.next = sortedMerge(a.next, b, criteria, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, criteria, ascending);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return null;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding items
        inventory.addItemAtEnd("Laptop", 101, 5, 50000);
        inventory.addItemAtEnd("Phone", 102, 10, 20000);
        inventory.addItemAtEnd("Tablet", 103, 7, 15000);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        // Updating quantity
        System.out.println("\nUpdating quantity for Item ID 101:");
        inventory.updateItemQuantity(101, 8);
        inventory.displayInventory();

        // Searching items
        System.out.println("\nSearching for Item by Name 'Phone':");
        inventory.searchItem(-1, "Phone");

        // Calculate total value
        System.out.println("\nCalculating Total Inventory Value:");
        inventory.calculateTotalValue();

        // Sorting inventory by price
        System.out.println("\nSorting Inventory by Price in Ascending Order:");
        inventory.sortInventory("price", true);
        inventory.displayInventory();
    }
}
