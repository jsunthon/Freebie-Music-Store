<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Freebie Music Store - User Profile</title>

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
      <article class="col-md-6 col-md-offset-1" id="main-content">
         <!-- profile info -->
         <div class="row well page-header">
            <div class="col-md-4">
               <img id="profile-pic" src="http://goo.gl/SpMHsE" alt="" />
            </div>
            <div class="col-md-4">
               <h4>${user.firstName}&nbsp;${user.lastName }</h4>
               <h4>${user.email}</h4>
               <form action="#" method="post">
                  <div class="form-group">
                     <input type="submit" value="Send Friend Request"
                        class="btn btn-info" />
                  </div>
               </form>
            </div>
         </div>


         <!-- downloaded tracks -->
         <div class="well">
            <h2>Downloaded Tracks</h2>
            <table class="table table-striped table-hover">
               <tr>
                  <th>Artist</th>
                  <th>Track</th>
                  <th>Album</th>
               </tr>
               <c:forEach items="${user.downloads}" var="track">
                  <tr>
                     <td><a href="artist.html?id=${track.album.artist.id}">${track.album.artist.name}</a></td>
                     <td><a href="SongPage.html?trackid=${track.id}">${track.name}</a></td>
                     <td><a href="album.html?idd=${track.album.id}">${track.album.name}</a></td>
                  </tr>
               </c:forEach>
            </table>
         </div>


         <!-- comments -->
         <div class="well">
            <h2>Commented Tracks</h2>
            <table class="table table-striped table-hover">
               <tr>
                  <th>Track</th>
                  <th>Artist</th>
                  <th>Album</th>
                  <th>Title</th>
                  <th>Comment</th>
                  <th>Rating</th>
                  <th>Date</th>
               </tr>
               <c:forEach items="${user.comments}" var="comment">
                  <tr class="success">
                     <td><a href="SongPage.html?trackid=${comment.track.id}">${comment.track.name }</a></td>
                     <td><a
                        href="artist.html?id=${comment.track.album.artist.id}">${comment.track.album.artist.name}</a></td>
                     <td><a href="album.html?id=${comment.track.album.id}">${comment.track.album.name}</a></td>
                     <td>${comment.title}</td>
                     <td>${comment.comment}</td>
                     <td><c:forEach begin="1" end="${comment.rating}"
                           varStatus="loop">
                           <img
                              src="http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/256/Actions-rating-icon.png"
                              height="25" width="25">
                        </c:forEach></td>
                     <td><fmt:formatDate value="${comment.commentDate}" /></td>
                  </tr>
               </c:forEach>
            </table>
         </div>



         <!-- uploaded tracks -->
         <div class="well">
            <h2>Uploaded Tracks</h2>
            <table class="table table-striped table-hover">
               <tr>
                  <th>Index</th>
                  <th>Name</th>
               </tr>
               <c:forEach items="${user.uploadTracks}" var="uploadTrack"
                  varStatus="i">
                  <tr class="success">
                     <td>${i.index + 1}</td>
                     <td><a
                        href="downloadUploadedTrack.html?uploadID=${uploadTrack.id}">${uploadTrack.name}</a></td>
                  </tr>
               </c:forEach>
            </table>
         </div>


      </article>
   </section>
   <!-- ------------------------------------------------------------------------------- -->

   <!-- ############################### -->
   <!------------ FOOTER -------------- -->
   <jsp:include page="MasterFooter.jsp" />
   <!--------------------------------- -->

   <!--#################################################-->
   <!---------------- JAVASCRIPT ------------------------->
   <script src="Scripts/jquery-1.10.2.min.js"></script>
   <script src="Scripts/bootstrap.min.js"></script>
   <!----------------------------------------------------->

</body>
</html>