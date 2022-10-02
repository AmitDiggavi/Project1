import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * A HashMap implemented with a linked list that leverages
 * chaining to handle collisions
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class IterableMap<KeyType, ValueType> implements IterableMapADT<KeyType, ValueType> {

    protected LinkedList<Node<KeyType, ValueType>>[] chains;

    public static void main(String[] args) {
        IterableMap<Integer, Integer> im = new IterableMap();
        im.put(1, 1);
        im.put(2, 2);
        im.put(3, 3);
        im.put(4, 4);
        for (Integer i : im) {
            System.out.println(i);
        }
    }

    /**
     * Creates a hash table with specified capacity
     * @param capacity the capacity of the hashtable
     */
    @SuppressWarnings("unchecked")
    public IterableMap(int capacity) {
        this.chains = (LinkedList<Node<KeyType, ValueType>>[]) new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            this.chains[i] = new LinkedList<>();
        }
    }

    /**
     * Creates a hash table with a capacity of 15
     */
    @SuppressWarnings("unchecked")
    public IterableMap()  {
        this.chains = (LinkedList<Node<KeyType, ValueType>>[]) new LinkedList[15];
        for (int i = 0; i < 15; i++) {
            this.chains[i] = new LinkedList<>();
        }
    }

    /**
     * Inserts a new (key, value) pair into the map if the map does not
     * contain a value mapped to key yet.
     *
     * @param key the key of the (key, value) pair to store
     * @param value the value that the key will map to
     * @return true if the (key, value) pair was inserted into the map,
     *         false if a mapping for key already exists and the
     *         new (key, value) pair could not be inserted
     */
    public boolean put(KeyType key, ValueType value) {
        int index = hashIndex(key);
        LinkedList<Node<KeyType, ValueType>> linkedNodeList = chains[index];
        for (Node<KeyType, ValueType> node : linkedNodeList) {
            if (node.getKey().equals(key)) return false;
        }

        linkedNodeList.add(new Node<>(key, value));

        if (loadFactor() >= 0.7) doubleCapacity();

        return true;
    }

    /**
     * Returns the value mapped to a key if the map contains such a mapping.
     *
     * @param key the key for which to look up the value
     * @return the value mapped to the key
     * @throws NoSuchElementException if the map does not contain a mapping
     *                                for the key
     */
    public ValueType get(KeyType key) throws NoSuchElementException {
        int index = hashIndex(key);
        LinkedList<Node<KeyType, ValueType>> linkedNodeList = chains[index];
        for (Node<KeyType, ValueType> node : linkedNodeList) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }

        throw new NoSuchElementException("Map does not contain key");
    }

    /**
     * Removes a key and its value from the map.
     *
     * @param key the key for the (key, value) pair to remove
     * @return the value for the (key, value) pair that was removed,
     *         or null if the map did not contain a mapping for key
     */
    public ValueType remove(KeyType key) {
        int index = hashIndex(key);
        ValueType value = null;
        LinkedList<Node<KeyType, ValueType>> linkedNodeList = chains[index];

        for (Node<KeyType, ValueType> node : linkedNodeList) {
            if (node.getKey().equals(key)) {
                value = node.getValue();
                linkedNodeList.remove(node);
            }
        }

        return value;
    }

    /**
     * Checks if a key is stored in the map.
     *
     * @param key the key to check for
     * @return true if the key is stored (mapped to a value) by the map
     *         and false otherwise
     */
    public boolean containsKey(KeyType key) {
        for (LinkedList<Node<KeyType, ValueType>> linkedNodeList : chains) {
            for (Node<KeyType, ValueType> node : linkedNodeList) {
                if (node.getKey().equals(key)) return true;
            }
        }

        return false;
    }

    /**
     * Returns the number of (key, value) pairs stored in the map.
     *
     * @return the number of (key, value) pairs stored in the map
     */
    public int size() {
        int numNodes = 0;
        for (LinkedList<Node<KeyType, ValueType>> linkedNodeList : chains) {
            for (Node<KeyType, ValueType> ignored : linkedNodeList) {
                numNodes++;
            }
        }

        return numNodes;
    }

    /**
     * Removes all (key, value) pairs from the map.
     */
    public void clear() {
        for (LinkedList<Node<KeyType, ValueType>> linkedNodeList : chains) {
            for (Node<KeyType, ValueType> node : linkedNodeList) {
                linkedNodeList.remove(node);
            }
        }
    }

    /**
     * The hash function - calculates an index to the chains array
     *
     * @param key the key from which to generate the hash code or index
     * @return the hash code, or array index
     */
    private int hashIndex(KeyType key) {
        // store new values in your hash table at the index corresponding
        // to { the absolute value of the key's hashCode() } modulus the
        // HashtableMap's current capacity
        return Math.abs(key.hashCode()) % chains.length;
    }

    /**
     * Utility function to calculate the current load factor
     *
     * @return the current load factor
     */
    private double loadFactor() {
        return (size() * 1.0) / chains.length;
    }

    /**
     * Replaces the chains array with a clone that has double the capacity
     */
    @SuppressWarnings("unchecked")
    private void doubleCapacity() {
        LinkedList<Node<KeyType, ValueType>>[] chainsClone = chains.clone();
        int capacity = chains.length * 2;

        this.chains = (LinkedList<Node<KeyType, ValueType>>[]) new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) this.chains[i] = new LinkedList<>();

        for (LinkedList<Node<KeyType, ValueType>> linkedListClone : chainsClone) {
            for (Node<KeyType, ValueType> node : linkedListClone) {
                put(node.getKey(), node.getValue());
            }
        }
    }

    /**
     * Utility function for printing all key-value pairs in hash along with their hash code
     */
    public void print() {
        for (LinkedList<Node<KeyType, ValueType>> linkedNodeList : chains) {
            for (Node<KeyType, ValueType> node : linkedNodeList) {
                System.out.println("(" + hashIndex(node.getKey()) + ") "
                    + node.getKey() + ": " + node.getValue());
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override public Iterator<ValueType> iterator() {
        ArrayList<ValueType> values = new ArrayList<>();
        for (LinkedList<Node<KeyType, ValueType>> linkedNodeList : chains) {
            for (Node<KeyType, ValueType> node : linkedNodeList) {
                values.add(node.getValue());
            }
        }
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < values.size() && values.get(currentIndex) != null;
            }

            @Override
            public ValueType next() {
                return values.get(currentIndex++);
            }
        };
    }
}
