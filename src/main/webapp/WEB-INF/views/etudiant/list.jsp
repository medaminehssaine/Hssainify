<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">List of Students</h3>

    <c:if test="${not empty model.message}">
        <div class="alert alert-success">${model.message}</div>
    </c:if>

    <!-- ✔ Lien correct : /etudiants/add -->
     <a href="${pageContext.request.contextPath}/etudiants/add"
         class="btn btn-primary mb-3">+ Add Student</a>

    <table class="table table-striped table-bordered">
        <thead class="table-secondary">
        <tr>
            <th>ID</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Program</th>
            <th width="160">Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="e" items="${model.etudiants}">
            <tr>
                <td>${e.id}</td>
                <td>${e.nom}</td>
                <td>${e.prenom}</td>
                <td>${e.filiere.nom}</td>

                <td>
                    <!-- ✔ Edition = /etudiants/add?id=XX (TON CONTROLLER FAIT ÇA !) -->
                          <a href="${pageContext.request.contextPath}/etudiants/add?id=${e.id}"
                              class="btn btn-warning btn-sm">Edit</a>

                    <!-- ✔ Suppression -->
                          <a href="${pageContext.request.contextPath}/etudiants/delete?id=${e.id}"
                              onclick="return confirm('Delete this student?');"
                              class="btn btn-danger btn-sm">Delete</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
