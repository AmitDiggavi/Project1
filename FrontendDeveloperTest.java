import java.util.Scanner;

public class FrontendDeveloperTest {
    public static void main(String[] args) {
        System.out.println("FrontendDeveloper Individual Test 1: " + (test1() ? "passed" : "failed"));
        System.out.println("FrontendDeveloper Individual Test 2: " + (test2() ? "passed" : "failed"));
        System.out.println("FrontendDeveloper Individual Test 3: " + (test3() ? "passed" : "failed"));
        System.out.println("FrontendDeveloper Individual Test 4: " + (test4() ? "passed" : "failed"));
        System.out.println("FrontendDeveloper Individual Test 5: " + (test5() ? "passed" : "failed"));
        System.out.println("FrontendDeveloper Integration Test 1: " + (test6() ? "passed" : "failed"));
        System.out.println("FrontendDeveloper Integration Test 2: " + (test7() ? "passed" : "failed"));

    }

    /**
     * Tests runCommandLoop and exiting the
     * @return true if welcome, main menu, and goodbye is printed, false otherwise
     */
    public static boolean test1() {
        TextUITester tester = new TextUITester("4\n");
        Scanner scn = new Scanner(System.in);
        BookMapperFrontend testFrontend = new BookMapperFrontend(scn, null, null);
        testFrontend.runCommandLoop();
        String output = tester.checkOutput();
        if(!output.startsWith("Welcome to the Book Mapper Application!") ||
            !output.contains("Main Menu") || !output.contains("Goodbye!")) {
            return false;
        }
         return true;
    }

    /**
     * Tests when a user uses isbn lookup
     * @return true if the correct book corresponding to the ISBN is printed, false otherwise
     */
    public static boolean test2() {
        TextUITester tester = new TextUITester("1\n9781812297048\n4\n");
        Scanner scn = new Scanner(System.in);
        IBookMapperBackend backend = new BookMapperBackend();
        IISBNValidator validator = new ISBNValidator();
        BookMapperFrontend testFrontend = new BookMapperFrontend(scn, backend, validator);
        Book hitchhiker = new Book("Hitchhiker", "Douglas Adams", "9781812297048");
        backend.addBook(hitchhiker);
        testFrontend.runCommandLoop();
        String output = tester.checkOutput();
        if(!output.startsWith("Welcome to the Book Mapper Application!") ||
            !output.contains("Hitchhiker") || !output.contains("Adams")) {
            return false;
        }
        return true;
    }

    /**
     * Tests author filter
     * @return true if getAuthorFilter is set to the author inputted false otherwise
     */
    public static boolean test3() {
        TextUITester tester = new TextUITester("3\nJames Joyce\n4\n");
        Scanner scn = new Scanner(System.in);
        IBookMapperBackend backend = new BookMapperBackend();
        IISBNValidator validator = new ISBNValidator();
        BookMapperFrontend testFrontend = new BookMapperFrontend(scn, backend, validator);
        Book steam = new Book("steam", "James Joyce", "1231231231234");
        backend.addBook(steam);
        testFrontend.runCommandLoop();
        String output = tester.checkOutput();
        if(!output.startsWith("Welcome to the Book Mapper Application!") ||
            !backend.getAuthorFilter().equals("James Joyce") ) {
            return false;
        }
        return true;
    }

    /**
     * tests searching by a title word
     * @return true if a list of books is printed including that word, false otherwise
     */
    public static boolean test4() {
        TextUITester tester = new TextUITester("2\nsteam\n4\n");
        Scanner scn = new Scanner(System.in);
        IBookMapperBackend backend = new BookMapperBackend();
        IISBNValidator validator = new ISBNValidator();
        BookMapperFrontend testFrontend = new BookMapperFrontend(scn, backend, validator);
        Book steam = new Book("steam", "Moy", "1231231231234");
        backend.addBook(steam);
        testFrontend.runCommandLoop();
        String output = tester.checkOutput();
        if(!output.startsWith("Welcome to the Book Mapper Application!") ||
            !output.contains("steam")) {
            return false;
        }
        return true;
    }

    /**
     * tests if searching by an author and a title word works
     * @return true if successful, false otherwise
     */
    public static boolean test5() {
        TextUITester tester = new TextUITester("3\nDouglas Adams\n2\nHitchhiker\n4\n");
        Scanner scn = new Scanner(System.in);
        IBookMapperBackend backend = new BookMapperBackend();
        IISBNValidator validator = new ISBNValidator();
        BookMapperFrontend testFrontend = new BookMapperFrontend(scn, backend, validator);
        Book hitchhiker = new Book("Hitchhiker", "Douglas Adams", "1231231231235");
        backend.addBook(hitchhiker);
        testFrontend.runCommandLoop();
        String output = tester.checkOutput();
        if(!output.startsWith("Welcome to the Book Mapper Application!") ||
            !output.contains("Hitchhiker") || !output.contains("Adams")) {
            return false;
        }
        return true;
    }

    /**
     * tests if searching by an author and no title word works
     * @return true if successful, false otherwise
     */
    public static boolean test6() {
        TextUITester tester = new TextUITester("3\nDouglas Adams\n2\n\n4\n");
        Scanner scn = new Scanner(System.in);
        IBookMapperBackend backend = new BookMapperBackend();
        IISBNValidator validator = new ISBNValidator();
        BookMapperFrontend testFrontend = new BookMapperFrontend(scn, backend, validator);
        Book hitchhiker = new Book("Hitchhiker", "Douglas Adams", "1231231231235");
        backend.addBook(hitchhiker);
        testFrontend.runCommandLoop();
        String output = tester.checkOutput();
        if(!output.startsWith("Welcome to the Book Mapper Application!") ||
            !output.contains("Hitchhiker") || !output.contains("Adams")) {
            return false;
        }
        return true;
    }

    /**
     * tests if searching by a word that does not match a title displays "no matches"
     * @return true if successful, false otherwise
     */
    public static boolean test7() {
        TextUITester tester = new TextUITester("2\naskjdfh\n4\n");
        Scanner scn = new Scanner(System.in);
        IBookMapperBackend backend = new BookMapperBackend();
        IISBNValidator validator = new ISBNValidator();
        BookMapperFrontend testFrontend = new BookMapperFrontend(scn, backend, validator);
        Book hitchhiker = new Book("Hitchhiker", "Douglas Adams", "1231231231235");
        backend.addBook(hitchhiker);
        testFrontend.runCommandLoop();
        String output = tester.checkOutput();
        if(!output.startsWith("Welcome to the Book Mapper Application!") ||
            output.contains("askjdfh") || !output.contains("No Matches")) {
            return false;
        }
        return true;
    }

}
