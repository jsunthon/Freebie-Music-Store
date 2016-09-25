<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Freebie Music Store - Register</title>

<!--##################################################### -->
<!--------------------- Styling ---------------------------->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link href="Content/footer-distributed-with-address-and-phones.css" rel="stylesheet" />
<link href="Content/bootstrap.css" rel="stylesheet" />
<link href="Content/add_styling.css" rel="stylesheet" />
<link href="Content/animate.css" rel="stylesheet" />
<!--------------------- Styling ---------------------------->

</head>
<body class="container-fluid">

   <!-- ############################### -->
   <!------------ Page Header ----------->
   <jsp:include page="MasterHeader.jsp" />
   <!------------------------------------>


   <!-- ################################-->
   <!------------ Side Bar --------------->
   <jsp:include page="MasterSideBar.jsp" />
   <!------------------------------------->


   <!-- ############################################################################-->
   <!--------------------------  Main Content ---------------------------------------->
   <section class="row">
      <div class="col-md-offset-2 col-md-6" id="main-content">
       
            <div class="animated bounceInUp">
               <br /> <br />
               <div class="well text-center">

                  <h1>Register</h1>
                  <hr />
                  <p class="lead">You're on your way.</p>   
                  
                  <!-- form: begin -->
                  <form:form modelAttribute="user">

                     <!-- input: first name -->
                     <div class="form-group">
                        <div class="input-group">
                           <div class="input-group-addon">
                              <i class="fa fa-user-secret"></i>
                           </div>
                           <form:input class="form-control" type="text"
                              path="firstName" placeholder="Enter your first name" />
                           <form:errors path="firstName" class="alert-danger"
                              role="alert" />
                        </div>
                     </div>
                     
                     <!-- input: last name -->
                     <div class="form-group">
                        <div class="input-group">
                           <div class="input-group-addon">
                              <i class="fa fa-user-secret"></i>
                           </div>
                           <form:input class="form-control" type="text"
                              path="lastName" placeholder="Enter your last name" />
                           <form:errors path="lastName" class="alert-danger"
                              role="alert" />
                        </div>
                     </div>

                     <!-- input: state -->
                     <div class="form-group">
                        <div class="input-group">
                           <div class="input-group-addon">
                              <i class="fa fa-user"></i>
                           </div>
                           <form:select class="form-control " path="state"
                              items="${states}" />
                        </div>
                     </div>
                     
                     <!-- input: email -->
                     <div class="form-group">
                        <div class="input-group">
                           <div class="input-group-addon">
                              <i class="fa fa-user"></i>
                           </div>
                           <form:input class="form-control" type="text" path="email"
                              placeholder="Enter your email" />
                           <form:errors path="email" class="alert-danger"
                              role="alert" />
                        </div>
                     </div>
                     
                     <!-- input: password #1 -->
                     <div class="form-group">
                        <div class="input-group">
                           <div class="input-group-addon">
                              <i class="fa fa-lock"></i>
                           </div>
                           <form:input class="form-control" type="password"
                              path="password" placeholder="Create your password" />
                           <form:errors path="password" class="alert-danger"
                              role="alert" />
                        </div>
                     </div>
                     
                     <!-- input: password #2 -->
                     <div class="form-group">
                        <div class="input-group">
                           <div class="input-group-addon">
                              <i class="fa fa-lock"></i>
                           </div>
                           <input class="form-control" type="password"
                              name="confirm-password"
                              placeholder="Confirm your password" />
                        </div>
                     </div>

                     <input type="submit" class="btn btn-info btn-block btn-md"
                        value="Register" />
                  </form:form>
               </div>
            </div>
         </div>
 
   </section>
   <!--  -->

   <!--##############################-->
   <!----------- FOOTER --------------->
   <jsp:include page="MasterFooter.jsp" />
   <!---------------------------------->

   <!--#################################################-->
   <!---------------- JAVASCRIPT ------------------------->
   <script src="Scripts/jquery-1.10.2.min.js"></script>
   <script src="Scripts/bootstrap.min.js"></script>
   <!---------------- JAVASCRIPT ------------------------>

</body>


</html>