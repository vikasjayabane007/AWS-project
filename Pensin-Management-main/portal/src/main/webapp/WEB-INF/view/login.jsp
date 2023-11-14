
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	
	<title>Member Login</title>
	
	<style>
	
	body{
    background-image: url(images/loginbg.jpg);
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
}


.navbar-brand{
    padding-top: 15px;
    font-size: 25px;
    padding-left: 25px;
    padding-right: 5px;
}

.container-fluid{
    padding: 5px 15px;
}


.fa-hand-holding-usd , .fa-info-circle, .fa-user-plus{
/*    color: white;*/
    padding-right: 5px;
}





.loginform{
    position: absolute;
    top: 250px;
    left: 35%;
    opacity: 0.8;
    width: 30%;
    height: 300px;
    background-color: black;
    border-radius: 10px;
   
}

.formtext{
    margin-top: 20px;
    font-size: 16px;
    color: aliceblue;
    text-align: center;
     
}

.error{

color : red;
padding-left:40px;
}

.inputtext{
    color:black;
} 

.heading{
    margin: 0;
    margin-left: 10px;
    margin-top: 10px;
    position: absolute;
    font-size: 35px;
    color: orangered;
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
         </ul>
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
        </div>
    </div>
<!--Navbar ends here    -->

<!-- Login Form Starts Here-->
       <div class="loginform">
        
       <h2 class="error"> ${loginerror} </h2>
        
       <img src="" alt="">
       <form:form modelAttribute="login" action="/login" method="post">
           
           <div class="formtext"> 
           <form:label path="uid">UserId</form:label><br>    
           
           <form:input path="uid" class="inputtext"  type="text" size="20" required="required" /><br><br>
           
           <form:label path="password">Password</form:label><br>
           <form:password path="password" class="inputtext"  required="required" />
           <br><br>
           
         
           <form:button class="btn btn-default" href="">Login</form:button>
           </div>
           
       </form:form>
       
        </div>
        
<!--Login Form Ends Here	-->

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
	</script>

</body>
</html>