<%-- 
    Document   : AddBook
    Created on : Dec 1, 2018, 7:49:03 PM
    Author     : Faraz Anwer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Inventory</title>
          
    </head>
   
    <body>   
        
        <c:import url="BookServlet1"/>
            <h1 class="display-4 text-center" >Book Shop</h1>
            <h2 class="display-6 text-center">Add New Book</h2>
            <hr />
             <a href="ViewBook.jsp"><button type="button" class="btn btn-sm btn-round-lg"> Back</button></a>
             
            
             <form action="ValidateBookServlet" >
                 
                 
                  <div class="form-group row">
      <label for="inputId" class="col-sm-4 col-form-label text-right">Book Id :</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="inputId" name="bookid" placeholder="Book id (AXXX)" value="${param.bookid}">
      </div>
      <div class="col-sm-4">
           <c:if test="${errors.idMissing}">
        <div class="alert alert-danger" role="alert">
            <p> * Book Id is mandatory</p>
        </div>
           </c:if>
           <c:if test="${errors.idIllegal}">
        <div class="alert alert-danger" role="alert">
            <p> * Error in format of ID</p>
        </div>
           </c:if>
          </div>
    </div>
      
      
      <div class="form-group row">
      <label for="inputCategory" >Genre:</label>
      <div class="col-sm-4">
      <select name="category" id="inputCategory" placeholder="Genre" >
         <option value="Default">Choose the book genre</option>
         <option value="Fiction" <c:if test="${param.category == 'Fiction'}">selected="true"</c:if> >Fiction</option>
         <option value="Thriller" <c:if test="${param.category == 'Thriller'}">selected="true"</c:if> >Thriller</option>
         <option value="Non-Fiction" <c:if test="${param.category == 'Non-Fiction'}">selected="true"</c:if> >Non-Fiction</option>
      </select>
      </div>
       <div class="col-sm-4">
      <c:if test="${errors.categoryMissing}">
            <p > * Choose one category.</p>  
        </div>
        </c:if>
      </div>
    </div>
      
      
      
      
    
      <div class="form-group row">
      <label for="inputName" >Book Name :</label>
      <div class="col-sm-4">
        <input type="text" name="bookname" class="form-control" id="inputName" placeholder="Book name" value="${param.bookname}">
      </div>
       <div class="col-sm-4">
       <c:if test="${errors.booknameMissing}">
          <p > *Book's Name is mandatory.</p>  
</div>
      </c:if>
          </div>
      
      
      <div class="form-group row">
      <label for="inputName" >Author Name :</label>
      <div class="col-sm-4">
        <input type="text" name="authorname" class="form-control" id="inputName" placeholder="Author name" value="${param.authorname}">
      </div>
       <div class="col-sm-4">
       <c:if test="${errors.authornameMissing}">
          <p > *Author's Name is mandatory.</p>  
</div>
      </c:if>
          </div>
      
      
      <div class="form-group row">
      <label for="inputName" >Publisher:</label>
      <div class="col-sm-4">
        <input type="text" name="publication" class="form-control" id="inputName" placeholder="Publication name" value="${param.publication}">
      </div>
       <div class="col-sm-4">
       <c:if test="${errors.publicationMissing}">
          <p > *Publication Name is mandatory.</p>  
</div>
      </c:if>
          </div>
      
      
      <div class="form-group row">
      <label for="inputPrice" class="col-sm-4 col-form-label text-right">Price :</label>
      <div class="col-sm-4">
          <div class="input-group">
          <div class="input-group-prepend">
          <div class="input-group-text">$</div>
        </div>
              
        <input type="text" name="price" class="form-control" id="inputPrice" placeholder="Book's Price" value="${param.price}">
      </div>
          </div>
       <div class="col-sm-4">
           <c:if test="${errors.priceMissing}">
      <div class="alert alert-danger" role="alert">
          <p > * Book Price must be entered.</p>  
</div>
           </c:if> 
           <c:if test="${errors.priceNotNumeric}">
      <div class="alert alert-danger" role="alert">
          <p > * Please enter numeric values for Price.</p>  
</div>
           </c:if> 
          </div>
    </div>
      
       <div class="form-group row">
      <label for="inputName" >Description:</label>
      <div class="col-sm-4">
        <input type="text" name="description" class="form-control" id="inputName" placeholder="Book Info" value="${param.description}">
      </div>
       <div class="col-sm-4">
       <c:if test="${errors.descriptionMissing}">
          <p > *Book's Info is mandatory.</p>  
</div>
      </c:if>
          </div>
      
      
      
   
      
      <div class="form-group row">
           <label for="inputEmail" >Contact Email:</label>
     <div class="col-sm-4">
        <input type="text" name="email" class="form-control" id="inputEmail" placeholder="Contact email" value="${param.email}">
      </div>
       <div class="col-sm-4">
            <c:if test="${errors.emailMissing}">
          <p> * Contact email must be entered.</p>  
</div>
            </c:if>
            <c:if test="${errors.emailIllegal}">
      
          <p> * The format is wrong, please enter in the valid email format</p>  

            </c:if>
         </div>
      
      <div class="form-group row">
      <label for="inputImage" class="col-sm-4 col-form-label text-right">Book Image:</label>
      <div class="col-sm-8">
        <input type="file" name="bookimage" id="inputImage" />
         
      </div>
    </div>
    
      
      
      
       
      
      
       <div class="form-group row">
          <div class="col-sm-4"></div>
        <div class="col-sm-6 control-label">
           <input type="submit" class="btn btn-md btn-round-lg btn-info" id="submit" name="submit" value="Add Book" /><br><br>
        </div>
          <div class="col-sm-2"></div>
        </div>
      
      
      
        </form>
                        
            
             
               
    </body>        
            
        
      
    
</html>
