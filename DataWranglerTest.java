import java.io.FileNotFoundException; 
import java.util.List; 

public class DataWranglerTest 
{
  public static void main(String[] args)
  {
      test1();
      test2();
      test3();
      test4("9780345453747");
      test5("Rowling");
      
  }
  
  //this method is to check if the path is null 
  public static boolean test1()
  {
    
	  System.out.println("Test1: ");
	
	  BookLoader obj = new BookLoader();
	  
	  List<IBook> books1;
	  
	  String path = null;
	  
	  
	 try 
	 {
		books1 = obj.loadBooks(path);
	} 
	 
	 catch (Exception e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("true");
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 return true;
	}
	 
	 
	 System.out.println("false");
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 
	 
	 return false;

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
			System.out.println("true");
			
			return true;
			
			
		}
		
		
		
	} 
	 
	 catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("false");
		 
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
public static boolean test3()
{
	BookLoader obj = new BookLoader();
	
	List<IBook> books;
	
	System.out.println("Test3: ");
	
	try
	{
		books = obj.loadBooks("books.csv");
		
		int bookCount = books.size();
		
		if(bookCount != 0)
		{
			 System.out.println("true");
		}
	}
	
	catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("False");
		 
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

//method returns details of a book through isbn
public static boolean test4(String isbn)
{

	BookLoader obj = new BookLoader();
	
	List<IBook> books;
	
	System.out.println("Test4: ");
	
	if(isbn == "")
	{
		System.out.println("False");
		
		return false;
	}
	
	try
	{
		books = obj.loadBooks("books.csv");
		
		
		
		for(IBook b: books)
		{
			if(b.getISBN13().equals(isbn))
			{
				System.out.println("true");
				return true;
			}
				
		}
		
		
}
	
	catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("False");
		 
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 
		 return false;
		 
		  
	}
	
	 System.out.println("false");
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 System.out.println();
  
	 return false;
}

//method returns details of a book through authors
public static boolean test5(String author)
{
    BookLoader obj = new BookLoader();
	
	List<IBook> books;
	
	System.out.println("Test5: ");
	
	if(author == "")
	{
		System.out.println("false");
		
		return false;
	}
	
	try
	{
		books = obj.loadBooks("books.csv");
		
		for(IBook b: books)
		{
			if(b.getAuthors().contains(author))
			{
				System.out.println("true");
				
				return true;
			}
				
		}
}
	
	catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		 System.out.println("False");
		 
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 
		 return false;
		 
		  
	}
	
	System.out.println("False");
	return false;
	
	
}


}



