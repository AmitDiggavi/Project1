import java.util.List;

public class BackendDeveloperTest {

    protected static BookMapperBackend book_backend = new BookMapperBackend();

     public static void main(String[] args)
    {
        System.out.println("BackendDeveloper Individual Test 1: " + (test1() ? "passed" : "failed"));
        System.out.println("BackendDeveloper Individual Test 2: " + (test2() ? "passed" : "failed"));
        System.out.println("BackendDeveloper Individual Test 3: " + (test3() ? "passed" : "failed"));
        System.out.println("BackendDeveloper Individual Test 4: " + (test4() ? "passed" : "failed"));
        System.out.println("BackendDeveloper Individual Test 5: " + (test5() ? "passed" : "failed"));
        System.out.println("BackendDeveloper Integration  Test 6: " + (test6() ? "passed" : "failed"));
        System.out.println("BackendDeveloper Integration  Test 7: " + (test7() ? "passed" : "failed"));

    }

    public static boolean test1()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "1234567" );
        book_backend.addBook(book);

        if(book_backend.getNumberOfBooks() > 0) {
             // check to see if add book is working. if it is the size will become greater than 0 cause you added it.
            return true;
        }

        System.out.println("addBook has not added the book.");
        return false;
    }




    public static boolean test2 ()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "54321");

        book_backend.addBook(book);
        List<IBook> book2 = book_backend.searchByTitleWord("Frankenstein"); // the word is Frank


        if (book2.get(0).getTitle().equals("Frankenstein")) {
              // if it equals Frankenstein then the searchbyTitleWord is working
            return true;
        }

        System.out.println("The searchByTitleWord did not work");
        return false;
    }


    public static boolean test3()
    {
        book_backend.setAuthorFilter("Mary Shelley");
        if(book_backend.getAuthorFilter().equals("Mary Shelley")) {

            return true; // this shows that Mary Shelley was set. so author filter works.
        }

        System.out.println("Author filter not set");
        return false;
    }


    public static boolean test4 ()
    {
        book_backend.resetAuthorFilter(); // call the method
        if(book_backend.getAuthorFilter().equals("")) // if the getAuthorFilter is empty then it will return true since it reset the filter.
        {

            return true;
        }

        System.out.println("Reset author filter is not working");
        return false;
    }


    public static boolean test5 ()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "54321");
        book_backend.addBook(book);

        if(book.getISBN13().equals("54321"))
        {
            // it will get the ISBN and return true.
            return true;
        }
        System.out.println("The ISBN was not recovered");
        return false;
    }

    public static boolean test6()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "54321");

        book_backend.addBook(book);
        List<IBook> book2 = book_backend.searchByTitleWord(""); // the word is nothing

        if (book2.get(0) != null) {
              // it should return all the books
            return true;
        }

        System.out.println("The searchByTitleWord with no word did not work");
        return false;
    }

    public static boolean test7()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "54321");

        book_backend.addBook(book);
        book_backend.setAuthorFilter("Mary Shelley");
        List<IBook> book2 = book_backend.searchByTitleWord("");// there is now an author filter

        if(book2.get(0).getAuthors().equals("Mary Shelley"))
        {
            // author filter checker
            return true;
        }
        System.out.println("test7");
        return false;


    }







    public static boolean runTest1() {
        return  test1(); // called in main.
    }
    public static boolean runTest2() {
        return  test2(); // called in main.
    }
    public static boolean runTest3() {
        return  test3(); // called in main.
    }
    public static boolean runTest4() {
        return  test4(); // called in main.
    }
    public static boolean runTest5() {
        return  test5(); // called in main.
    }
    public static boolean runTest6() {
        return  test6(); // called in main.
    }
    public static boolean runTest7() {
        return  test7(); // called in main.
    }

}
