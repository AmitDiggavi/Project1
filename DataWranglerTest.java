import java.io.FileNotFoundException;
import java.util.List;

public class DataWranglerTest {
        public static void main(String[] args) {
                System.out.println("DataWrangler Individual Test 1: " + (test1() ? "passed" : "failed"));
                System.out.println("DataWrangler Individual Test 2: " + (test2() ? "passed" : "failed"));
                System.out.println("DataWrangler Individual Test 3: " + (test3() ? "passed" : "failed"));
                System.out.println("DataWrangler Individual Test 4: " + (test4() ? "passed" : "failed"));
                System.out.println("DataWrangler Individual Test 5: " + (test5() ? "passed" : "failed"));
                System.out.println("DataWrangler Integration Test 1: " + (test6() ? "passed" : "failed"));
                System.out.println("DataWrangler Integration Test 2: " + (test7() ? "passed" : "failed"));
                System.out.println("DataWrangler Partner (AlgorithmEngineer) Test 1: " + (test8() ? "passed" : "failed"));
                System.out.println("DataWrangler Partner (AlgorithmEngineer) Test 2: " + (test9() ? "passed" : "failed"));
        }

        // this method is to check if the path is null
        public static boolean test1() {

                BookLoader obj = new BookLoader();

                String path = null;

                try {
                        obj.loadBooks(path);
                }

                catch (Exception e) {
                        return true;
                }

                return false;
        }

        // prints all the books present in the csv file
        public static boolean test2() {

                BookLoader obj = new BookLoader();

                List<IBook> books;

                try {
                        books = obj.loadBooks("books.csv");
                        for (IBook b : books) {

                                return true;

                        }

                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return true;
        }

        // this method returns the count of books present in the csv file
        public static boolean test3() {
                BookLoader obj = new BookLoader();

                List<IBook> books;

                try {
                        books = obj.loadBooks("books.csv");

                        int bookCount = books.size();

                        if (bookCount != 0) {
                                return true;
                        }
                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return true;
        }

        // method returns details of a book through isbn
        public static boolean test4() {
                String isbn = "9780976540601";

                BookLoader obj = new BookLoader();

                List<IBook> books;

                try {
                        books = obj.loadBooks("books.csv");

                        for (IBook b : books) {
                                if (b.getISBN13().equals(isbn)) {
                                        return true;
                                }
                        }

                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return false;
        }

        // method returns details of a book through authors
        public static boolean test5() {
                String author = "Rowling";

                BookLoader obj = new BookLoader();

                List<IBook> books;

                try {
                        books = obj.loadBooks("books.csv");

                        for (IBook b : books) {
                                if (b.getAuthors().contains(author)) {
                                        return true;
                                }

                        }
                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return false;
        }

        // method sets a author filter
        public static boolean test6() {
                String author = "Douglas Adams";

                BookLoader obj = new BookLoader();

                BookMapperBackend bmb = new BookMapperBackend();

                bmb.setAuthorFilter(author);

                List<IBook> books;

                try {
                        books = obj.loadBooks("books.csv");

                        for (IBook b : books) {
                                bmb.addBook(b);
                        }

                        for (IBook b : bmb.searchByTitleWord("")) {
                                if (!b.getAuthors().equals(author)) {
                                        return false;
                                }
                        }
                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return true;
        }

        // method validates entered for isbn
        public static boolean test7() {
                BookLoader obj = new BookLoader();

                ISBNValidator val = new ISBNValidator();

                try {
                        List<IBook> books = obj.loadBooks("books.csv");

                        for (IBook b : books) {
                                if (val.validate(b.getISBN13())) {
                                        return true;
                                }

                        }

                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return false;
        }

        // method tests if backend has correct number of books after book load
        public static boolean test8() {
                BookLoader obj = new BookLoader();
                BookMapperBackend bmb = new BookMapperBackend();

                try {
                        int numBooks = 0;
                        for (IBook b : obj.loadBooks("books.csv")) {
                                bmb.addBook(b);
                                numBooks++;
                        }

                        return bmb.getNumberOfBooks() == numBooks;
                } catch (FileNotFoundException e) {
                        return false;
                }
        }

        // method tests if backend can search by title after book load
        public static boolean test9() {
                String title = "The Hitchhiker's Guide to the Galaxy (Hitchhiker's Guide to the Galaxy  #1)";
                BookLoader obj = new BookLoader();
                BookMapperBackend bmb = new BookMapperBackend();

                try {
                        for (IBook b : obj.loadBooks("books.csv")) {
                                bmb.addBook(b);
                        }

                        if (bmb.searchByTitleWord(title).size() != 0) {
                                return true;
                        }
                } catch (FileNotFoundException e) {
                        return false;
                }

                return false;
        }
}