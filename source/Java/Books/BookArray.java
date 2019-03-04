/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

/**
 *
 * @author Faraz Anwer
 */
public class BookArray {
     Book[] books; 
    
    
   
    
    public Book[] getBooks() {
        return books;
    }
    
    public Book getBook(String bookid) {
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (bookid.equals(b.getBookid())) {
                return b;
            }
        }
        return null;
    }
   
    
}
