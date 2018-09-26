<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="webjars/jquery/3.3.1-1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fill Information!</title>
</head>
<body>

<spring:url value="${pageContext.servletContext.contextPath}" var="ctx"></spring:url>

	<div class="container">
		<div class="card border-info mb-3">


			<div class="card-header text-white bg-info mb-3">
				<h1 class="card-title">Welcome to registration page!</h1>
			</div>

			<div class="card-body ">


				<form:form method="POST" modelAttribute="person"
					action="${ctx}/register">

					<div class="form-group">
						<label for="firstName" class="control-label col-sm-2">First Name:</label>
						<form:input id="firstName" path="firstName" cssClass="form-control col-sm-4"/>
						<form:errors path="firstName" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="lastName" class="control-label col-sm-4">Last Name: </label>
						<form:input id="lastName" path="lastName"
							cssClass="form-control col-sm-4" />
						<form:errors path="lastName" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="email" class="control-label col-sm-4">Email: </label>

					<%-- 	<form:select path="orderMethd" cssClass="custom-select col-sm-4"
							id="orderMethd">
							<form:option value="">--Select--</form:option>
						</form:select>
 --%>						
						<form:input path="email" cssClass="form-control col-sm-4" id="email"/>
						
						<form:errors path="email" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="orgName" class="control-label col-sm-4">Organization: </label>
						<form:input path="orgName" cssClass="form-control col-sm-4" id="orgName"/>	
						<form:errors path="orgName" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="mobile" class="control-label col-sm-4">Mobile:
						</label>

						<form:input path="mobile" cssClass="form-control col-sm-4" />
						<form:errors path="mobile" cssClass="text-danger" />
					</div>


					<input type="submit" value="Post my information"
						class="btn btn-outline-success">

					<button class="btn btn-outline-info" type="reset">Clear</button>

				</form:form>

				<!-- CARD BODY END -->
			</div>



			<!-- CARD FOOTER -->
			<div class="card-footer bg-info">
				<h1>${msg}</h1>

			</div>
		</div>

		<!-- CARD END -->
	</div>


</body>
</html>