import java.io.FileNotFoundException;
import java.util.List;

public class DataWranglerTest 
{
  public static void main(String[] args)
  {
	  System.out.println("DataWrangler Individual Test 1: " + (test1() ? "passed" : "failed"));
      System.out.println("DataWrangler Individual Test 2: " + (test2() ? "passed" : "failed"));
      System.out.println("DataWrangler Individual Test 3: " + (test3() ? "passed" : "failed"));
      System.out.println("DataWrangler Individual Test 4: " + (test4() ? "passed" : "failed"));
      System.out.println("DataWrangler Individual Test 5: " + (test5() ? "passed" : "failed"));
      System.out.println("DataWrangler Integration Test 1: " + (test6() ? "passed" : "failed"));
      System.out.println("DataWrangler Integration Test 2: " + (test7() ? "passed" : "failed"));
      
  }
  
  //this method is to check if the path is null 
  public static boolean test1()
  {

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
               
                 return true;
        }
         
         return false;

  }
  
  //prints all the books present in the csv file
  public static boolean test2()
  {
                 
                 
          BookLoader obj = new BookLoader();
          
          List<IBook> books;
          
         try 
         {
                books = obj.loadBooks("books.csv");
                for(IBook b:books)
                {
             

                        return true;


                }



        } 
         
         catch (FileNotFoundException e) 
         {
                // TODO Auto-generated catch block

                 return false;
                  
        }

         
         return true;


  }
  
  
 
  
//this method returns the count of books present in the csv file
public static boolean test3()
{
        BookLoader obj = new BookLoader();

        List<IBook> books;

  

        try
        {
                books = obj.loadBooks("books.csv");

                int bookCount = books.size();

                if(bookCount != 0)
                {
                     return true;
                }
        }

        catch (FileNotFoundException e) 
         {
                // TODO Auto-generated catch block
             
                 return false;
                  
        }

        return true;
}

//method returns details of a book through isbn
public static boolean test4()
{
        String isbn = "9780976540601";

        BookLoader obj = new BookLoader();

        List<IBook> books;


        try
        {
                books = obj.loadBooks("books.csv");



                for(IBook b: books)
                {
                        if(b.getISBN13().equals(isbn))
                        {
                            
                                return true;
                        }

                }


}

        catch (FileNotFoundException e) 
         {
                // TODO Auto-generated catch block
      
                 return false;
                 
                  
        }

 
         return false;
}

//method returns details of a book through authors
public static boolean test5()
{
        String author = "Rowling";

    BookLoader obj = new BookLoader();

        List<IBook> books;

      

        if(author == "")
        {

                return false;
        }

        try
        {
                books = obj.loadBooks("books.csv");

                for(IBook b: books)
                {
                        if(b.getAuthors().contains(author))
                        {

                                return true;
                        }

                }
}

        catch (FileNotFoundException e) 
         {
                // TODO Auto-generated catch block

                 return false;
                 
                  
        }


        return false;


}

//method sets a author filter
public static boolean test6()
{

        String author = "Douglas Adams";

  BookLoader obj = new BookLoader();

  BookMapperBackend bmb = new BookMapperBackend();
  
    bmb.setAuthorFilter(author);

        List<IBook> books;

        try
        {
                books = obj.loadBooks("books.csv");

                for(IBook b: books)
                {
                	bmb.addBook(b);
                }
                
                for(IBook b: bmb.searchByTitleWord(""))
                {
                	if(!b.getAuthors().equals(author))
                	{
                	   return false;
               	}
                }
}

        catch (FileNotFoundException e)
         {
                // TODO Auto-generated catch block

                 return false;
        }

        return true;


}

//method validates entered for isbn
public static boolean test7()
{
        String isbn = "9780743264464";

        BookLoader obj = new BookLoader();
        
        ISBNValidator val = new ISBNValidator();


        try
        {
        	 List<IBook> books = obj.loadBooks("books.csv");



                for(IBook b: books)
                {
                        if(val.validate(isbn))
                        {
                                return true;
                        }

                }


}

        catch (FileNotFoundException e)
         {
                // TODO Auto-generated catch block
                 return false;


        }

         return false;
}


}