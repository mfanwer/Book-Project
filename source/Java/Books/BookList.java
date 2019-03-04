/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Faraz Anwer
 */
public class BookList {
    
    private ArrayList<Book> books;
    
    public BookList() {
        books = new ArrayList();
        }
   
    public ArrayList getBooks() {
        return books;
    }
    
   
  
    public void loadBooks() {
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Books", "app", "app");
        }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        
        try {
            // Create and execute query statement for all in Cameras table,
            // storing links to matching records in ResultSet object results.
            statement = connection.createStatement();
            results = statement.executeQuery("select * from Bookt order by bookid desc");
            
             // Loop to next record in results, while there is a next record.
            while (results.next()) {
                
                // Get each field of current record (as appropriate type)
                String bookid = results.getString("bookid");
                String category = results.getString("category");
                String bookname = results.getString("bookname");
               
                String authorname = results.getString("authorname");
                 String publication =  results.getString("publication");
                String price = results.getString("price"); 
                String description = results.getString("description");
                String email = results.getString("email");
//                String bookimage = results.getString("images");
            
             Book b = new Book(bookid, category, bookname, authorname, publication, price, description, email,null);
        books.add(b);
            }
        }
       catch (SQLException ex) {
            System.out.println(" noQuery failed!");
        }
    } 
        
    
    public void add(String bookid, String category, String bookname, String authorname, String publication, String price, String description, String email, String bookimage) {
        Book b = new Book(bookid, category, bookname, authorname, publication, price, description, email, bookimage);
        books.add(b);
    }
    
   
    public void add(Book b) {
        books.add(b);
    }
    
     public int getSize() {
        return books.size();
    }
    
  
    public int getTotal(String bookid) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (bookid.equals(b.getBookid())) {
                return Integer.parseInt(b.getPrice());
            }
        }
        return 0;
    }
    
     public Book getBook(String bookid) {
        for (int i = 0; i < books.size(); i++) {
            Book b= books.get(i);
            if (bookid.equals(b.getBookid())) {
                return b;
            }
        }
        return null;
    }
    /*
    public Book getBookById(String bookid){
        String template = "select * from  bookt where bookid= '" + bookid + "'";
            //statement = connection.prepareStatement(template);
            statement = connection.createStatement();
            // Book book=  (Book) statement.executeQuery();
            results = statement.executeQuery(template);

            // Loop to next record in results, while there is a next record.
            while (results.next()) {
                // Get each field of current record (as appropriate type)
                String bookidO = results.getString("bookid");
                String category = results.getString("category");
                String bookname = results.getString("bookname");
                String authorname = results.getString("authorname");
                String publication = results.getString("publication");
                String price = results.getString("price");
                String description = results.getString("description");
                String email = results.getString("email");
                book = new Book(bookidO, category, bookname, authorname, publication, price, description, email, null);

            }
            return book;
    } */
    
    public void drop(String bookid) {
        Book b = getBook(bookid);
        books.remove(b);
    }
}
