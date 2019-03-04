<%-- 
    Document   : BookDetail
    Created on : Nov 13, 2018, 1:28:29 PM
    Author     : Faraz Anwer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Details</title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
     
    <body>
        <div class="container-fluid">
            
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <br /> 
            <h1 class="display-4 text-center" >Books Library</h1>
            <h2 class="display-6 text-center">Books Description </h2>
            <hr />
            <a href="ViewBook.jsp"><button type="button" > Back</button></a><br>
            <div class="row">   
            <div class="col-sm-6 text-center">
                <br /><br />
                <img src="Image/${currentbook.bookimage}"  height="350" width="350">
                <form action="AddBookServlet">
                    <input type="submit"  value="Add to Cart"/>                        
                    <input type="hidden" name="bookid" value="${currentbook.bookid}"/>
                </form>
            </div>
            <div class="col-sm-6">
                
            <table class="table table-borderless float-left">
                <tr>
                    <td><h2 class="display-4">${currentbook.bookname}</h2></td>
                </tr>
                <tr>
                  <td><h3 class="display-5">Price: $ ${currentbook.price}</h3></td>
                </tr>  
               
                <tr>
                  
                    <td><hr><p class="text-justify font-weight-light    ">${currentbook.description}</p></td>
                </tr>
            </table>
            </div>
            </div>
           </div>
                <div class="col-sm-2">
                    <br />
                    <br />
                    <a href="BookCart.jsp"><img src="Image/cart.jpg" height="65" width="65"</a>
                </div>
    </div>
        
   </div>
    </body>
</html>
