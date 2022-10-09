import java.util.NoSuchElementException;

public class HashtableMapTests  {

    public static void main(String[] args)
    {
        System.out.println(runAllTests());
    }


    public static boolean test1() {
        try {
            HashtableMap<String, String> map = new HashtableMap<>(5);
            String key1;
            String value1;

            // check with null key
            key1 = null;
            value1 = null;

            if (map.put(key1, value1)) {
                System.out.println("put() should return false when adding a null key.");
                System.out.println(map.put(key1, value1));
                return false;
            }

            HashtableMap<String, Integer> map2 = new HashtableMap<>(5);
            String key2 = "abc";
            Integer value2 = 1;
            boolean b = map2.put(key2, value2);
// check put() on empty array location
            if (!b) {
                System.out.println(key2 + " should be added to an empty array location on " +
                        "the hashtable array; the put() method should return true.");
                System.out.println();
                return false;
            }
// check key already stored
            boolean c = map2.put(key2, value2);
            if (c) {
                System.out.println("put() should return false when adding an already " +
                        "existing key.");
                System.out.println("result: " + b);
                return false;
            }
// check put() on empty linked list in array location, do after testing remove()
            HashtableMap<String, Integer> map3 = new HashtableMap<>(5);
            String key3 = "aaa";
            Integer value3 = 1;
            map3.put(key3, value3);
            map3.remove(key3);

            boolean d = map3.put(key3, value3);
            if (!d) {
                System.out.println("put() should return true when adding a key into an empty" +
                        " linked list (at the hashed index)");
                return false;
            }
// check put() on linked list with a hash collision
            HashtableMap<String, Integer> map4 = new HashtableMap<>(5);
            String key4 = "abc";
            Integer value4 = 1;
            String key5 = "bca";
            Integer value5 = 2;
            map4.put(key4, value4);

            if (!map4.put(key5, value5)) {
                System.out.println("put() should return true when adding with a hash " +
                        "collision.");
                return false;
            }

            if (map4.hashArray[4].size() != 2) {
                System.out.println("put() is not adding key-value pairs correctly in the " +
                        "event of a hash collision.");
                return false;
            }
            // check put() with load factor growth and rehash function
            HashtableMap<String, Integer> map5 = new HashtableMap<>(8);
            String key6 = "abc";
            Integer value6 = 1;
            String key7 = "2345543";
            Integer value7 = 2;
            String key8 = "cba";
            Integer value8 = 3;
            String key9 = "c5436n43ws";
            Integer value9 = 4;
            String key10 = "c5433ws";
            Integer value10 = 5;
            String key11 = "c54aedrg3ws";
            Integer value11 = 6;
            String key12 = "c543gae4fdzg";
            Integer value12 = 7;
            String key13 = "dgrzdgdfs";
            Integer value13 = 8;

            map5.put(key6, value6);
            map5.put(key7, value7);
            map5.put(key8, value8);
            map5.put(key9, value9);
            map5.put(key10, value10);
            int arrayCapBefore = map5.hashArray.length;
            int arraySizeBefore = map5.size();

            map5.put(key11, value11);
            int arrayCapAfter = map5.hashArray.length;
            int arraySizeAfter = map5.size();

            if (arrayCapBefore * 2 != arrayCapAfter) {
                System.out.println("rehash() is not changing array size properly in the case" +
                        " of a >=75% load factor.");
                return false;
            }

            if (arraySizeBefore + 1 != arraySizeAfter) {
                System.out.println("rehash() should not change the size variable - how many" +
                        " total key-value pairs are in the hashtable.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("This is not an expected exception.");
            e.printStackTrace();
            return false;
        }

        return true;
        }



    public static boolean test2() {
        try {
            // if key is null, should should throw NoSuchElementException
            HashtableMap<String, Integer> map = new HashtableMap<>(5);

            try {
                map.get(null);
                System.out.println("get() with an input of null should throw a " +
                        "NoSuchElementException.");
                return false;
            } catch (NoSuchElementException e) {
                // expected
            }

            // if hashed index is null, should throw NoSuchElementException (means nothing
            // hashed there so key can't exist there)
            HashtableMap<String, Integer> map2 = new HashtableMap<>(5);
            String key1 = "abc";

            try {
                map2.get(key1);
                System.out.println("get() with a key that doesn't exist in the hashtable " +
                        "(also no linked list at the hashed index) should throw a " +
                        "NoSuchElementException.");
                return false;
            } catch (NoSuchElementException e) {
                // expected
            }

            // if key is found, it should return corresponding value
            HashtableMap<String, Integer> map3 = new HashtableMap<>(5);
            String key2 = "abc";
            Integer value2 = 1;
            map3.put(key2, value2);

            if (!map3.get(key2).equals(value2)) {
                System.out.println("get() with key: " + key2 + ", and value: " + value2 + "," +
                        " (it's in the hashtable map) should return: " + value2);
                return false;
            }

            // if key is not found after searching through linked lists, throw
            // NoSuchElementException
            HashtableMap<String, Integer> map4 = new HashtableMap<>(5);
            String key3 = "bca";
            Integer value3 = 2;
            String key4 = "cba";
            Integer value4 = 3;
            map4.put(key2, value2);
            map4.put(key3, value3);

            try {
                map4.get(key4);
                System.out.println("get() with a key not in the hashtable (in the presence " +
                        "of empty or populated linked lists) should throw a " +
                        "NoSuchElementException.");
                return false;
            } catch (NoSuchElementException e) {
                // expected
            }

        } catch (Exception e) {
            System.out.println("This is not an expected exception.");
            e.printStackTrace();
            return false;
        }

        return true;
    }



    public static boolean test3() {
        try {
            // check size() one empty array
            HashtableMap<String, Integer> map = new HashtableMap<>(5);
            if (map.size() != 0) {
                System.out.println("size() on empty hashtable should return 0, it is " +
                        "currently returning " + map.size());
                return false;
            }

            // check size() with populated hashtable
            HashtableMap<String, Integer> map2 = new HashtableMap<>(5);
            String key1 = "abc";
            Integer value1 = 1;
            String key2 = "bca";
            Integer value2 = 2;
            String key3 = "23452";
            Integer value3 = 3;

            map2.put(key1, value1);
            map2.put(key2, value2);
            map2.put(key3, value3);

            int size = map2.size();

            if (size != 3) {
                System.out.println("size() is not properly counting the number of keys in " +
                        "the hashtable. The correct value is 3, currently it is returning: "
                        + size);
                return false;
            }

        } catch (Exception e) {
            System.out.println("This is not an expected exception.");
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public static boolean test4() {
        try {

            // check if key exists
            HashtableMap<String, Integer> map = new HashtableMap<>(5);
            String key1 = "abc";
            Integer value1 = 1;
            map.put(key1, value1);

            if (!map.containsKey(key1)) {
                System.out.println("containsKey() not recognizing that the key: " + key1 +
                        " is in the hashtable.");
                return false;
            }

            // check if key doesn't exist
            String key2 = "bca";

            if (map.containsKey(key2)) {
                System.out.println("containsKey() not recognizing that the key: " + key2 +
                        " is not in the hashtable.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("This is not expected exception.");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean test5() { try {

        // if key is null, return null
        HashtableMap<String, Integer> map = new HashtableMap<>(5);
        if (map.remove(null) != null) {
            System.out.println("remove() with a null key should return null.");
            return false;
        }

        // if hashed index is null - meaning that there is no linked list there, also
        // means that nothing was ever there, return null
        String key1 = "abc";
        Integer value1 = 1;
        if (map.remove(key1) != null) {
            System.out.println("remove() with a key that doesn't exist in the hash table" +
                    " (also when there is no linked list in the hashed index) should " +
                    "return null.");
            return false;
        }

        // removing a key should remove the key-value pair from the linked list, and
        // return the corresponding value
        map.put(key1, value1);
        if(!map.remove(key1).equals(value1)) {
            System.out.println("remove() not correctly removing the key-value pair from " +
                    "the hashtable.");
            return false;
        }

        if (map.size() != 0) {
            System.out.println("size() is not being changed correctly by remove() or " +
                    "remove() is not removing the key-value pair from the hashtable.");
            return false;
        }

    } catch (Exception e) {
        System.out.println("This is not an expected exception.");
        e.printStackTrace();
        return false;
    }

        return true;
    }

    public static boolean test6() {
        try {
            HashtableMap<String, Integer> map = new HashtableMap<>(5);
            String key1 = "abc";
            Integer value1 = 1;
            String key2 = "bca";
            Integer value2 = 2;
            String key3 = "245635sgdf";
            Integer value3 = 3;

            map.put(key1, value1);
            map.put(key2, value2);
            map.put(key3, value3);

            map.clear();

            if (map.hashArray[2].size() != 0 || map.hashArray[4].size() != 0) {
                System.out.println("clear() is not correctly clearing the lists in the " +
                        "hashtable.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("This is not an expected exception.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Runs all tests
     *
     * @return true if and only if all tested methods function as intended, false otherwise
     */
    public static boolean runAllTests() {
        return test1() && test2() && test3() && test4() && test5() && test6();
    }
}
