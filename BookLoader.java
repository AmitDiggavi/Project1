
import java.io.BufferedReader; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BookLoader implements IBookLoader 
{
    
	/**
     * This method loads the list of books from a CSV file.
     * @param filepathToCSV path to the CSV file relative to the executable
     * @return a list of book objects
     * @throws FileNotFoundException
     */
	public List<IBook> loadBooks(String filepathToCSV) throws FileNotFoundException
	{
	// TODO Auto-generated method stub
		
	//using array list since list is a abstract class which cannot be called 
		List<IBook> bookList = new ArrayList<IBook>();
		
		File f = new File(filepathToCSV);
		
		
		//checks if the path exists
		if(!f.exists())
		{
			//for invalid paths throws exception
			throw new FileNotFoundException();
	    }
		
		
		
	//Using try with resources automatically calls close() on these objects
	try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8")))
		{   
	 //if csv file has quotes and comma characters use regular expressions otherwise io.scanner
			String delimiter = ",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
			String str;
			String[] fields;
			
			str = bufferRead.readLine();
			
			//reads each of the fields while they are not null
			while((str = bufferRead.readLine()) != null)
			{
				
			    fields = str.split(delimiter);
				
				//taking only needed fields from the list 
				 Book book = new Book(fields[1], fields[2], fields[5]);
				
				bookList.add(book);
				
			}
			
		}
		
		
		catch(Exception e)
		{
			
			//catches the above throw exception
			System.out.println("File not Found");
			
		}
		
		//returns the listed fields 
		return bookList;
	}
	
	

}
