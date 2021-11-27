
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The test class BookRegisterTest.
 *
 * @author  Jakob Holkstad Molnes
 * @version 2021/11/18
 */
public class BookTest {
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
    String author = "AuthorTest";
    String title = "TitleTest";
    String publisher = "PublisherTest";
    int year = 2020;
    int pages = 100;
    boolean lent = false;
    String isbn = "ISBNTest";

    @Test
    public void getAuthor() {
        Book book = new Book(author, title, publisher, year, pages, lent, isbn);
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void getTitle() {
        Book book = new Book(author, title, publisher, year, pages, lent, isbn);
        assertEquals(title, book.getTitle());
    }

    @Test
    public void getPublisher() {
        Book book = new Book(author, title, publisher, year, pages, lent, isbn);
        assertEquals(publisher, book.getPublisher());
    }

    @Test
    public void getYear() {
        Book book = new Book(author, title, publisher, year, pages, lent, isbn);
        assertEquals(year, book.getReleaseYear());
    }

    @Test
    public void getPages() {
        Book book = new Book(author, title, publisher, year, pages, lent, isbn);
        assertEquals(pages, book.getPages());
    }

    @Test
    public void getLent() {
        Book book = new Book(author, title, publisher, year, pages, lent, isbn);
        assertEquals(lent, book.isLent());
    }

    @Test
    public void getIsbn() {
        Book book = new Book(author, title, publisher, year, pages, lent, isbn);
        assertEquals(isbn, book.getBarcode());
    }

    @Test
    public void checkLent() {
        Book book = new Book(author, title, publisher, year, pages, lent, isbn);
        book.setLentStatus(true);
        assertTrue(book.isLent());
    }
}