<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrow Book</title>
</head>
<body>

    <form action="BorrowServlet" method="post">
        Book ID: <input type="text" name="bookId">
        Student ID: <input type="text" name="studentId">
        <input type="submit" value="Borrow">
    </form>


</body>
</html>