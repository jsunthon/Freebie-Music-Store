
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<section class="row">

   <div class="col-lg-12 cols">
      <h1 class="page-header">Search results for "${searchBar }"</h1>
   </div>

   <ul class="nav nav-tabs">
      <li><a id="results-genre-tab" href="#results-genre" data-toggle="tab">Genres</a></li>
      <li><a id="results-artist-tab" href="#results-artist" data-toggle="tab">Artists</a></li>
      <li><a id="results-track-tab" href="#results-track" data-toggle="tab">Tracks</a></li>
      <li><a id="results-album-tab" href="#results-album" data-toggle="tab">Albums</a></li>
      <li><a id="results-user-tab" href="#results-user" data-toggle="tab">Users</a></li>
   </ul>

   <div id="myTabContent" class="tab-content">
      <div class="tab-pane fade" id="results-genre">
         <br />

         <!--search result ??? -->
         <c:choose>
            <c:when test="${fn:length(searchResults) gt 0}">
               <input type="hidden" id="searchResults" />
               <c:forEach items="${searchResults }" var="track">
                  <!--  Music Listings; 4 per row, display at most 2 rows;
                        2 x 4 Matrix-->
                  <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                     <div class="well">
                        <a class="thumbnail" href="SongPage.html?trackid=${track.id}">
                           <img class="img-responsive" src="${track.album.imgSrc}"
                           alt="">
                        </a> <a href="SongPage.html?trackid=${track.id}">${track.name}<br /></a>
                        <a href="album.html?id=${track.album.id }">${track.album.name}<br /></a>
                        <a href="SongPage.html?trackid=${track.id}"
                           class="btn btn-primary"><i class="fa fa-download"></i>&nbsp;&nbsp;Download</a>
                     </div>
                  </div>
               </c:forEach>
            </c:when>
         </c:choose>
      </div>
      <div class="tab-pane fade" id="results-artist">
         <br />

         <!--artists result -->
         <c:choose>
            <c:when test="${fn:length(searchResultsArtist) gt 0}">
               <input type="hidden" id="searchResultsArtist" />
               <c:forEach items="${searchResultsArtist }" var="artist">
                  <!--  Music Listings; 4 per row, display at most 2 rows;
                   2 x 4 Matrix-->
                  <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                     <div class="well">
                        <a class="thumbnail" href="artist.html?id=${artist.id }">
                           <img class="img-responsive" src="http://goo.gl/Q7TqLS"
                           alt="">
                        </a> <a href="artist.html?id=${artist.id }">${artist.name}<br /></a>
                     </div>
                  </div>
               </c:forEach>
            </c:when>
         </c:choose>
      </div>
      <div class="tab-pane fade active in" id="results-track">
         <br />
         
         <!-- track result -->
         <c:choose>
            <c:when test="${fn:length(searchResultsTrack) gt 0}">
               <input type="hidden" id="searchResultsTrack" />
               <c:forEach items="${searchResultsTrack }" var="track">
                  <!--  Music Listings; 4 per row, display at most 2 rows;
                   2 x 4 Matrix-->
                  <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                     <div class="well">
                        <a class="thumbnail" href="SongPage.html?trackid=${track.id}">
                           <img class="img-responsive" src="${track.album.imgSrc}"
                           alt="">
                        </a> <a href="SongPage.html?trackid=${track.id}">${track.name}<br /></a>
                        <a href="album.html?id=${track.album.id }">${track.album.name}<br /></a>
                        <a href="SongPage.html?trackid=${track.id}"
                           class="btn btn-primary"><i class="fa fa-download"></i>&nbsp;&nbsp;Download</a>
                     </div>
                  </div>
               </c:forEach>
            </c:when>
         </c:choose>
      </div>
      <div class="tab-pane fade" id="results-album">
         <br />
         
         <!-- albums result -->
         <c:choose>
            <c:when test="${fn:length(searchResultsAlbum) gt 0}">
               <input type="hidden" id="searchResultsAlbum" />
               <c:forEach items="${searchResultsAlbum }" var="album">
                  <!--  Music Listings; 4 per row, display at most 2 rows;
            2 x 4 Matrix-->
                  <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                     <div class="well">
                        <a class="thumbnail" href="album.html?id=${album.id }"> <img
                           class="img-responsive" src="${album.imgSrc}" alt="">
                        </a> <a href="album.html?id=${album.id }">${album.name}<br /></a>
                        <a href="artist.html?id=${album.artist.id}">${album.artist.name}</a>
                     </div>
                  </div>
               </c:forEach>
            </c:when>
         </c:choose>
      </div>
      <div class="tab-pane fade" id="results-user">
         <br />
         <c:choose>
            <c:when test="${fn:length(searchResultsUser) gt 0}">
               <input type="hidden" id="searchResultsUser" />
               <c:forEach items="${searchResultsUser }" var="User">
                  <!--  Music Listings; 4 per row, display at most 2 rows;
            2 x 4 Matrix-->
                  <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                     <div class="well">
                        <a class="thumbnail" href="#"> <img
                           class="img-responsive" src="http://goo.gl/Q7TqLS" alt=""></a>
                        <a href="profileView.html?id=${User.id}">${User.email}<br/></a>
                     </div>
                  </div>

               </c:forEach>
            </c:when>
         </c:choose>
      </div>
   </div>
</section>

<script src="Scripts/jquery-1.10.2.min.js"></script>
<script>
	$(document).ready(function() {
		if ($("#searchResults").length != 0) {
			$("#results-artist-tab").hide();
			$("#results-track-tab").hide();
			$("#results-album-tab").hide();
			$("#results-user-tab").hide();
			$(".active").removeClass("active in");
			$("#results-genre").addClass("active in");
		} else {
			$("#results-genre-tab").hide();
		}
		if ($("#searchResultsArtist").length != 0) {
			$(".active").removeClass("active in");
			$("#results-artist").addClass("active in");
		} else {
			$("#results-artist-tab").hide();
		}
		if ($("#searchResultsTrack").length != 0) {
			$(".active").removeClass("active in");
			$("#results-track").addClass("active in");
		} else {
			$("#results-track-tab").hide();
		}
		if ($("#searchResultsAlbum").length != 0) {
			$(".active").removeClass("active in");
			$("#results-album").addClass("active in");
		} else {
			$("#results-album-tab").hide();
		}
		if ($("#searchResultsUser").length != 0) {
			$(".active").removeClass("active in");
			$("#results-user").addClass("active in");
		} else {
			$("#results-user-tab").hide();
		}
	});
</script>