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
                System.out.println("AlgorithmEngineer Partner (DataWrangler) Test 1: " + (test8() ? "passed" : "failed"));
                System.out.println("AlgorithmEngineer Partner (DataWrangler) Test 2: " + (test9() ? "passed" : "failed"));
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


        // checks if all the books are printed
        public static boolean test2() {

                BookLoader obj = new BookLoader();

                List<IBook> books;
                
                int bookCount = 0;

                try {
                        books = obj.loadBooks("books.csv");
                        for (IBook b : books) {

                               bookCount++;

                        }
                        
                        if(books.size() == bookCount)
                        {
                        	return true;
                        }

                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return false;
        }

        //method is used to check if there any books present in the file
        public static boolean test3() {
                BookLoader obj = new BookLoader();

                List<IBook> books;

                try {
                        books = obj.loadBooks("books.csv");

                        int bookCount = books.size();

                        if (bookCount != 0) 
                        {
                                return true;
                        }
                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return true;
        }

        // method checks if given isbn is valid
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

        // method checks author filter
        public static boolean test5() {
                String author = "Rowling";

                BookLoader obj = new BookLoader();

                List<IBook> books;

                try {
                        books = obj.loadBooks("books.csv");

                        for (IBook b : books) {
                                if (b.getAuthors().contains(author)) 
                                {
                                        return true;
                                }

                        }
                }

                catch (FileNotFoundException e) {
                        return false;
                }

                return false;
        }

        /*
         * Integration Test 1
         * methods checks if author filter is set by searchByTitleWord
         */
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

        /*
         * Integration Test 2
         * method checks if validator validates an isbn
         */
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

      
       
	/*
         * Partner Test1
         *  method checks validator with some edge cases
         */ 
        public static boolean test8()
        {
                ISBNValidator val = new ISBNValidator();

                if(!val.validate(""))
                {
                        return true;
                }

                return false;
        }

	 
	
	/*
         * Partner Test 2
         *  method checks if the hashmap is empty or not
         */
        public static boolean test9()
        {
            IterableMap<Integer, Integer> map = new IterableMap();

	    map.put(3,384);
	    map.put(42647,24);
	    map.put(273,384);
	    map.put(38,482);
	    
           if(map.size() != 0)
           {
        	   return true;
           }
            return false;

         }

}
