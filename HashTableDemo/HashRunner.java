import java.util.ArrayList;

public class HashRunner<Key, Value> implements UnorderedST<Key, Value> {
    private static final int M = 10;

    public static void main(String[] args) {
    	HashRunner<Integer, Integer> ht = new HashRunner<>();
        for (int i = 0; i < 100; i++) {
            ht.put(i, i+1);
        }
        // Delete
        System.out.println(ht.get(4));
        ht.delete(4);
        System.out.println(ht.get(4));

        // Put
        System.out.println(ht.get(57));
        ht.put(57, 1000);
        System.out.println(ht.get(57));

    }

    protected class Node {
        Key key;
        Value val;
        Node next;
    }

    private ArrayList<Node> store;

    private int hash(Key key) {
        return key.toString().hashCode() % M;
    }

    public HashRunner() {
        super();
        store = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            store.add(null);
        }
    }

    // GET
    public Value get(Key key) {
        int hashCodeIndex = hash(key);
        Node head = store.get(hashCodeIndex);
        while (head != null) {
            if (head.key == key) {
                return head.val;
            }
            head = head.next;
        }
        return null;
    }

    // PUT
    public void put(Key key, Value value) {
        int hashCodeIndex = hash(key);
        Node head = store.get(hashCodeIndex);
        Node temp = head;
        while (temp != null) {
            if (key == temp.key) {
                temp.val = value;// override
                return;
            }
            temp = temp.next;
        }
        Node n = new Node();
        n.key = key;
        n.val = value;
        n.next = head;// insert at first
        store.set(hashCodeIndex, n);
    }

    // DELETE
    public void delete(Key key) {
        int hashcodeIndex = hash(key);
        Node cur = store.get(hashcodeIndex);
        if (cur == null)
            return;
        if (cur.key == key) {
            store.set(hashcodeIndex, cur.next);
            return;
        }
        Node pre = cur;
        cur = cur.next;
        while (cur != null) {
            if (cur.key == key) {
                pre.next = cur.next;
                return;
            }
            pre = cur;
            cur = cur.next;
        }
    }

}
//CREDITS TO Eric-programming/