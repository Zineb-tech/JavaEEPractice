<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Model.Users" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="css/styleHomePage.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

</head>
<body>
<div class="wrapper">

        <div class="sidebar">
           <!--profile  text-->
           <div class="profile">
                
               <%   
                //String name=request.getParameter("fullname");  
               // out.print("<h3> welcome " + name + "</h3>");*/
               HttpSession Obj=request.getSession();
               String name=(String) Obj.getAttribute("user");
               out.print("<h3> welcome " + name + "</h3>");
            %>  
            </div>
            <!--menu item-->
            
            <ul>
                <li>
                    <a href="#" class="active">
                        <span class="icon"><i class="fas fa-home"></i></span>
                        <span class="item">Home</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="icon"><i class="fas fa-desktop"></i></span>
                        <span class="item">My Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="Book.jsp">
                        <span class="icon"><i class="fas fa-user-friends"></i></span>
                        <span class="item">Manage book</span>
                    </a>
                </li>
                <li>
                    <a href="Student.jsp">
                        <span class="icon"><i class="fas fa-tachometer-alt"></i></span>
                        <span class="item">Manage students</span>
                    </a>
                </li>
                <li>
                    <a href="Issue.jsp">
                        <span class="icon"><i class="fas fa-database"></i></span>
                        <span class="item">Issue book</span>
                    </a>
                </li>
                <li>
                    <a href="returnBook.jsp">
                        <span class="icon"><i class="fas fa-chart-line"></i></span>
                        <span class="item">Return book</span>
                    </a>
                </li>
                <li>
                    <a href="loanBook.jsp">
                        <span class="icon"><i class="fas fa-chart-line"></i></span>
                        <span class="item">Loan book</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="icon"><i class="fas fa-user-shield"></i></span>
                        <span class="item">View Records</span>
                    </a>
                </li>
                <li>
                    <a href="viewIssued.jsp">
                        <span class="icon"><i class="fas fa-cog"></i></span>
                        <span class="item">View Issued</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="icon"><i class="fas fa-cog"></i></span>
                        <span class="item">Defaulter list</span>
                    </a>
                </li>
                <li>
                    <a href="LogOut">
                        <span class="icon"><i class="fas fa-cog"></i></span>
                        <span class="item">Logout</span>
                    </a>
                </li>
            </ul>
        </div>
		<div class="section">
		            <div class="top_navbar">
		                <div class="hamburger">
		                <a href="#">        
		                 <i class="fas fa-bars"></i>	
		                </a>
		                </div>
		                <h4>Library Management System</h4>	                    
		                
		            </div>
		             
		        </div>
</div>
        <!--Top menu -->
        
        
<script>
       var hamburger = document.querySelector(".hamburger");
	hamburger.addEventListener("click", function(){
		document.querySelector("body").classList.toggle("active");
	})
  </script>        


</body>

</html>