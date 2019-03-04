/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Books.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Faraz Anwer
 */
public class BookDetailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookid = request.getParameter("bookid");
        HttpSession session = request.getSession();

        BookList books = (BookList) session.getAttribute("bookarray");
      Book book=null;
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        try {

            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Books", "app", "app");
            //connection = DriverManager.getConnection(urlString, "root", "xyzzy1234");
        } catch (SQLException ex) {
            System.out.println("Connection failed!");
        } catch (Exception ex) {
            System.out.println("No Driver");

        }
  
        try {
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
        } catch (Exception ex) {
            System.out.println(ex);

        }
        session.setAttribute("currentbook", book);
        getServletContext().getRequestDispatcher("/BookDetail.jsp").forward(request, response);

    //    Book book = books.getBook(bookid);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
