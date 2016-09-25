<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- --------------------  SIDEBAR NAV ------------------------------>
<div class="col-md-2 cols" id="sidebar-div">
	<ul id="sidebar" class="nav navbar-inverse nav-pills nav-stacked">
		<li><a href="topTracks.html?genre=ALL">&nbsp;&nbsp;&nbsp;Top Tracks</a></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">&nbsp;&nbsp;&nbsp;Music
				Categories <span class="caret"></span>
		</a>

			<ul class="dropdown-menu">
				<li><a href="simpleGenre.html?genre=ELECTRONIC">ALL GENRE</a></li>
				<%-- From HomeController afterProperties method --%>
				<c:forEach items="${masterGenreList}" var="genre">
					<li><a href="genre.html?genre=${genre}">${genre}</a></li>
				</c:forEach>
			</ul></li>
        
        <li><a href="uploadList.html">&nbsp;&nbsp;&nbsp;Explore New Music</a></li>
		<li><a href="profiles.html">&nbsp;&nbsp;&nbsp;Find Friends</a></li>
		<li><a href="userPage.html">&nbsp;&nbsp;&nbsp;Manage Your
				Account</a></li>

		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">&nbsp;&nbsp;&nbsp;Admin Control
				Panel <span class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="editor.html">Editor's Mode</a></li>
                <li><a href="selectEditArtist.html">Edit Record</a>
				<li><a href="newRecord.html">Add New Record</a></li>
				<li><a href="adminViewUsers.html">Manage User Accounts</a></li>
			</ul></li>
	</ul>
</div>


