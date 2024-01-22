<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Issue" %>
<%@ page import="Model.Books" %>
<%@ page import="Model.Student" %>
<%@ page import="Model.Issue" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.issueDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link href="css/styleIssue.css" rel="stylesheet">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 class="titl-style"><i class="fas  fa-check"></i> Library Book Check-Out</h2>


<div class='container'>
  <div class='box-form'>
    <div class='box-login-tab'></div>
    <div class='box-login'>

          
        	<div class='line-wh'></div>
        	
      

<%
    Student student = (Student) request.getAttribute("student");
    Books book = (Books) request.getAttribute("book");
%>

 <!-- Display Student Details -->
            <div>
                <h3>Student Details</h3>
                <% if (student != null) { %>
                    <p>Student ID: <%= student.getIdStudent() %></p>
                    <p>Student Name: <%= student.getStudentName() %></p>
                    <p>Course Name: <%= student.getCourseName() %></p>
                    <p>Branch Name: <%= student.getBranchName() %></p>
                <% } else { %>
                    <p>No student details available</p>
                <% } %>
            </div>

            <!-- Display Book Details -->
            

   
    </div>
      <div class='box-login-2'>
      <div>
                <h3>Book Details</h3>
                <% if (book != null) { %>
                    <p>Book ID: <%= book.getBookId() %></p>
                    <p>Book Name: <%= book.getBookName() %></p>
                    <p>Author Name: <%= book.getAuthorName() %></p>
                    <p>Quantity: <%= book.getQuantity() %></p>
                <% } else { %>
                    <p>No book details available</p>
                <% } %>
            </div>
    </div>
        <div class='box-login-3'>
      <form class='fieldset-body' id='' method='post' action='IssueServlet'>
            <div class='i i-login'></div><h2><i class="fas fa-book"></i> Issue Book</h2>
      
        	<p class='field'>
          <label for='fullname'>Book Id</label>
          <input type='text' id='fullname' name='idBook' title='Fullname' />
          <span id='valida' class='i i-warning'></span>
        </p>
        	<p class='field'>
          <label for='user'>Student Id</label>
          <input type='text' id='user' name='idStudent' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
        <p class='field'>
          <label for='user'>Issue Date</label>
          <input type='text' id='user' name='issueDate' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
        <p class='field'>
          <label for='user'>Due Date</label>
          <input type='text' id='user' name='dueDate' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
       
      	 
              					<div class='line-wh'></div>
          
		    <button  class='button' type="submit" >Issue Book</button>
		   
        	<div class='line-wh'></div>
        	
      </form>

   
    </div>
  
  </div>
  

	
</div>

</body>
</html>