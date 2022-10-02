// --== CS400 Project One File Header ==--
// Name: Alex Dubov
// CSL Username: dubov
// Email: dubov@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: :-)


/**
 * Key-Value pair holding class
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class Node<KeyType, ValueType> {
    private final KeyType key;
    private final ValueType value;

    /**
     * Creates key-value pair node
     * @param key the key
     * @param value the value
     */
    public Node(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key
     * @return the key
     */
    public KeyType getKey() {
        return key;
    }

    /**
     * Returns the value
     * @return the value
     */
    public ValueType getValue() {
        return value;
    }
}
