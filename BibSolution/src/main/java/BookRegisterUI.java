import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

/**
 * Responsible for the interaction with the user. Any output to the user and/or
 * input from the user should be handled by the object of this class!
 *
 * @author Jakob
 * @version 2021-10-27
 */

public class BookRegisterUI {
    private final BookRegister bookRegister;
    private  final int WRONG_INPUT = -1;
    private final int LIST_ALL_PERSONS = 1;
    private final int TERMINATE_PROGRAM = 2;
    private final int SEARCH_BY_AUTHOR = 3;
    private final int SEARCH_BY_TITLE = 4;
    private final int SEARCH_BY_BARCODE = 5;
    private final int ADD_BOOK = 6;
    private final int REMOVE_BOOK = 7;
    private final int CHANGE_LENT_STATUS = 8;


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
            switch (showMenu()) {
                case WRONG_INPUT:
                    System.out.println("Wrong input!");
                    break;
                case LIST_ALL_PERSONS:
                    printAllBooksToUI();
                    break;
                case TERMINATE_PROGRAM:
                {
                    System.out.println("Thank you for using the BookRegisterApp !! Bye!");
                    finished = true;
                    break;
                }
                case SEARCH_BY_AUTHOR:
                    searchByAuthor(input);
                    break;
                case SEARCH_BY_TITLE:
                    searchByTitle(input);
                    break;
                case SEARCH_BY_BARCODE:
                    searchByBarcode(input);
                    break;
                case ADD_BOOK:
                    addBook(input);
                    break;
                case REMOVE_BOOK:
                    removeBook(input);
                    break;
                case CHANGE_LENT_STATUS:
                    changeLentStatus(input);
                    break;
                default :
                    System.out.println("Invalid input!");
                    break;
            }

        }

        input.close();

    }

    /**
     * changes the lent status of a book
     * @param input a scanner object
     */
    private void changeLentStatus(Scanner input) {
        System.out.println("------------------------------------------");
        System.out.println("Enter the barcode of the book");
        String barcode = input.next();
        System.out.println("Enter the status of the book (true/false)");
        // if input is not a boolean, the user will be asked to enter a valid input to avoid errors
        try {
       boolean status = input.nextBoolean();
            Book book = bookRegister.findBookByBarcode(barcode);
            if (book == null) {
                System.out.println("No books found to be changed!");
            }
            else {
                bookRegister.changeLentStatus(barcode, status);
                System.out.println("The status of the book with barcode " + barcode + " has been changed to " + status);
            }

        }
        catch (Exception e) {
            System.out.println("Invalid input!");
        }


        System.out.println("------------------------------------------");

    }

    /**
     * removes a book from the book register
     * @param input a scanner object
     */
    private void removeBook(Scanner input) {
        // remove book from book register with valid inputs


        System.out.println("------------------------------------------");
        System.out.println("Enter the barcode of the book");
        String barcode = input.next();
        System.out.println("------------------------------------------");
        Book book = bookRegister.findBookByBarcode(barcode);
        if (book == null) {
            System.out.println("No books found to be removed!");
        }
        else {
            System.out.println("Book [" + book.getTitle() + "] removed!");
            bookRegister.removeBook(barcode);

        }
    }

    /**
     * Add a new book to the book register
     * @param input A scanner input to utilize the commandline
     */
    private void addBook(Scanner input) {
try {
    System.out.println("------------------------------------------");
    System.out.println("Enter the author of the book");
    String author = input.next();

    System.out.println("Enter the title of the book");
    String title = input.next();
    System.out.println("Enter the publisher of the book");
    String publisher = input.next();
    System.out.println("Enter the year of publication of the book");
    int year = input.nextInt();
    // the amount of pages has to be a positive integer

    System.out.println("Enter the amount of pages in the book");
    int pages = input.nextInt();
    if (pages <= 0) {
        System.out.println("Invalid input!");
        return;
    }
    System.out.println("Is the book lent out? true/false");
    boolean lentOut = input.nextBoolean();
    System.out.println("Enter the barcode of the book");
    String barcode = input.next();
    System.out.println("------------------------------------------");
    Book book = new Book(author, title, publisher, year, pages, lentOut, barcode);
    String returned = bookRegister.addBook(book);
    System.out.println(Objects.requireNonNullElse(returned, "Book not added! (null not permitted)"));
}
catch (Exception e) {
    System.out.println("Invalid input!");
}
    }

    private void searchByBarcode(Scanner input) {
        try {
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
        catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    private void searchByTitle(Scanner input) {
        try {
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
    }
        }
        catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    private void searchByAuthor(Scanner input) {
        try {
            System.out.println("Search by author");

            String authorSearch = input.next();
            ArrayList<Book> Arr = bookRegister.findBooksByAuthor(authorSearch);
            System.out.println("------------------------------------------");
            if (Arr == null) {
                System.out.println("No books found");
            } else {
                for (Book book : Arr) {
                    book.printBookInfo();
                }
            }
            System.out.println("------------------------------------------");

        }
        catch (Exception e) {
            System.out.println("Invalid input!");
        }
        }

    private void printAllBooksToUI() {
        // List all persons
        System.out.println("------------------------------------------");
        printAllBooks();
        System.out.println("------------------------------------------");
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
            book.printBookInfo();
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
    public int showMenu() {
        try {


        printMenu();

        int menuChoice = 0;
        Scanner inputInt = new Scanner(System.in);

        if (inputInt.hasNextInt()) {
            menuChoice = inputInt.nextInt();
        } else {
            System.out.println("Sorry, wrong input. Must be a number. Please try again:-)");

        }

        return menuChoice;
        }
        catch (Exception e) {
            System.out.println("Invalid input!");
            return 0;
        }
    }

    private void printMenu() {
        System.out.println("Welcome to Book Register 0.0.1");
        System.out.println("Menu:");
        System.out.println("------------------------------------------");
        System.out.println("1. List all books");
        System.out.println("2. Exit");
        System.out.println("------------------------------------------");
        System.out.println("3. Search by Author");
        System.out.println("4. Search by Title");
        System.out.println("5. Get book by Barcode");
        System.out.println("6. Add new book");
        System.out.println("7. Delete a book by barcode");
        System.out.println("8. Change lent status of a book by barcode");
        System.out.println("------------------------------------------");

        // System.out.println("People currently in the bookregister:");
        System.out.println("Please enter a valid number from the menu:");
    }

}
