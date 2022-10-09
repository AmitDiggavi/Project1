
public class Book implements IBook
{
	//variables for the requested fields 
	private String title;
	private String authors;
	private String isbn13;
	
	public Book(String vTitle, String vAuthors, String vIsbn13)//Constructor
	{
		this.title = vTitle;
		
		this.authors = vAuthors;
		
		this.isbn13 = vIsbn13;
	}
	

	public String getTitle() {
		// TODO Auto-generated method stub
		
		//returns title of the boom
		return title;
	}

	
	public String getAuthors() {
		// TODO Auto-generated method stub
		
		//returns authors of the book
		return authors;
	}

	
	public String getISBN13() {
		// TODO Auto-generated method stub
		
		//returns the isbn13 number
		return isbn13;
	}

}



public class Book implements IBook {

    private String title;
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;

    }
    /**
     * Returns the title of the book.
     * @return title of the book
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns a string that contains the authors of the book
     * as a single string with different authors separated by /.
     * @return author names as single string
     */
   public String getAuthors()
    {
        return this.author;
    }

    /**
     * Returns the 13 digit ISBN (ISBN13) that uniquely identifies this book.
     * @return ISBN number of book
     */
    public String getISBN13()
    {
        return this.ISBN;
    }

}
