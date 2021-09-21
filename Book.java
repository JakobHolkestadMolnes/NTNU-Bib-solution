/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author Jakob H. Molnes
 * @version 2021/09/09
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private String publisher;
    private String realeseYear;
    private int pages;
    private String barcode;
    private boolean lent;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String author, String title,
    String publisher, String realeseYear,
     int pages, boolean lent)
    {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.realeseYear = realeseYear;
        this.pages = pages;
        this.lent = lent;
    }
    /**
     * Prints the content of this java class to the console.
     */
    public void printBookInfo(){
        System.out.println("Author: " + this.author);
        System.out.println("Title: " + this.title);
        System.out.println("Publisher : " + this.publisher);
        System.out.println("Realese Year: " + this.realeseYear);
        System.out.println("Pages: " + this.pages);
        System.out.println("Lent out: " + this.lent);
    }
    /**
     * Changes the lent status of the book
     */
    public void changeLentStatus(){
        this.lent = !(this.lent);
    }
    /** 
     * Checks if the book is lent out or not.
     */
    public boolean isLent(){
    return this.lent;
    }
    /**
     * Returns the author of the book.
     */
    public String getAuthor(){
        return this.author;
    }
    /**
     * Returns the title of the book.
     */
    public String getTitle(){
    return this.title;
    }
    /**
     * Returns the publisher of the book.
     */
    public String getPublisher(){
        return this.publisher;
    }
    /**
     * Returns the realese year of the book.
     */
    public String getRealeseYear(){
        return this.realeseYear;
    }
    /**
     * Returns the number of pages in the book.
     */
    public int getPages(){
        return this.pages;
    }
    
}
