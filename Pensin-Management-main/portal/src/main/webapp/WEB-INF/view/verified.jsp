<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<title>Pensioner Details</title>

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
  margin-left: 170px;

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
 
<!--    Pensioner Details Form Starts Here-->

    <div class="pension-form">
  
  <form action="/disburse" method="post" >
  
   <span> <label>Pensioner's Name</label><input type="text" placeholder="Enter Pensioner's Name" value=${name}  readonly></span>

  <span>  <label>Date Of Birth</label><input  type="text" placeholder="Enter your D.O.B" value=${dob} readonly></span>

  <span>  <label>Pan Card Number</label><input  type="text"  placeholder="Enter your PanCard Number"  value=${pan} readonly></span>

  <span>  <label>Aadhaar Number</label><input   type="text" placeholder="Enter your AadharCard Number" value=${aadharno} length="12" readonly ><br></span>
   
    <span><label>Pension Type</label><input   type="text" placeholder="Pension Type"  value=${pensionType} readonly></span>

	 <span><label>Amount</label>   <input   type="text"  placeholder="Pension Amount" value=${pensionAmount}  readonly></span>

	<input   type="text"  placeholder="Pension Amount" name="aadhaar" value=${aadharno}  hidden >
	<input   type="text"  placeholder="Pension Amount" name="amount" value=${pensionAmount}  hidden>

<input type="submit" class="btn btn-submit" value="link For Disbursement" />

   <!-- <a  href="/disburse" class="btn btn-submit">Link for disbursement</a> -->
   
   <!-- <a href="/disburse" class="btn btn-submit"  onClick="document.getElementById('form1').submit();">Link for disbursement</a> -->
   
   </form>
  </div>
        
                
<!--    Pensioner Details Form Ends Here-->
    



</body>

</html>











</html>