<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="../resources/bootstrap/js/SearchPageParam.js"></script>



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="webjars/jquery/3.3.1-1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person database</title>
</head>
<body>
	<div class="container">
	
		<div class="card">

			<div class="card-header  bg-info">
				<h1>welcome!</h1>
			</div>

			<div class="card-body ">

		 				<table class="table table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col" colspan="2">OPERATION</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${page.content}" var="person">
						
							<tr>
								<th scope="row"><a href="<c:out value="view?personId=${person.pid}" />">${person.pid}</a>  </th>
								<td><c:out value="${person.firstName}" /></td>
								<td><c:out value="${person.lastName}" /></td>
								 <td><a href="delete?personId=${person.pid}"
									class="btn btn-outline-danger">DELETE</a></td>
								<td><a href="update?personId=${person.pid}"
									class="btn btn-outline-success">EDIT</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- CARD BODY END -->
			</div>

			<div class="card-footer ">


				<ul class="pagination">


					<c:if test="${!page.first}">
						<li class="page-item"><a class="page-link"
							onclick="setParam('page','0')" href="#">First</a></li>
					</c:if>


					<c:if test="${page.hasNext()}">
						<li class="page-item"><a class="page-link" href="#"
							onclick="setParam('page',${page.number + 1})">Next</a></li>
					</c:if>


					<c:if test="${!empty page.content}">
						<c:forEach begin="0" end="${page.totalPages -1 }" var="count">

							<c:choose>
								<c:when test="${page.number eq count }">
									<li class="page-item active"><a class="page-link "
										href="#">${count+1}</a></li>

								</c:when>

								<c:otherwise>
									<li class="page-item"><a class="page-link" href="#"
										onclick="setParam('page',${count})">${count+1}</a></li>


								</c:otherwise>

							</c:choose>




						</c:forEach>

					</c:if>


					<c:if test="${page.hasPrevious()}">
						<li class="page-item"><a class="page-link" href="#"
							onclick="setParam('page',${page.number -1})">Previous</a></li>
					</c:if>


					<c:if test="${!page.last}">
						<li class="page-item"><a class="page-link" href="#"
							onclick="setParam('page',${page.totalPages -1})">Last</a></li>
					</c:if>




				</ul>

			</div>



		</div>
	</div>
</body>
</html>