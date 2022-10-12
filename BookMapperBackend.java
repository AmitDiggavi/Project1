import java.util.ArrayList;
import java.util.List;


public class BookMapperBackend implements IBookMapperBackend {


    protected IterableMap<String, IBook> hashmap = new IterableMap<>();
    protected String authorFilter = "";
    /**
     * Adds a new book to the backend's database and is stored in
     * a hash table internally.
     * @param book the book to add
     */
    public void addBook(IBook book)
    {
        hashmap.put(book.getISBN13(), book);
    }

    /**
     * Returns the number of books stored in the backend's database.
     * @return the number of books
     */
    public int getNumberOfBooks()
    {
        return hashmap.size();
    }

    /**
     * This method can be used to set a filter for the author names
     * contained in the search results. A book is only returned as
     * a result for a search by title, it is also contains the string
     * filterBy in the names of its authors.
     * @param filterBy the string that the book's author names must contain
     */
    public void setAuthorFilter(String filterBy)
    {
        authorFilter = filterBy;
    }

    /**
     * Returns the string used as the author filter, null if no author
     * filter is currently set.
     * @return the string used as the author filter, or null if none is set
     */
    public String getAuthorFilter()
    {
        return authorFilter;
    }

    /**
     * Resets the author filter to null (no filter).
     */
    public void resetAuthorFilter()
    {
        authorFilter = "";
    }

    /**
     * Search through all the books in the title base and return books whose
     * title contains the string word (and that satisfies the author filter,
     * if an author filter is set).
     * @param word word that must be contained in a book's title in result set
     * @return list of books found
     */
    public List<IBook> searchByTitleWord(String word) {
        List<IBook> list_of_books = new ArrayList<>();

        for(IBook book : hashmap)
        {
            if(getAuthorFilter().equals(""))
            {
                if(word.equals("")) {
                    list_of_books.add(book);
                } else
                {
                    if (book.getTitle().toLowerCase().contains(word.toLowerCase())) {
                        list_of_books.add(book);
                    }
                }

            }  else
            {
                if(word.equals("")) {
                    if (book.getAuthors().contains(getAuthorFilter())) {
                        list_of_books.add(book);
                    }
                } else
                {
                    if(book.getTitle().toLowerCase().contains(word.toLowerCase()) 
                        && book.getAuthors().contains(getAuthorFilter()))
                    {
                        list_of_books.add(book);
                    }
                }


            }

        }

        return list_of_books;
    }


        /**
         * Return the book uniquely identified by the ISBN, or null if ISBN is not
         * present in the dataset.
         * @param ISBN the book's ISBN number
         * @return the book identified by the ISBN, or null if ISBN not in database
         */
        public IBook getByISBN (String ISBN)
        {

            for (IBook book : hashmap) {
                if (book.getISBN13().equals(ISBN)) {
                    return book;
                }
            }

            return null;
        }

    }
        
