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


				<form:form method="POST" modelAttribute="address"
					action="${ctx}/person/${address.pid}/address/new">

					<div class="form-group">
						<label for="city" class="control-label col-sm-2">City:</label>
						<form:input id="city" path="city" cssClass="form-control col-sm-4"/>
						<form:errors path="city" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="state" class="control-label col-sm-4">state: </label>
						<form:input id="state" path="state"
							cssClass="form-control col-sm-4" />
						<form:errors path="state" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="country" class="control-label col-sm-2">Country:</label>
						<form:select path="country" cssClass="custom-select col-sm-4"
							id="country">
							<form:option value="">--Select--</form:option>
							<form:options items="${country}"/>
						</form:select>
						<form:errors path="country" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="pinCode" class="control-label col-sm-4">Pin Code: </label>
						<form:input path="pinCode" cssClass="form-control col-sm-4" id="pinCode"/>	
						<form:errors path="pinCode" cssClass="text-danger" />
					</div>


					<input type="submit" value="Add Address"
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