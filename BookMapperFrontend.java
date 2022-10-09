import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMapperFrontend implements IBookMapperFrontend {
    private IBookMapperBackend backend;
    private IISBNValidator validator;
    private Scanner scn;


    public BookMapperFrontend(Scanner userInputScanner, IBookMapperBackend backend,
        IISBNValidator validator) {
        this.backend = backend;
        this.validator = validator;
        this.scn = userInputScanner;
    }

    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     */
    public void runCommandLoop() {
        System.out.println("Welcome to the Book Mapper Application!");
        System.out.println("x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n");
        displayMainMenu();
    }

    /**
     * This method prints the main menu and navigates to another menu when the user inputs a number
     */
    public void displayMainMenu() {
        System.out.println("You are in the Main Menu:");
        System.out.println("          1) Lookup ISBN\n" + "          2) Search by Title Word\n" +
            "          3) Set Author Name Filter\n" + "          4) Exit Application\n");
        int choice = scn.nextInt();

        if (choice == 1) {
            isbnLookup();
        } else if (choice == 2) {
            titleSearch();
        } else if (choice == 3) {
            authorName();
        } else if (choice == 4) {
            System.out.println("Goodbye!");
            this.scn.close();
        }

    }

    /**
     * This method reads an isbn from System.in, displays results
     */
    public void isbnLookup() {
        System.out.println("You are in the Set Author Filter Menu:");
        System.out.println("          Enter ISBN to look up: ");
        String currentISBN = scn.nextLine();
        if (validator.validate(currentISBN)) {
            ArrayList<IBook> bookList = new ArrayList<>();
            bookList.add(backend.getByISBN(currentISBN));
            displayBooks(bookList);
        } else {
            System.out.println("Invalid ISBN");
        }
        displayMainMenu();
    }

    /**
     * This method reads a word from System.in and displays a list of the results
     */
    public void titleSearch() {
        System.out.println("You are in the Search for Title Word Menu:");
        System.out.println("          Enter a word to search for in book titles "
            + "(empty for all books):");
        displayBooks(backend.searchByTitleWord(scn.nextLine()));
    }

    /**
     * sets the author filter to a name frim System.in
     */
    public void authorName() {
        System.out.println("You are in the Set Author Filter Menu:");
        System.out.println("          Author name must currently contain:" +
            backend.getAuthorFilter());
        System.out.println("          Enter a new string for author names to contain "
            + "(empty for any):");
        backend.setAuthorFilter(scn.nextLine());
        displayMainMenu();
    }

    /**
     * prints a list of books based on the author filter and title word
     * @param books
     */
    public void displayBooks(List<IBook> books) {
        int numBooks = books.size();
        if (numBooks != 1) {
            System.out.println(
                "Matches (author filter: " + backend.getAuthorFilter() + ") " + books.size() +
                    " of " + backend.getNumberOfBooks());
        }
        for (int i = 0; i <= numBooks; i++) {
            System.out.println((i + 1) + ". " + "\"" + books.get(i).getTitle() +
                "\"" + " by " + books.get(i).getAuthors() + ", ISBN: " + books.get(i).getISBN13());
        }
    }
}
