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

import java.sql.*;

/**
 *
 * @author Faraz Anwer
 */
public class ValidateBookServlet extends HttpServlet {

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
       HttpSession session = request.getSession();
       String  nextPage = "/BookDetail.jsp";
            
       String bookid = request.getParameter("bookid");
       String category = request.getParameter("category");
       String bookname = request.getParameter("bookname");
       String authorname = request.getParameter("authorname");
       String publication = request.getParameter("publication");
       String price = request.getParameter("price");
       String description = request.getParameter("description");
       String email = request.getParameter("email");
       String bookimage = "A.PNG";
       
       
       BookErrorList errors = new BookErrorList();
       
        boolean isIdValid = BookValidation.validateId(bookid, errors);
        boolean isCategoryValid = BookValidation.validateCategory(category, errors);
        boolean isBookNameValid = BookValidation.validateBookName(bookname, errors);
        boolean isAuthorNameValid = BookValidation.validateAuthorName(authorname, errors);
        boolean isPublicationValid = BookValidation.validatePublication(publication, errors);
        boolean isPriceValid = BookValidation.validatePrice(price, errors);
        boolean isDescriptionValid = BookValidation.validateDescription(description, errors);
        boolean isEmailValid = BookValidation.validateEmail(email, errors);
       
    
    if (isIdValid && isCategoryValid && isBookNameValid && isAuthorNameValid && isPublicationValid && isPriceValid && isDescriptionValid && isEmailValid) {
        
            
         Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            
              // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Books", "app", "app");
            //connection = DriverManager.getConnection(urlString, "root", "xyzzy1234");
        }
        
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No Driver");
            
        }
        
        try {
                String template = "Insert into bookt "
                                    + "(bookid, category, bookname, authorname, publication, price, description, email)"
                                    + "values (?, ?, ?, ?, ?,?,?,?)";
                 statement = connection.prepareStatement(template);
            statement.setString(1, bookid);
            statement.setString(2, category);
            statement.setString(3, bookname);
            statement.setString(4, authorname);
            statement.setString(5, publication);
            statement.setInt(6, Integer.parseInt(price));
            statement.setString(7, description);
            statement.setString(8, email);
            int changed = statement.executeUpdate();
            System.out.println(changed+" records added");
        }
         catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        request.setAttribute("add_success", bookname);
        
            BookList books = new BookList();
            books.loadBooks();
            session.setAttribute("bookarray", books);   
            
            getServletContext().getRequestDispatcher(nextPage).forward(request, response);
            }
    
    else {
            nextPage = "/AddBook.jsp";
          
            // Add the validation object to the session for use by the JSP
            request.setAttribute("errors", errors);
        }
        
        
        getServletContext().getRequestDispatcher(nextPage).forward(request, response);
        
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
