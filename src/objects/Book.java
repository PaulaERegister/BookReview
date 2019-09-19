package objects;

public class Book {
    private String title;
    private String author;
    private String review;

    private int isbn;
    private int pages;

    private double rating;

    public Book(int isbn, String title, String author, String review, int pages, double rating) {
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
        this(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]), Double.parseDouble(data[5]));

    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
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
