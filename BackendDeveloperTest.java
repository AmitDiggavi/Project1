import java.util.List;

public class BackendDeveloperTest {

    protected static BookMapperBackend book_backend = new BookMapperBackend();

     public static void main(String[] args)
    {
        System.out.println(runTest1());
        System.out.println(runTest2());
        System.out.println(runTest3());
        System.out.println(runTest4());
        System.out.println(runTest5());
    }

    public static boolean test1()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "1234567" );
        book_backend.addBook(book);

        if(book_backend.getNumberOfBooks() > 0) {
            // System.out.println("true"); // check to see if add book is working. if it is the size will become greater than 0 cause you added it.
            return true;
        }

        System.out.println("addBook has not added the book.");
        return false;
    }




    public static boolean test2 ()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "54321");

        book_backend.addBook(book);
        List<IBook> book2 = book_backend.searchByTitleWord("Frank"); // the word is Frank

        if (book2.get(0).getTitle().equals("Frankenstein")) {
            // System.out.println("true");  // if it equals Frankenstein then the searchbyTitleWord is working
            return true;
        }

        System.out.println("The searchByTitleWord did not work");
        return false;
    }


    public static boolean test3()
    {
        book_backend.setAuthorFilter("Mary Shelley");
        if(book_backend.getAuthorFilter().equals("Mary Shelley")) {
          // System.out.println("true");
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
          //  System.out.println("true");
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
           // System.out.println("true"); // it will get the ISBN and return true.
            return true;
        }
        System.out.println("The ISBN was not recovered");
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
}
