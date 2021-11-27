

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * The test class BookRegisterTest.
 *
 * @author  Jakob Holkstad Molnes
 * @version 2021/11/18
 */
public class BookRegisterTest
{
    /**
     * Default constructor for test class BookRegisterTest
     */
    public BookRegisterTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void addBook()
    {
        BookRegister bookRegi1 = new BookRegister();
        bookRegi1.addBook(new Book("Test","Test","Test",2021,100,false,"1234567891011"));
        Book book = bookRegi1.findBookByBarcode("1234567891011");
       String title = book.getTitle();
       assertEquals("Test",title);

       String author = book.getAuthor();
       assertEquals("Test",author);

       String publisher = book.getPublisher();
       assertEquals("Test",publisher);

       int year = book.getReleaseYear();
       assertEquals(2021,year);

       int pages = book.getPages();
       assertEquals(100,pages);

       boolean isBorrowed = book.isLent();
        assertFalse(isBorrowed);

        String barcode = book.getBarcode();
        assertEquals("1234567891011",barcode);

    }


    @Test
    public void checkBookNotNull() {
        BookRegister bookRegi1 = new BookRegister();
         String returned = bookRegi1.addBook(null);
         assertNotEquals("Book added",returned);
        assertNull(returned);


    }
    @Test
    public void correctAmountOfBooks(){
        BookRegister bookRegi1 = new BookRegister();
        bookRegi1.fillBookList();
        int amountOfBooks = bookRegi1.getSize();
        assertEquals(5,amountOfBooks);
    }
    @Test
    public void testAuthorSearch(){
        BookRegister bookRegi1 = new BookRegister();
        bookRegi1.fillBookList();
        int amountOfBooks = bookRegi1.findBooksByAuthor("Kristine").size();
        assertEquals(2,amountOfBooks);
    }
    @Test
    public void testTitleSearch(){
        BookRegister bookRegi1 = new BookRegister();
        bookRegi1.fillBookList();
        int amountOfBooks = bookRegi1.findBooksByTitle("Kvantefysikk").size();
        assertEquals(2,amountOfBooks);
    }
    @Test
    public void testDeleteBook(){
        BookRegister bookRegi1 = new BookRegister();
        bookRegi1.fillBookList();
        bookRegi1.removeBook("1067586749234");
        int amountOfBooks = bookRegi1.getSize();
        assertEquals(4,amountOfBooks);
    }
    @Test
    public void testDeleteOfNonExistingBook(){
        BookRegister bookRegi1 = new BookRegister();
        bookRegi1.fillBookList();
        boolean returned = bookRegi1.removeBook("nonExistingBook");

        assertFalse(returned);
    }
    @Test
    public void testIncorrectSearch(){
        BookRegister bookRegi1 = new BookRegister();
        bookRegi1.fillBookList();
        ArrayList<Book> amountOfBooks = bookRegi1.findBooksByAuthor("nonExistingAuthor");
        assertNull(amountOfBooks);
    }
}



