import java.io.FileNotFoundException; 
import java.util.List; 

public class DataWranglerTest 
{
  public static void main(String[] args)
  {
      test1();
      test2();
      getBookcount();
      printBookbyIsbn("9780439554893");
      printBookbyAuthor("Rowling");
      
  }
  
  //prints all the books present in the csv file
  public static boolean test2()
  {
		 
		 
	  BookLoader obj = new BookLoader();
	  
	  List<IBook> books;
	  
	  System.out.println("Test2: ");
	  
	 try 
	 {
		books = obj.loadBooks("books.csv");
		for(IBook b:books)
		{
			System.out.println(b.getTitle() + "       " + b.getAuthors() + "        " + b.getISBN13());
			
			
		}
		
		
		
	} 
	 
	 catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("Path Does Not Exist");
		 
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 return false;
		  
	}
	 
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 
	 
	 return true;


  }
  
  
  //this method is to check output when a wrong path is given
  public static boolean test1()
  {
    
	  System.out.println("Test1: ");
	
	  BookLoader obj = new BookLoader();
	  
	  List<IBook> books1;
	  
	  
	 try 
	 {
		books1 = obj.loadBooks("/Users/suryanarne/eclipse-workspace");
		
	} 
	 
	 catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("Path Does Not Exist");
		 
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 return false;
		 
		  
	}
	 
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 
	 
	 return true;

  }
  
//this method returns the count of books present in the csv file
public static int getBookcount()
{
	BookLoader obj = new BookLoader();
	
	List<IBook> books;
	
	System.out.println("Test3: ");
	
	try
	{
		books = obj.loadBooks("books.csv");
		
		int bookCount = books.size();
		
		System.out.println("Book Count: " + bookCount);
	}
	
	catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("Path Does Not Exist");
		 
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 
		  
	}
	
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
	return 0;
}

//method returns details of a book through isbn
public static void printBookbyIsbn(String isbn)
{

	BookLoader obj = new BookLoader();
	
	List<IBook> books;
	
	System.out.println("Test4: ");
	
	if(isbn == "")
	{
		System.out.println("Enter valid isbn");
		
		return;
	}
	
	try
	{
		books = obj.loadBooks("books.csv");
		
		
		
		for(IBook b: books)
		{
			if(b.getISBN13().equals(isbn))
			{
				System.out.println(b.getTitle() + "       " + b.getAuthors() + "        " + b.getISBN13());
			}
				
		}
}
	
	catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("Path Does Not Exist");
		 
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 
		  
	}
	
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
  
}

//method returns details of a book through authors
public static void printBookbyAuthor(String author)
{
    BookLoader obj = new BookLoader();
	
	List<IBook> books;
	
	System.out.println("Test5: ");
	
	if(author == "")
	{
		System.out.println("Enter valid author");
		
		return;
	}
	
	try
	{
		books = obj.loadBooks("books.csv");
		
		for(IBook b: books)
		{
			if(b.getAuthors().contains(author))
			{
				System.out.println(b.getTitle() + "       " + b.getAuthors() + "        " + b.getISBN13());
			}
				
		}
}
	
	catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("Path Does Not Exist");
		 
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 
		  
	}
	
	
}


}

