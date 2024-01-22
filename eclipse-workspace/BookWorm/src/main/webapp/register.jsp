<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
    <link href="css/style.css" rel="stylesheet">

</head>
<Header>
<h2>BookWorm Library</h2>
</Header>
<body>
<div class='box'>
  <div class='box-form'>
    <div class='box-login-tab'></div>
    <div class='box-login-title'>
      <div class='i i-login'></div><h2>Register</h2>
    </div>
    <div class='box-login'>
      <form class='fieldset-body' id='login_form' method='post' action='register'>
        <button onclick="openLoginInfo();" class='b b-form i i-more' title='Mais Informações'></button>
        	<p class='field'>
          <label for='fullname'>Fullname</label>
          <input type='text' id='fullname' name='fullname' title='Fullname' />
          <span id='valida' class='i i-warning'></span>
        </p>
        	<p class='field'>
          <label for='user'>E-MAIL</label>
          <input type='text' id='user' name='user' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
      	  <p class='field'>
          <label for='pass'>PASSWORD</label>
          <input type='password' id='pass' name='pass' title='Password' />
          <span id='valida' class='i i-close'></span>
        </p>

              					<div class='line-wh'></div>
          
		    <button  class='button' type="submit" >Register</button>
        	<div class='line-wh'></div>
        	
      </form>

   
    </div>
  </div>
  
</div>

</body>
</html>