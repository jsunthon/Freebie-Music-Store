<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!------------------------------------------------------------>

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

		<div class="col-md-4 col-md-offset-1" id="main-content">
			<h1 class="page-header">Hello, ${sessionUser.firstName}! You are
				awesome!</h1>
			<div class="list-group well">
				<a href="editProfile.html" class="list-group-item">My Profile</a> <a
					href="playlist.html" class="list-group-item">Playlist</a> <a
					href="downloads.html" class="list-group-item">My Downloads</a> <a
					href="comments.html" class="list-group-item"> Comment History</a> <a
					href="userUploads.html" class="list-group-item">Your Tracks</a>
			</div>

			<form class="" action="upload.html" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label class="control-label">Upload a track. Share Your Passion!</label>
					<div class="input-group">
						<span class="input-group-addon">File</span> <input
							class="form-control btn btn-md btn-default" type="file"
							name="file"> <span class="input-group-btn"> <input
							id="upload" class="btn btn-md btn-primary" type="submit"
							name="upload" value="Upload" />
						</span>
					</div>
				</div>
			</form>
	</section>

	<!--------------------------------------------------------------------------------->


	<!--###############################-->
	<!----------- FOOTER ---------------->
	<jsp:include page="MasterFooter.jsp" />
	<!----------------------------------->


	<!--#################################################-->
	<!---------------- JAVASCRIPT ------------------------->
	<script src="Scripts/jquery-1.10.2.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
	<script>
		$('#upload').click(function(event) {
			$('#status-msg').text("Added to playlist.");
			setTimeout(function() {
				$("#status-msg").empty();
			}, 2000);
		});
	</script>
	<!----------------------------------------------------->
</body>
</html>