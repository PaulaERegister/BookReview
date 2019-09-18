package objects;

public class Book {
    private String title;
    private String author;
    private String review;

    private int isbn;
    private int pages;

    private float rating;

    public Book(String title, String author, String review, int pages, int isbn,  float rating) {
        this.title = title;
        this.author = author;
        this.review = review;
        this.pages = pages;
        this.isbn = isbn;
        this.rating = rating;
    }

    /**
     * Overloaded constructor for creating Book object from row in CSV file.
     * @param data Array of String objects from CSV file
     */
    public Book(String[] data) {
        this(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Float.parseFloat(data[5]));
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
