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

