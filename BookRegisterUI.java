import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Responsible for the interaction with the user. Any output to the user and/or
 * input from the user shuld be handeled by the object of this class!
 *
 * @author Jakob
 * @version 2021-10-27
 */

public class BookRegisterUI {
    private final BookRegister bookRegister;


    public BookRegisterUI() {
        this.bookRegister = new BookRegister();
    }

    public void init() {
        BookRegister bookRegister = new BookRegister();
        bookRegister.fillBookList();
    }

    public void start() {
        boolean finished = false;
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        while (!finished) {
            // Show menu
            int menuChoice = showMenu(input);

            if (menuChoice == 1) {
                // List all persons
                System.out.println("------------------------------------------");
                printAllBooks();
                System.out.println("------------------------------------------");
            }

            if (menuChoice == 2) {
                // Terminate
                System.out.println("Thank you for using the BookRegisterApp !! Bye!");
                finished = true;
            }
            if (menuChoice == 3) {
                System.out.println("Search by author");

                String authorSearch = input.next();
                ArrayList<Book> Arr = bookRegister.findBooksByAuthor(authorSearch);
                System.out.println("------------------------------------------");
                if (Arr == null) {
                    System.out.println("No books found");
                }
                else{
                for (Book book : Arr) {
                    System.out.println("Author: " + book.getAuthor() + ", " + "Title: " + book.getTitle() + ",  Barcode: " + book.getBarcode() );
                }}
                System.out.println("------------------------------------------");

            }
            if (menuChoice == 4) {
                System.out.println("Search by title");
                String titleSearch = input.next();
                ArrayList<Book> arr = bookRegister.findBooksByTitle(titleSearch);
                if (arr == null) {
                    System.out.println("No books found");
                }
                else {
                for (Book book : arr) {
                book.printBookInfo();
                }
                System.out.println("------------------------------------------");
            }}
            if (menuChoice == 5) {
                System.out.println("Search by barcode");
                String barcodeSearch = input.next();
                Book book = bookRegister.findBookByBarcode(barcodeSearch);
                if (book == null) {
                    System.out.println("No books found");
                }
                else {
                    book.printBookInfo();
                }
            }
            if (menuChoice == 6) {
                // add new book to book register with valid inputs
                // example : "J.R.R Tolkien", "The Hobbit", "Some publisher", "1986", "1006", "564478674237652"

                System.out.println("------------------------------------------");
                System.out.println("Enter the author of the book");
                String author = input.next();

                System.out.println("Enter the title of the book");
                String title = input.next();
                System.out.println("Enter the publisher of the book");
                String publisher = input.next();
                System.out.println("Enter the year of publication of the book");
                String year = input.next();
                System.out.println("Enter the amount of pages in the book");
                int pages = input.nextInt();
                System.out.println("Is the book lent out? true/false");
                boolean lentOut = input.nextBoolean();
                System.out.println("Enter the barcode of the book");
                String barcode = input.next();
                System.out.println("------------------------------------------");
                Book book = new Book(author, title, publisher, year, pages, lentOut, barcode);
                bookRegister.addBook(book);
            }
        }

        input.close();

    }

    /**
     * Prints a list of all persons in the book register, to the terminal.
     */
    public void printAllBooks() {
        // Use iterator to enable loose coupling
        Iterator<Book> it = this.bookRegister.getIterator();
        while (it.hasNext()) {
            Book book = it.next();
            // Print title and author
            System.out.println("Title: " + book.getTitle() + " Author: " + book.getAuthor());
        }
    }

    /**
     * Displays the menu to the user, and accepts input from the user. Returns a
     * number corresponding to the menu chosen by the user. Returns 0 if wrong
     * input.
     *
     * @return a number representing the menu chosen by the user. 0 is returned if
     *         the user input is invalid.
     *
     */
    public int showMenu(Scanner input) {
        System.out.println("Welcome to Book Register 0.0.1");
        System.out.println("Menu:");
        System.out.println("1. List all books");
        System.out.println("2. Exit");
        System.out.println("3. Search by Author");
        System.out.println("4. Search by Title");
        System.out.println("5. Search by Barcode");
        System.out.println("------------------------------------------");

        // System.out.println("People currently in the bookregister:");
        System.out.println("Please enter a number (1 or 2) from the menu:");

        int menuChoice;

        if (input.hasNextInt()) {
            menuChoice = input.nextInt();
        } else {
            System.out.println("Sorry, wrong input. Must be a number, 1 or 2. Please try again:-)");
            menuChoice = 0;
        }
        // userInput.close();
        return menuChoice;
    }

}
