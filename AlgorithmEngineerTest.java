import java.util.NoSuchElementException;

public class AlgorithmEngineerTest {
    public static void main(String[] args) {
        System.out.println("AlgorithmEngineer Individual Test 1: " + (test1() ? "passed" : "failed"));
        System.out.println("AlgorithmEngineer Individual Test 2: " + (test2() ? "passed" : "failed"));
        System.out.println("AlgorithmEngineer Individual Test 3: " + (test3() ? "passed" : "failed"));
        System.out.println("AlgorithmEngineer Individual Test 4: " + (test4() ? "passed" : "failed"));
        System.out.println("AlgorithmEngineer Individual Test 5: " + (test5() ? "passed" : "failed"));
        System.out.println("AlgorithmEngineer Integration Test 1: " + (test6() ? "passed" : "failed"));
        System.out.println("AlgorithmEngineer Integration Test 2: " + (test7() ? "passed" : "failed"));
    }

    /**
     * tests basic map functionality
     */
    public static boolean test1() {
        try {
            IterableMap<String, String> stringStringMap = new IterableMap<>();
            if (!stringStringMap.put("alex", "goat")) return false;
            if (!stringStringMap.get("alex").equals("goat")) return false;

            IterableMap<Integer, Integer> integerIntegerMap = new IterableMap<>();
            if (!integerIntegerMap.put(42, 1)) return false;
            if (!integerIntegerMap.get(42).equals(1)) return false;

            IterableMap<Double, String> doubleStringMap = new IterableMap<>();
            if (!doubleStringMap.put(Math.PI, "apple")) return false;
            if (!doubleStringMap.get(Math.PI).equals("apple")) return false;

            IterableMap<String, String> map = new IterableMap<>();
            map.put("a", "b");
            map.put("c", "d");
            if (!map.remove("a").equals("b")) return false;
            if (map.remove("f") != null) return false;
            if (map.containsKey("a")) return false;
        } catch (NoSuchElementException e) {
            if (!e.getMessage().equals("Map does not contain key"))
                return false;
        } catch (Exception ignored) {
            return false;
        }

        return true;
    }

    /**
     * tests ISBN validator
     */
    public static boolean test2() {
        ISBNValidator iv = new ISBNValidator();
        // good ones
        if (!iv.validate("9780330491198")) return false;
        if (!iv.validate("978-0-306-40615-7")) return false;

        // bad boys
        if (iv.validate("978-0-306-40615-5")) return false;
        if (iv.validate("978-0-306-4061-7")) return false;
        if (iv.validate("978-0-306-40615-76")) return false;
        return !iv.validate("good isbn trust me");
    }

    /**
     * tests containsKey
     */
    public static boolean test3() {
        try {
            IterableMap<String, String> map = new IterableMap<>();
            map.put("a", "b");

            if (!map.containsKey("a")) return false;
        } catch (Exception ignored) {
            return false;
        }

        return true;
    }

    /**
     * tests iterator
     */
    public static boolean test4() {
        try {
            IterableMap<Integer, Integer> im = new IterableMap<>();
            im.put(1, 1);
            im.put(2, 2);
            im.put(3, 3);
            im.put(4, 4);
            for (int i = 1; i < 4; i++) {
                if (im.get(i) != i) return false;
            }

        } catch (Exception ignored) {
            return false;
        }

        return true;
    }

    /**
     * tests capacity increase when load factor >= 0.7
     */
    public static boolean test5() {
        try {
            IterableMap<String, String> map = new IterableMap<>(2);
            map.put("a", "b");
            map.put("c", "d");
            map.put("e", "f");
            if (map.size() != 3) return false;

        } catch (Exception ignored) {
            return false;
        }

        return true;
    }

    /**
     * tests utility methods - size, clear
     */
    public static boolean test6() {
        try {
            IterableMap<String, String> map = new IterableMap<>();
            // size 0
            if (map.size() != 0) return false;

            // size 2
            map.put("a", "b");
            map.put("c", "d");
            if (map.size() != 2) return false;

            // cleared
            map.clear();
            if (map.size() != 0) return false;

        } catch (Exception ignored) {
            return false;
        }

        return true;
    }

    /**
     * tests remove with existent and non-existent keys
     */
    public static boolean test7() {
        try {
            IterableMap<String, String> map = new IterableMap<>();

            // duplicate key
            map.put("alex", "goat");
            if (map.put("alex", "not the goat")) return false;

            map.get("non-existent");
            return false;
        } catch (NoSuchElementException e) {
            if (!e.getMessage().equals("Map does not contain key"))
                return false;
        } catch (Exception ignored) {
            return false;
        }

        return true;
    }
}
