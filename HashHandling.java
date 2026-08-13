import java.util.HashMap;

public class HashHandling {
    public static void main(String[] args) {

        HashMap<Integer, String> hashTable = new HashMap<>();

        // Insert
        hashTable.put(1, "Apple");
        hashTable.put(2, "Banana");
        hashTable.put(3, "Mango");

        // Display
        System.out.println("Hash Table: " + hashTable);

        // Search
        if (hashTable.containsKey(2)) {
            System.out.println("Key 2 found: " + hashTable.get(2));
        }

        // Update
        hashTable.put(2, "Orange");

        // Delete
        hashTable.remove(3);

        // Display after operations
        System.out.println("After operations: " + hashTable);
    }
}