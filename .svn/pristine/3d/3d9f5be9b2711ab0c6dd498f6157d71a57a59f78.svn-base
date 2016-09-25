<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Freebie Music Store - Genres</title>

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
   <!------------ PAGE HEADER ----------->
   <jsp:include page="MasterHeader.jsp" />
   <!------------ PAGE HEADER ----------->


   <!-- ################################-->
   <!------------ NAV: SIDE --------------->
   <jsp:include page="MasterSideBar.jsp" />
   <!-------------------------------------->

   <!--############################################################################-->
   <!-------------------- MAIN CONTENT  --------------------------------------------->
   <div class="row">

      <div class="col-md-8 col-md-offset-1" id="main-content">
         <div class="col-md-4">
            <h1 class="page-header">Genres</h1>
            <div class="well list-group">

               <!-- Display all genres of the left most -->
               <c:forEach items="${listOfGenres}" var="genre">
                  <a href="simpleGenre.html?genre=${genre}" class="list-group-item">${genre}</a>
               </c:forEach>

            </div>
         </div>
         <div class="col-md-8">
            <c:choose>
               <c:when test="${not empty genreTracks}">
                  <h1 class="page-header">${genreTracks[0].album.genre}</h1>
                  <div class="well">
                     <table class="table table-striped table-hover">
                        <tr>
                           <th><a href="#">Track</a></th>
                           <th><a href="#">Artist</a></th>
                           <th><a href="#">Album</a></th>
                        </tr>
                        <c:forEach items="${genreTracks}" var="track">
                           <tr>
                              <td><a href="SongPage.html?trackid=${track.id}">${track.name}</a></td>
                              <td><a
                                 href="artist.html?id=${track.album.artist.id}">${track.album.artist.name}</a></td>
                              <td><a href="album.html?id=${track.album.id}">${track.album.name}</a></td>
                           </tr>
                        </c:forEach>
                     </table>
                  </div>
               </c:when>
            </c:choose>
         </div>
      </div>

      <!-------------------------------------------------------------------------------------->
   </div>

   <!--##############################-->
   <!----------- FOOTER--------------->
   <jsp:include page="MasterFooter.jsp" />
   <!---------------------------------->

   <!--#################################################-->
   <!-------------- JAVASCRIPT --------------------------->
   <script src="Scripts/jquery-1.10.2.min.js"></script>
   <script src="Scripts/bootstrap.min.js"></script>
   <!----------------------------------------------------->
</body>
</html>