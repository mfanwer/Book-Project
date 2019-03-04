<%-- 
    Document   : BookCart
    Created on : Nov 13, 2018, 5:19:42 PM
    Author     : Faraz Anwer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
 
       <body>
          
            <table>
            <thead>
            <th>Book Image</th>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Author Name</th>       
            <th>Price</th>
            </thead>
              <c:choose>
                <c:when test="${empty booklist or booklist.size == 0}">
                    <tr><td>Cart is empty, no books added</td></tr>
                </c:when>
            <c:otherwise>
            <c:forEach var="book" items="${booklist.books}">
                
                 <tr>
                    <td><img src="Image/${book.bookimage}" height="80" width="80" /></td>
                    <td>${book.bookid} </td>
                    <td>${book.bookname}</td>
                    <td> ${book.authorname}</td>
                     <td> $ ${book.price}</td>

                    <td>
                        <form action="DropBooksServlet">
                            <input type="submit" value="Drop Item"/>                        
                            <input type="hidden" name="bookid" 
                                   value="${book.bookid}"/>
                        </form>
                    </td>
                </tr>
                
                </c:forEach>
        
         
            </c:otherwise>
            </c:choose>
                
            <thead class="thead-light">
                <th class="text-center" colspan="3">Total Price</th>
                <td class="text-center">< value="${cart_total}" /></b></td>
                <td class="text-center"><button type="button" class="btn btn-sm btn-round-lg btn-outline-info">Checkout</button></b></td>
            </thead>
            
            </table></div>
        <div>
            <br />
            <br />
            <a href="BookCart.jsp"></a></div>
    </div>
        
   </div>
         </body>
</html>
