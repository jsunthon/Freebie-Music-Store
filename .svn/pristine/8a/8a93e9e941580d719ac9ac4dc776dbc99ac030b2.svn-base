<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Freebie Music Store - Profile</title>

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
   <!-- --------- NAV: HEADER --------- -->
   <jsp:include page="MasterHeader.jsp" />
   <!-- ------------------------------ -->


   <!-- ############################### -->
   <!-- --------- NAV: SIDE ----------- -->
   <jsp:include page="MasterSideBar.jsp" />
   <!-- ------------------------------- -->

   <!-- ################################################################################ -->
   <!-- -------------------------- MAIN CONTENT ---------------------------------------- -->

   <section class="row">

      <div class="col-md-6 col-md-offset-1" id="main-content">
    
            <h1 class="page-header">Insert a New Record</h1>
            <div class="well">
               <form:form modelAttribute="newAlbum">
                  <fieldset>

                     <!-- artist field -->
                     <div class="form-group">
                        <label for="artistid" class="col-md-2">Artist</label>
                        <div class="col-md-10">
                           <select class="form-control" name="artistid">
                              <c:forEach items="${artists}" var="artist">
                                 <option value="${artist.id}">${artist.name}</option>
                              </c:forEach>
                           </select>
                        </div>
                     </div>

                     <!-- album field -->
                     <div class="form-group">
                        <label for="album" class="col-md-2">Album</label>
                        <div class="col-md-10">
                           <form:input type="text" class="form-control" id="album"
                              path="name" placeholder="Album" />
                        </div>
                     </div>

                     <!-- genre field -->
                     <div class="form-group">
                        <label for="genre" class="col-md-2">Genre</label>
                        <div class="col-md-10">
                           <form:select class="form-control" path="genre">
                              <c:forEach items="${masterGenreList}" var="genre">
                                 <option value="${genre}">${genre}</option>
                              </c:forEach>
                           </form:select>
                        </div>
                     </div>

                     <!-- track field -->
                     <div class="form-group">
                        <label class="col-md-2">Tracks</label>
                        <div class="col-md-10">
                           <c:forEach begin="1" end="4" varStatus="i">
                              <input type="text" class="form-control"
                                 name="track${i.index}"
                                 placeholder="Track ${i.index}">
                           </c:forEach>
                        </div>
                     </div>

                     <!-- image field -->
                     <div class="form-group">
                        <label for="image" class="col-md-2">Image</label>
                        <div class="col-md-5">
                           <form:select class="form-control text-center"
                              path="imgSrc">
                              <c:forEach items="${images}" var="image" varStatus="i">
                                 <option value="${image}">default image
                                    #${i.index+1}</option>
                              </c:forEach>
                           </form:select>

                        </div>
                     </div>

                     <!-- submit field -->
                     <div class="form-group">
                        <div class="col-md-5 col-md-offset-2">
                           <button type="submit" class="btn btn-primary">Submit</button>
                           <a href="HomePage" class="btn btn-danger">Cancel</a>
                        </div>
                     </div>

                  </fieldset>
               </form:form>
            </div>
         </div>
   </section>
   <!--------------------------------------------------------------------------------------->

   <!-- ############################### -->
   <!------------ FOOTER -------------- -->
   <jsp:include page="MasterFooter.jsp" />
   <!--------------------------------- -->


   <!--#################################################-->
   <!---------------- JAVASCRIPT ------------------------->
   <script src="Scripts/jquery-1.10.2.min.js"></script>
   <script src="Scripts/bootstrap.min.js"></script>
   <!---------------------------------------------------->
</body>
</html>