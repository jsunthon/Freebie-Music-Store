<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Freebie Music Store - User</title>

<!--##################################################### -->
<!--------------------- Styling ---------------------------->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link href="Content/footer-distributed-with-address-and-phones.css"
	rel="stylesheet" />
<link href="Content/bootstrap.css" rel="stylesheet" />
<link href="Content/add_styling.css" rel="stylesheet" />
<link href="Content/animate.css" rel="stylesheet" />
<style>
Img {
	border-radius: 125px;
	width: 300px;
	height: 300px;
}
</style>
<!--------------------------------------------------->

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

	<div class="row">

		<!-- ############################################################################-->
		<!--------------------------  Main Content ---------------------------------------->

		<div class="col-md-7 col-md-offset-1" id="main-content">
			<h1 class="page-header">Artist View (Editable)</h1>
			<br /> <br /> <br />

			<form:form class="form-horizontal" modelAttribute="artist">

				<div class="form-group">
					<label class="col-sm-2 control-label">ID</label>
					<div class="col-sm-5">
						<input type="text" readonly="readonly"
							class="form-control text-center" value="${artist.id}" />
					</div>
				</div>

				<div class="form-group">
					<label for="inputArtist" class="col-sm-2 control-label">Artist</label>
					<div class="col-sm-5">
						<form:input type="text" path="name"
							class="form-control text-center" id="inputArtist" />
					</div>
				</div>

				<c:forEach items="${artist.albums}" var="album" varStatus="i">
					<br />
					<br />
					<table class="table table-condensed table-hover">
						<tr class="success">
							<th class="text-center">ID</th>
							<th class="text-center">Album Name</th>
							<th class="text-center">Genre</th>
							<td></td>
						</tr>

						<tr class="text-center">
							<td>${album.id}</td>
							<td><form:input type="text" path="albums[${i.index}].name"
									class="form-control text-center " /></td>
							<td><form:select class="form-control"
									path="albums[${i.index}].genre" items="${masterGenreList}"></form:select></td>
						</tr>
					</table>

					<ul class="col-md-6">
						<c:forEach items="${album.tracks}" var="track" varStatus="k">
							<li><form:input class="form-control"
									path="albums[${i.index}].tracks[${k.index}].name" /></li>
						</c:forEach>
					</ul>
					<img class="img-responsive center-block img-circle"
						src="${album.imgSrc}" />
				</c:forEach>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-5">
						<input type="submit" class="btn btn-primary" value="Submit Change" />
						<a href="cancelEditArtist.html" class="btn btn-danger">Cancel</a>
					</div>
				</div>

			</form:form>
		</div>
	</div>

	<!--------------------------------------------------------------------------------->


	<!--###############################-->
	<!----------- Footer ---------------->
	<jsp:include page="MasterFooter.jsp" />
	<!----------------------------------->


	<!--#################################################-->
	<!---------- JAVASCRIPT ------------------------------->
	<script src="Scripts/jquery-1.10.2.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
	<!----------------------------------------------------->
</body>
</html>

