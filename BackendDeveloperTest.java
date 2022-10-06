import java.util.List;

public class BackendDeveloperTest {

    protected static BookMapperBackend book_backend = new BookMapperBackend();

     public static void main(String[] args)
    {
        System.out.println(runAllTests());
    }

    public static boolean test1()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "1234567" );
        book_backend.addBook(book);

        if(book_backend.getNumberOfBooks() > 0) {
            System.out.println("test1");
            return true;
        }

        System.out.println("addBook has not added the book.");
        return false;
    }




    public static boolean test2 ()
    {
        Book book = new Book("Frankenstein", "Mary Shelley", "54321");

        book_backend.addBook(book);
        List<IBook> book2 = book_backend.searchByTitleWord("Frank");

        if (book2.get(0).getTitle().equals("Frankenstein")) {
            System.out.println("test2");
            return true;
        }

        System.out.println("The searchByTitleWord did not work");
        return false;  // || book2.getTitle().contains(getAuthorFilter()) ( add this to search by title word later)
    }


    public static boolean test3()
    {
        book_backend.setAuthorFilter("Mary Shelley");
        if(book_backend.getAuthorFilter().equals("Mary Shelley")) {
            System.out.println("test3");
            return true; // this shows that Mary Shelley was set. so author filter works.
        }

        System.out.println("Author filter not set");
        return false;
    }


    public static boolean test4 ()
    {
        book_backend.resetAuthorFilter();
        if(book_backend.getAuthorFilter().equals("")) {
            System.out.println("test4");
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
            System.out.println("test5");
            return true;
        }
        System.out.println("The ISBN was not recovered");
        return false;
    }







    public static boolean runAllTests() {
        return  test1() && test2() && test3() && test4() && test5(); // called in main to test everything.
    }
}
