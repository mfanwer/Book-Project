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
public class Book {
    private String bookid = "";
    private String category = "";
    private String bookname = "";
    private String authorname = "";
    private String publication = "";
    private String price ="";
    private String description = "";
    private String email = "";
      private String bookimage = "";
    
    
    
    public Book(String bookid, String category,  String bookname, String authorname, String publication,  String price, String description, String email, String bookimage) {
        
        this.bookid=bookid;
        this.category=category;
        this.bookimage = bookimage;
        this.bookname = bookname;
        this.authorname = authorname;
        this.publication = publication;
        this.price = price;
        this.description = description;
        this.email = email;
    }  

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

}