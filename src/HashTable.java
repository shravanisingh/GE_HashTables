public class HashTable {
    private MyMapNode[] buckets;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new MyMapNode[capacity];
    }

    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(String key) {
        int index = getBucketIndex(key);
        MyMapNode head = buckets[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value++;
                return;
            }
            head = head.next;
        }
        MyMapNode newNode = new MyMapNode(key, 1);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(String key) {
        int index = getBucketIndex(key);
        MyMapNode head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return 0;
    }
    public boolean remove(String key) {
        int index = getBucketIndex(key);
        MyMapNode head = buckets[index];
        MyMapNode previous = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (previous == null) {
                    buckets[index] = head.next;
                } else {
                    previous.next = head.next;
                }
                return true;
            }
            previous = head;
            head = head.next;
        }
        return false;
    }

    public void printHashTable() {
        for (int i = 0; i < capacity; i++) {
            MyMapNode head = buckets[i];
            while (head != null) {
                System.out.println(head.key + " -> " + head.value);
                head = head.next;
            }
        }
    }
}