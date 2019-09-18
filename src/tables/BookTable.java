package tables;

import objects.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookTable {
    public static void createBookTable(Connection conn){
        try {
            String query = "CREATE TABLE IF NOT EXISTS book("
                    + "ISBN INT PRIMARY KEY,"
                    + "TITLE VARCHAR(255),"
                    + "AUTHOR VARCHAR(255),"
                    + "REVIEW VARCHAR(1000),"
                    + "PAGES INT,"
                    + "RATING FLOAT,"
                    + ");" ;
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void populateBookTableFromCSV(Connection conn, String filename) throws SQLException {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null) {
                String[] split = line.split(",");
                books.add(new Book(split));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sql = createBookInsertSQL(books);
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    public static String createBookInsertSQL(ArrayList<Book> books) {
        return null;
    }

    public static void addBook(Connection conn,
                                 int isbn,
                                 String title,
                                 String author,
                                 String review,
                                 int pages,
                                 float rating) {
        String query = String.format("INSERT INTO book " +
                        "VALUES(%d,\'%s\',\'%s\',\'%s\',\'%d\',\'%f\');",
                isbn, title, author, review, pages, rating);
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printBookTable(Connection conn) {
        String query = "SELECT * FROM book;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.printf("book %d: %s\t%s\t%s\t%s\t%f\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getFloat(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
