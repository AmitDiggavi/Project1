// --== CS400 Project One File Header ==--
// Name: Amit Diggavi
// CSL Username: diggavi
// Email: diggavi@wisc.edu
// Lecture #:  003 @2:25pm
// Notes to Grader: Made a new class which has key value pairs as based on a response from piazza. Override used since
//                  prof talked about overriding in lecture



import java.util.NoSuchElementException;
import java.util.LinkedList;

public class HashtableMap<KeyType,ValueType> implements MapADT<KeyType,ValueType>{
    private int capacity = 0;
    private KeyType key;
    private int size_array;
    protected LinkedList<Pairs<KeyType, ValueType>>[] hashArray;

    @SuppressWarnings("unchecked")
    public HashtableMap(int capacity)
    {
        size_array = 0;
        this.capacity = capacity;
        hashArray = (LinkedList<Pairs<KeyType,ValueType>>[]) new LinkedList[capacity];


    }
    @SuppressWarnings("unchecked")
    public HashtableMap()
    {
        this.capacity = 15;
        size_array = 0;
        hashArray = (LinkedList<Pairs<KeyType,ValueType>>[]) new LinkedList[capacity];


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

    public boolean put(KeyType key, ValueType value)
    {
        int new_add = 0;
        if(key != null) {
            new_add = Math.abs(key.hashCode()) % capacity; // adding a new value into the hashtable at a new index.
        }


        LinkedList<Pairs<KeyType, ValueType>> hashArray2 = hashArray[new_add];
        if(hashArray2 != null) // if it contains a value already it shows false
        {
            for(int i = 0; i < hashArray2.size(); i++)
            {
                if(hashArray2.get(i).key.equals(key))
                {
                    return false;
                }
            }
        }



        double load = (double) size_array / capacity;
        if (load >= .70)
        {
            rehash();
        }
        if (hashArray[new_add] != null) {
            hashArray[new_add].add(new Pairs<>(key, value));
            size_array++;
            return true;
        }


        return false;
    }


    /**
     * Returns the value mapped to a key if the map contains such a mapping.
     *
     * @param key the key for which to look up the value
     * @return the value mapped to the key
     * @throws NoSuchElementException if the map does not contain a mapping
     *                                for the key
     */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException
    {
        int existing = Math.abs(key.hashCode()) % capacity;
        LinkedList<Pairs<KeyType, ValueType>> array = hashArray[existing];

        if (array == null) {
            throw new NoSuchElementException(key + "does not exist"); // if the whole array is null then the key does not exist.
        }


        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getKey().equals(key)) {
                return array.get(i).getVal(); // the value it gets is returned and then if the if statement fails, it later throws expection.
            }
        }

        throw new NoSuchElementException(key + "does not exist");


    }
    @SuppressWarnings("unchecked")
    public void rehash()
    {
        LinkedList<Pairs<KeyType, ValueType>>[] array2;
        array2 = new LinkedList[capacity * 2];

        for(int i = 0; i < hashArray.length; i++)
        {
            LinkedList<Pairs<KeyType, ValueType>> kvp = hashArray[i];
            int index = Math.abs(this.key.hashCode()) % (capacity * 2);
            if(array2[index] == null)
            {
                array2[index] = new LinkedList<>(); // if the array2 is null then we can assign the index of each for a linked list
            }
            array2[index].add(new Pairs<KeyType, ValueType>(kvp.get(i).getKey(), kvp.get(i).getVal())); // now we can fill in the array2
        }

        hashArray = array2;
    }


    /**
     * Checks if a key is stored in the map.
     *
     * @param key the key to check for
     * @return true if the key is stored (mapped to a value) by the map
     *         and false otherwise
     */
    public boolean containsKey(KeyType key)
    {
        if(key == null) return false;


        int existing = Math.abs(this.key.hashCode()) % capacity;

        if (hashArray[existing] != null)
        {
            for(int i = 0; i < hashArray[existing].size(); i++)
            {
                if(hashArray[existing].get(i).getKey().equals(key))
                {
                    return true;
                }
            }
        }

        return false;
    }




    /**
     * Returns the number of (key, value) pairs stored in the map.
     *
     * @return the number of (key, value) pairs stored in the map
     */
    public int size()
    {
        return size_array;
    }

    /**
     * Removes a key and its value from the map.
     *
     * @param key the key for the (key, value) pair to remove
     * @return the value for the (key, value) pair that was removed,
     *         or null if the map did not contain a mapping for key
     */
    public ValueType remove(KeyType key)
    {
        if (key == null) {
            return null;
        }

        int index = Math.abs(key.hashCode() % capacity);

        if (hashArray[index] == null || hashArray[index].isEmpty()) {
            return null;
        }

        ValueType val = null;

        for (int i = 0; i < hashArray[index].size(); i++) {
            if (hashArray[index].get(i).getKey().equals(key)) {
                val = hashArray[index].get(i).getVal();
                hashArray[index].remove(i);
                size_array--;
                break;
            }
        }

        return val;
    }

    public void clear()
    {
        for(LinkedList arr1 : hashArray)
        {
            if(arr1 == null || arr1.isEmpty()) {
                continue;
            }
            arr1.clear();
        }
        size_array = 0;


    }

}
