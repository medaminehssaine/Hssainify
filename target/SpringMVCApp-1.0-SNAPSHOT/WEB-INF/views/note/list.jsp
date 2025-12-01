<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

	<h3 class="mb-3">List of Grades</h3>

	<c:if test="${not empty model.message}">
		<div class="alert alert-success">${model.message}</div>
	</c:if>

	 <!-- Button to add grade -->
	 <a href="${pageContext.request.contextPath}/note"
		 class="btn btn-primary mb-3">+ Add Grade</a>

	<table class="table table-striped table-bordered">
		<thead class="table-secondary">
			<tr>
				<th>Student</th>
				<th>Module</th>
				<th>Grade</th>
			</tr>
		</thead>

		<tbody>
		<c:forEach var="n" items="${model.notes}">
			<tr>
				<td>${n.etudiant.nom} ${n.etudiant.prenom}</td>
				<td>${n.module.code} - ${n.module.intitule}</td>
				<td>${n.note}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
