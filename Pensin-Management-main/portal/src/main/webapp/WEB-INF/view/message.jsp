<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/verified.css" class="css">
	<title>Minimum Bootstrap HTML Skeleton</title>

	<!--  -->
<style>
    body{
    background-image: url(../images/money.jpg);
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
        <li><a href="/logout"><i class="fa fa-user-plus  "></i>Logout</a>
        </li>
       
        </ul>
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
        </div>
    </div>
	<!--Navbar ends here    -->
	<div class="pension-form">
  
         <h1>${message}</h1>
	</div>
        
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
	</script>

</body>

</html>