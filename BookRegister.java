import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public class BookRegister {
    private final HashMap<String, Book> books;

    public BookRegister() {
        this.books = new HashMap<String, Book>();
        fillBookList();
    }


    public Iterator<Book> getIterator() {
        return this.books.values().iterator();
    }

    public int getSize() {
        return this.books.size();
    }
    public String addBook(Book book) {
    // Add book to the register if book is not null
        if (book != null) {
        this.books.put(book.getBarcode(), book);
        return "Book added";
    }
        else {
            System.err.println("Book is null");
            return null;
        }
    }
    public boolean removeBook(String barcode) {
        // Remove book from the register if barcode exists
        Book returned = this.books.remove(barcode);

        return returned != null;
    }

    public Book findBookByBarcode(String barcode) {
        return this.books.get(barcode);
    }

    public ArrayList<Book> findBooksByTitle(String name) {
        ArrayList<Book> foundBooks = new ArrayList<>();


        Iterator<Book> it = getIterator();

        while (it.hasNext()) {
            Book currentBook = it.next();

            if (currentBook.getTitle().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {

                foundBooks.add(currentBook);
            }
        }
        if (foundBooks.isEmpty()) {
            foundBooks = null;
        }

        return foundBooks;
    }

    public ArrayList<Book> findBooksByAuthor(String name) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        Iterator<Book> it = getIterator();

        while (it.hasNext()) {
            Book currentBook = it.next();

            if (currentBook.getAuthor().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                foundBooks.add(currentBook);

            }
        }
        if (foundBooks.isEmpty()) {
            foundBooks = null;
        }
        return foundBooks;
    }

    public void changeLentStatus(String barcode, boolean status) {
        Book book = this.books.get(barcode);
        if (book != null) {
            book.setLentStatus(status);
        }

    }

    public void fillBookList() {
        addBook(new Book("Per", "Per's Tur", "Per's mor", 1965, 311, false, "7685746575644"));
        addBook(new Book("Karen", "Hvordan kjefte på butikkmedarbeidere", "ingen", 2020, 1991, true,
                "8758765654567"));
        addBook(new Book("Ole", "Ole's oppskrifter", "matMenyer", 2011, 80, true, "7685746574659"));
        addBook(new Book("Kristine", "Kvantefysikk for idioter", "smartefolk", 2001, 3020, false, "1067586749234"));
        addBook(new Book("Kristine", "Kvantefysikk for smartinger", "smartefolk", 2001, 3020, false,
                "1067566749234"));
    }
}
