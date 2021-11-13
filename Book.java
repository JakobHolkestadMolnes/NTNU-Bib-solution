/**
 * A class that maintains information on a book. This might form part of a
 * larger application such as a library system, for instance.
 *
 * @author Jakob H. Molnes
 * @version 2021/09/09
 */
class Book {
    // The fields.
    private final String author;
    private final String title;
    private final String publisher;
    private final String releaseYear;
    private final int pages;
    private final String barcode;
    private boolean lent;

    /**
     * Set the author and title fields when this object is constructed.
     */
    public Book(String author, String title, String publisher, String releaseYear, int pages, boolean lent,
                String barcode) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.pages = pages;
        this.lent = lent;
        this.barcode = barcode;
    }

    /**
     * Prints the content of this java class to the console.
     */
    public void printBookInfo() {
        System.out.println("---------------------------");
        System.out.println("Author: " + this.author);
        System.out.println("Title: " + this.title);
        System.out.println("Publisher : " + this.publisher);
        System.out.println("Release Year: " + this.releaseYear);
        System.out.println("Pages: " + this.pages);
        System.out.println("Lent out: " + this.lent);
        System.out.println("Barcode: " + this.barcode);
        System.out.println("---------------------------");
    }

    /**
     * Changes the lent status of the book
     */
    public void changeLentStatus() {
        this.lent = !(this.lent);
    }

    /**
     * Checks if the book is lent out or not.
     */
    public boolean isLent() {
        return this.lent;
    }

    /**
     * Returns the author of the book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the book.
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Returns the release year of the book.
     */
    public String getReleaseYear() {
        return this.releaseYear;
    }

    /**
     * Returns the number of pages in the book.
     */
    public int getPages() {

        return this.pages;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setLentStatus(boolean status) {
        this.lent = status;
    }
}