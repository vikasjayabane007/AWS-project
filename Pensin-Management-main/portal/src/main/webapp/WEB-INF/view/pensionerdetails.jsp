<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
 <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	
	<title>Minimum Bootstrap HTML Skeleton</title>
	<style>
	body{
    background-image: url(images/money.jpg);
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    
	}



.container-fluid{
    padding: 0px 15px;
}


.fa-hand-holding-usd , .fa-info-circle, .fa-user-plus{
/*    color: white;*/
    padding-right: 5px;
}


/* Pensioner Details Form Styling*/

.pension-form{
    width: 40%;
    margin-top: 2%;
    margin-left: 15%;
    
     border-radius: 5px;
  background-color: lightgray;
  padding: 20px;
}

input, select {
  width: 100%;
  padding: 6px 16px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

  .btn-submit{
  width: 35%;
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  margin-top: 30px;
  margin-left:80px;
  margin-left:autol

  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-reset:hover {
  background-color: white;
}

.btn-reset{
  width: 35%;
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  margin-top: 30px;
  margin-left: 0px;

  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-submit:hover {
  background-color: white;
}

label {
    /* Other styling... */
   
    float:left;
}

span { 
    margin: 0px;
            display: block; 
            overflow: hidden; 
            padding: 0px 0px 0px 0px; 
        } 

.self{
    padding-right: 18px;
}
	
.error{
		
	color:black;
	text-align:center;		
	font-size: 25px;
}
	
	
	</style>


</head>
 
 <body>
 
 
        <!--   Navbar starts here-->
    <div id="navbar" class="navbar-wrapper">
        <div class="container">
            <nav class="navbar navbar-inverse navbar-transparent">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header " >
       
        <a  class="navbar-brand " href="#"><i class="fas fa fa-hand-holding-usd"></i>Pension Management Portal</a>
        
        <!--<i class="fa fas fa-home fa-lg"></i>-->
        
        </div>

       
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><i class="fas fa fa-info-circle"></i>About</a></li>
        <li><a href="/logout">
          <i class="fa fa-user-plus  "></i>Logout</a>
        </li>
       
        </ul>
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
        </div>
    </div>
<!--Navbar ends here    -->

<div class="pension-form">

	
  	<form:form action="/submitinfo" method="post" modelAttribute="pensionerInput">
  	
  	<h2 class="error" > ${invaliddetails}</h2> 
  	<label for="name">Pensioner's Name</label>
    <form:input path="name" type="text" placeholder="Enter Pensioner's Name" required="required"/>

    <label for="dateOfBirth">Date Of Birth</label>
    <form:input  path="dateOfBirth" type="date" placeholder="Enter your D.O.B" required="required"/>
 
 
 	<label for="pan">PAN Number</label>
    <form:input  path="pan" type="text"  placeholder="Enter your PanCard Number"  pattern="[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}" title="Please enter valid PAN number. E.g. AAAAA9999A" required="required"/>

    <label for="aadhar">Aadhaar Number</label>
    <form:input  path="aadharNumber" type="text" placeholder="Enter your AadharCard Number" pattern="^[2-9]{1}[0-9]{11}$"  length="12"  required="required"/><br>
  
   <label for="selfPension" class="self">Self Pension</label>
   <span> <form:radiobutton path="pensionType"  value="self" required="" /> </span><br>

   <label for="familyPension">Family Pension</label>
   <span><form:radiobutton path="pensionType"  value="family" required="" /> </span>
          
     <button type="submit" class="btn btn-submit" >Submit</button>
     <!-- <input type="reset" class="btn btn-reset" value = "Reset"> -->

</form:form>
  </div>
  
  
  <script>
  
  
  
  </script>
  
  </body>

</html>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  </body>
</html>