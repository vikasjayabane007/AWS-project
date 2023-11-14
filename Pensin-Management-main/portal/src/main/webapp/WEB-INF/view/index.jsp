<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style1.css" class="css">
	<title>Member Login</title>

	<style>
	
	body{
    background-image: url(images/loginbg.jpg);
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
}

.loginheading{
    color: aliceblue;
    margin-left: 250px;
    margin-top:  280px;
    font-size: 55px;
}
/*

.container{
    margin: 0px;
}
*/

.btn{
    
    margin-top: 20px;
    margin-left: 45%;
    width: 11%;
    height: 40px;
    border-radius: 10px;
    font-size: 20px;
    background-color: white;
}
	
	
	</style>

</head>

<body>

	<div class="container">
	
        <h1 class="loginheading">Pension Management Portal</h1>
        <a class="btn btn-default" href="/login">Login</a>
        
        
	
	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
	</script>

</body>

</html>
