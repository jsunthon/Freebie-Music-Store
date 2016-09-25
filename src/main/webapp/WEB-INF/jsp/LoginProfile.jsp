<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="Content/footer-distributed-with-address-and-phones.css"
	rel="stylesheet" />
<link href="Content/bootstrap.css" rel="stylesheet" />
<link href="Content/add_styling.css" rel="stylesheet" />
<link href="Content/animate.css" rel="stylesheet" />
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

		<!--############################################################################-->
		<!-------------------- Main Content --------------------------------------------->
		<div class="col-md-6 col-md-offset-2" id="main-content">
			<h1 class="page-header">Edit your profile</h1>
			<div class="well">
				<form:form class="form-horizontal" modelAttribute="user">
					<fieldset>
						<div class="form-group">
							<label for="firstName" class="col-md-2">First Name</label>
							<div class="col-md-10">
								<form:input type="text" class="form-control" id="name"
									path="firstName" value="${user.firstName}" />
							</div>
						</div>

						<div class="form-group">
							<label for="lastName" class="col-md-2">Last Name</label>
							<div class="col-md-10">
								<form:input type="text" class="form-control" id="lastName"
									path="lastName" value="${user.lastName}" />
							</div>

						</div>

						<div class="form-group">
							<label for="email" class="col-md-2">Email</label>
							<div class="col-md-10">
								<form:input type="text" class="form-control" id="email"
									path="email" disabled="disabled" value="${user.email}" />
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-2">Password</label>
							<div class="col-md-10">
								<form:input type="password" class="form-control" id="password"
									path="password" value="${user.password}" />
							</div>
						</div>

						<div class="form-group">
							<label for="state" class="col-md-2">State</label>
							<div class="col-md-5">
								<form:select path="state" class="form-control" id="select">
									<c:forEach items="${states}" var="state">
										<c:choose>
											<c:when test="${state == user.state}">
												<option selected="selected">${state}</option>
											</c:when>
											<c:otherwise>
												<option>${state}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-8 col-md-offset-2">
								<input type="submit" value="Save Changes"
									class="btn btn-success" />&nbsp;&nbsp;&nbsp;<a
									class="btn btn-danger" href="userPage.html">Cancel</a>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>

	<!-------------------- Main Content --------------------------------------------->

	<!--##############################-->
	<!----------- Footer --------------->
	<jsp:include page="MasterFooter.jsp" />
	<!----------- Footer --------------->

	<!--#################################################-->
	<!---------- JAVASCRIPT ------------------------------->
	<script src="Scripts/jquery-1.10.2.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
	<!---------- JAVASCRIPT ------------------------------->

</body>
</html>