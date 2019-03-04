/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;
import java.sql.*;

/**
 *
 * @author user
 */
public class BookValidation {
     public static boolean validateId(String bookid, BookErrorList errors)
    {
       if ("".equals(bookid.trim()))
       {
           errors.setIdMissing(true);
           return false;
       }
       
       String numRegEx = "A\\d\\d\\d";
       bookid = bookid.trim();
       if (!bookid.matches(numRegEx)){
           errors.setIdIllegal(true);
           return false;
       }
       else
       {
           return true;
       }
    }
    
    
    
     public static boolean validateBookName(String bookname, 
                                       BookErrorList errors) {
        if ("".equals(bookname.trim())) {
            errors.setBooknameMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
     
     public static boolean validateAuthorName(String authorname, 
                                       BookErrorList errors) {
        if ("".equals(authorname.trim())) {
            errors.setAuthornameMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
     
     
     
     public static boolean validatePublication(String publication, 
                                       BookErrorList errors) {
        if ("".equals(publication.trim())) {
            errors.setPublicationMissing(true);
            return false;
        }
        else {
            return true;
        }
         }
     
     
      public static boolean validateCategory(String category, 
                                         BookErrorList errors) {
        if (category == null || category.equals("Default")) {
            errors.setCategoryMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
     
      public static boolean validatePrice(String price, 
                                       BookErrorList errors) {
        if ("".equals(price.trim())) {
            errors.setPriceMissing(true);
            return false;
        }
        else {
           
            try{
             int price1 = Integer.parseInt(price.trim());
             if (price1 < 0) {
                    errors.setPriceNotNumeric(true);
                    return false;
                }
            }
            catch (NumberFormatException ex) {
                errors.setPriceNotNumeric(true);
                return false;
            }
            return true;
        }
    }
      
       public static boolean validateDescription(String description, 
                                       BookErrorList errors) {
        if ("".equals(description.trim())) {
            errors.setDescriptionMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
       
       
       public static boolean validateEmail(String email, 
                                       BookErrorList errors) {
        if ("".equals(email.trim())) {
            errors.setEmailMissing(true);
            return false;
        }

        
        String numRegEx = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        email = email.trim();
        if (!email.matches(numRegEx)) {
            errors.setEmailIllegal(true);
            return false;
            }
        else {
            return true;
        }
    }
       
       
        public static boolean validateBookUnique(String bookid, BookErrorList errors) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        boolean alreadyExists = false;
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
            // Ceate parameterized query for existing course
            String template = "select * from Books "
                    + "where id = ?";
            statement = connection.prepareStatement(template);
            
            // Insert prefix and number of proposed course into query and perform
            statement.setString(1, bookid);           
            results = statement.executeQuery();
            
            // If next returns true, some existing record has same prefix and number
            alreadyExists = results.next();
        }     
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        if (alreadyExists) {
            // If so, the related error is set to true, and false that all input is valid
            errors.setBookAlreadyExists(true);  
            return false;            
        }
        else {
           return true;
        }
    } 
       
       
   
}

