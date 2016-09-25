<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>Top Tracks</title>

<!--##################################################### -->
<!--------------------- Styling ---------------------------->
<link href="Content/jquery.bxslider.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" />
<link href="Content/footer-distributed-with-address-and-phones.css"
	rel="stylesheet" />
<link href="Content/bootstrap.css" rel="stylesheet" />
<link href="Content/add_styling.css" rel="stylesheet" />
<link href="Content/animate.css" rel="stylesheet" />

<style>
.img-circle {
	border-radius: 125px;
	height: 125px;
	width: 125px;
}
</style>
<!--------------------- Styling ---------------------------->
</head>
<body class="container-fluid">

	<!-- ############################### -->
	<!------------ Page Header ----------->
	<jsp:include page="MasterHeader.jsp" />
	<!------------ Page Header ----------->

	<!-- ################################-->
	<!------------ Side Bar --------------->
	<jsp:include page="MasterSideBar.jsp" />
	<!------------ Side Bar --------------->

	<div class="row">

		<!-- MAIN CONTENT DIV -->
		<div class="col-md-8 col-md-offset-1" id="main-content">


			<h1 class="page-header">Welcome to Top Tracks</h1>
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button"
					id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					Top 10 Charts <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
					<li><a href="topTracks.html?genre=ALL">All</a>
					<li role="separator" class="divider"></li>
					<c:forEach items="${masterGenreList}" var="genre">
						<li><a href="topTracks.html?genre=${genre}">${genre}</a></li>
					</c:forEach>
				</ul>

				<span class="btn btn-primary">&nbsp;${msg}&nbsp;<span
					class="badge">10</span></span>

			</div>
			<br />

			<!--------------------- TOP TRACKS Display Body ---------------------------->
			<section class="row" onchange="location = home.html">
				<div class="panel panel-primary">
					<table class="table table-striped table-hover">
						<tr>
							<th class="text-center">Rank</th>
							<th class="text-center">Artist</th>
							<th class="text-center">Track</th>
							<th class="text-center">Count</th>
						</tr>

						<div class="panel-body">
							<c:forEach items="${tracks}" var="track" varStatus="i">
								<tr class="text-center">
									<td>${i.index + 1}</td>
									<td><a class="img-circle img-responsive center-block"
										href="SongPage.html?trackid=${track.id}"><img
											class="img-circle " title="${track.name}"
											src="${track.album.imgSrc}" /></a></td>
									<td>${track.name}<br /> <strong> <a
											href="artist.html?id=${track.album.artist.id}">${track.album.artist.name}</a>
									</strong></td>
									<td>${track.count}</td>
								</tr>
							</c:forEach>
						</div>
					</table>

				</div>
			</section>
			<!--------------------- TOP TRACKS Display Body ---------------------------->

		</div>
	</div>

	<!--##############################-->
	<!----------- FOOTER --------------->
	<jsp:include page="MasterFooter.jsp" />
	<!---------------------------------->

</body>

<!--#################################################-->
<!---------- JAVASCRIPT ------------------------------->
<script src="Scripts/jquery-1.10.2.min.js"></script>
<script src="Scripts/jquery.bxslider.min.js"></script>
<script src="Scripts/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('.bxslider').bxSlider({
			mode : 'horizontal',
			auto : true,
			controls : true,
			captions : true,
			minSlides : 5,
			maxSlides : 5,
			slideWidth : 312,
			slideMargin : 1,
			captions : true
		});

		$("#featured-songs").addClass("animated tada");

		$('.img-responsive').each(function() {
			animationHover(this, 'pulse');
		});
	});

	function animationHover(element, animation) {
		element = $(element);
		element.hover(function() {
			element.addClass('animated ' + animation);
		}, function() {
			//wait for animation to finish before removing classes
			window.setTimeout(function() {
				element.removeClass('animated ' + animation);
			}, 2000);
		});
	}
</script>
<!----------------------------------------------------------->

</html>