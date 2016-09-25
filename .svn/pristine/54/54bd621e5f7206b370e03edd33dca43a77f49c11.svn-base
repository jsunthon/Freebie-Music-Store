<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Freebie Music Store - Uploads</title>

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
      <div class="col-md-8 col-md-offset-1 cols" id="main-content">
         <h1 class="page-header">Music From Users Like You</h1>
         <div class="well">
            <table class="table table-striped table-hover">
               <tr>
                  <th>Index</th>
                  <th>ID</th>
                  <th>Name</th>
                  <th><a href="#">From User</a>
               </tr>

               <c:forEach items="${uploads}" var="uploadTrack" varStatus="i">
                  <tr class="success">
                     <th>${i.index + 1}</th>
                     <td>${uploadTrack.id }</td>
                     <td><a
                        href="downloadUploadedTrack.html?uploadID=${uploadTrack.id}">${uploadTrack.name}</a></td>
                     <td><a href="profileView.html?id=${uploadTrack.user.id}">${uploadTrack.user.email}</a></td>
                  </tr>
               </c:forEach>
            </table>

            <br /> <a href="home.html"> <i class="fa fa-chevron-circle-left"></i>
               &nbsp;&nbsp;&nbsp;Home
            </a>
         </div>
      </div>
   </section>
   <!-- ---------------------------------------------------------------------------------- -->

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