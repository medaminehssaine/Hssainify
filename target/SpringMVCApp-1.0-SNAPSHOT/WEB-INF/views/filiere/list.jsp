<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">List of Programs</h3>

    <c:if test="${not empty model.message}">
        <div class="alert alert-success">${model.message}</div>
    </c:if>

    <!-- ✔ Correction : /filiere/add -->
     <a href="${pageContext.request.contextPath}/filiere/add"
         class="btn btn-primary mb-3">+ Add Program</a>

    <table class="table table-bordered table-striped">
        <thead class="table-secondary">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th width="180">Actions</th>
            </tr>
        </thead>

        <tbody>
        <c:forEach var="f" items="${model.filieres}">
            <tr>
                <td>${f.id}</td>
                <td>${f.nom}</td>
                <td>

                    <!-- ✔ Correction : /filiere/edit?id= -->
                          <a href="${pageContext.request.contextPath}/filiere/edit?id=${f.id}"
                              class="btn btn-sm btn-warning">Edit</a>

                    <!-- ✔ Correction : /filiere/delete?id= -->
                          <a href="${pageContext.request.contextPath}/filiere/delete?id=${f.id}"
                              class="btn btn-sm btn-danger"
                              onclick="return confirm('Delete this program?')">Delete</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
