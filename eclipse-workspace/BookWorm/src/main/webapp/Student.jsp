<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Student" %>
<%@ page import="dao.studentDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/styleBookP.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 class="titl-style"><i class="fas fa-user-graduate"></i> Student Management Center</h2>
<div class='container'>
<div class='box'>
  <div class='box-form'>
    <div class='box-login-tab'></div>
    <div class='box-login-title'>
      <div class='i i-login'></div><h2>Student Details</h2>
    </div>
    <div class='box-login'>
      <form class='fieldset-body' id='' method='post' action='StudentServlet'>
      
        	<p class='field'>
          <label for='fullname'>Student Id</label>
          <input type='text' id='fullname' name='studentId' title='Fullname' />
          <span id='valida' class='i i-warning'></span>
        </p>
        	<p class='field'>
          <label for='user'>Student Name</label>
          <input type='text' id='user' name='studentName' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
        <p class='field'>
          <label for='user'>Course Name</label>
          <input type='text' id='user' name='courseName' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
        <p class='field'>
          <label for='user'>Branch Name</label>
          <input type='text' id='user' name='branchName' title='Username' />
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
            <th>Student Id</th>
            <th>Name</th>
            <th>Course</th>
            <th>Branch</th>
        </tr>
    </thead>
    <tbody>
    <% 	studentDaoImpl studentImp=new studentDaoImpl(); 
        List<Student> student=studentImp.getAllStudent();
        		for (int i=0; i<student.size();i++){  %>
        <tr>
            <td><%= student.get(i).getIdStudent() %></td>
            <td><%= student.get(i).getStudentName() %></td>
            <td><%= student.get(i).getCourseName()  %></td>
            <td><%= student.get(i).getBranchName() %></td>
        </tr>
        <% } %> 
        
    </tbody>
    
</table>
</div>
</body>
</html>