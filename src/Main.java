public class Main {
    public static void main(String[] args) {
        String phrase = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        HashTable hashTable = new HashTable(10);

        String[] words = phrase.split(" ");
        for (String word : words) {
            hashTable.put(word);
        }

        System.out.println("Before removing 'avoidable':");
        hashTable.printHashTable();

        boolean removed = hashTable.remove("avoidable");
        if (removed) {
            System.out.println("\nWord 'avoidable' removed successfully.");
        } else {
            System.out.println("\nWord 'avoidable' not found.");
        }

        System.out.println("\nAfter removing 'avoidable':");
        hashTable.printHashTable();
    }
}