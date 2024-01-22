<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Model.Books" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.bookDaoImpl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styleBookP.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<title>Insert title here</title>
</head>
<body>
<h2 class="titl-style"><i class="fas fa-book"></i> Book Management Hub</h2>
<div class='container'>
<div class='box'>
  <div class='box-form'>
    <div class='box-login-tab'></div>
    <div class='box-login-title'>
      <div class='i i-login'></div><h2>Book Details</h2>
    </div>
    <div class='box-login'>
      <form class='fieldset-body' id='' method='post' action='BookServlet'>
      
        	<p class='field'>
          <label for='fullname'>Book Id</label>
          <input type='text' id='fullname' name='idBook' title='Fullname' />
          <span id='valida' class='i i-warning'></span>
        </p>
        	<p class='field'>
          <label for='user'>Book Name</label>
          <input type='text' id='user' name='bookName' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
        <p class='field'>
          <label for='user'>Author Name</label>
          <input type='text' id='user' name='authorName' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
        <p class='field'>
          <label for='user'>Quantity</label>
          <input type='text' id='user' name='quantity' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
       
      	 

              					<div class='line-wh'></div>
          
		    <button  class='button' type="submit" >Add</button>
		    <button  class='button' type="submit" >Update</button>
		    <button  class='button' type="submit" >Remove</button>
        	<div class='line-wh'></div>
        	
      </form>

   
    </div>
  </div>
  
</div>
   

	<table class="styled-table">
    <thead>
        <tr>
            <th>Book Id</th>
            <th>Name</th>
            <th>Author</th>
            <th>Quantity</th>
            <th>Available</th>
        </tr>
    </thead>
     <% 				bookDaoImpl bookDaoimp= new bookDaoImpl();

    				List<Books> books = bookDaoimp.getAllBooks();
  				for (int i=0; i<books.size();i++){

    %>
   <tbody>
    
                <tr>
                    <td><%= books.get(i).getBookId() %></td>
                    <td><%= books.get(i).getBookName() %></td>
                    <td><%= books.get(i).getAuthorName() %></td>
                    <td><%= books.get(i).getQuantity() %></td>
                    <td><%= books.get(i).isAvailable()?"yes":"No" %></td>
                </tr>
           
        
    </tbody>
    <% 
				}
			%>
</table>
</div>


</body>
</html>
