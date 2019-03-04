<%-- 
    Document   : BookServlet
    Created on : Oct 28, 2018, 8:19:24 PM
    Author     : Faraz Anwer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Library</title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
     
 
       
    <center><b> Books Library </b></center></br>
        
        <table>
         
         <td><th class="text-center">Book ID</th></td>
         <td><th class="text-center">Category</th></td>
        <td><th class="text-center">Book Name</th></td>
        <td> <th class="text-center">Author Name</th></td>
        <td> <th class="text-center">Publication</th></td>
        <td>  <th class="text-center">Price</th></td>
        <td>  <th class="text-center">Description</th></td>
         <td>  <th class="text-center">Email</th></td>
          <td>  <th class="text-center">Image</th></td>

  
            
             <c:import url="BookServlet1"/> 
             
            
             <form action="BookServlet1" >
            <c:forEach var="book" items="${bookarray.books}">
                <tr>
                    
                    <td>    <td class="text-center">${book.bookid} </td></td>
                      <td>    <td class="text-center">${book.category} </td></td>
                 <td>   <td class="text-center">${book.bookname}</td></td>
                <td>    <td class="text-center">${book.authorname}</td></td>
                <td>    <td class="text-center"> ${book.publication}</td></td>
                <td>     <td class="text-center"> ${book.price}</td></td>
                  <td>    <td class="text-center">${book.description} </td></td>
                    <td>    <td class="text-center">${book.email} </td></td>
                <td>   <td class="text-center"><a href="BookDetailServlet?bookid=${book.bookid}"><img src="Image/${book.bookimage}" height="120" width="120"/></td> </td>
                <td>     <td class="text-center"><a href="BookDetailServlet?bookid=${book.bookid}"><button type="button" >Details</button></a></td>
                    
                </tr>
            </c:forEach>
        </table>
             
             </br>
             </br>
             </br>
      <a href="BookCart.jsp"><img src="Image/cart.jpg"  height="65" width="65"></a>
      
      <c:if test="${add_success != null}">
                <div class="alert alert-success float-left" role="alert">
                <div class="success text-center">Successfully Added:</div>
                <div class="success text-center"><b>${add_success}</b></div>
                </div>
           </c:if>  
          
    </body>
</html>

                