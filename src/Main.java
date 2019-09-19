import objects.Book;
import tables.BookTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private Connection conn;

    /**
     * Create a database connection with the given params
     * @param location: path of where to place the database
     * @param user: user name for the owner of the database
     * @param password: password of the database owner
     */
    public void createConnection(String location,
                                 String user,
                                 String password) {
        try {
            String url = "jdbc:h2:" + location;

            Class.forName("org.h2.Driver");

            //create the connection
            conn = DriverManager.getConnection(url,
                    user,
                    password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return returns the private Connection
     */
    public Connection getConnection(){
        return conn;
    }

    /**
     * Drops all objects created in the database. Used to prevent duplicate data.
     */
    private void dropAll(){
        String query = "DROP ALL OBJECTS";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * When the database program exits, the connection should be closed
     */
    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeTables(){
        try {
            BookTable.createBookTable(conn);
            BookTable.addBook(conn, 2, "test", "author", "review", 1, 3.00f);
            BookTable.populateBookTableFromCSV(conn, "./src/csv/Books.csv");
            BookTable.printBookTable(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main test = new Main();
        String location = "./h2demo/h2demo";
        String user = "me";
        String password = "password";

        test.createConnection(location, user, password);
        test.dropAll();

        test.initializeTables();

        test.dropAll();
        test.closeConnection();
    }
}
