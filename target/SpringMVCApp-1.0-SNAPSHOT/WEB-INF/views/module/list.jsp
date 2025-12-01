<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">List of Modules</h3>

    <c:if test="${not empty model.message}">
        <div class="alert alert-success">${model.message}</div>
    </c:if>

    <!-- ✔ Nouveau lien correct : /module/add -->
     <a href="${pageContext.request.contextPath}/module/add" 
         class="btn btn-primary mb-3">+ Add Module</a>

    <table class="table table-bordered table-hover">
        <thead class="table-secondary">
        <tr>
            <th>ID</th>
            <th>Code</th>
            <th>Title</th>
            <th>Program</th>
            <th width="160">Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="m" items="${model.modules}">
            <tr>
                <td>${m.id}</td>
                <td>${m.code}</td>
                <td>${m.intitule}</td>
                <td>${m.filiere.nom}</td>
                <td>

                    <!-- ✔ Lien correct vers /module/edit?id= -->
                          <a href="${pageContext.request.contextPath}/module/edit?id=${m.id}"
                              class="btn btn-warning btn-sm">Edit</a>

                    <!-- ✔ Lien correct vers /module/delete?id -->
                          <a href="${pageContext.request.contextPath}/module/delete?id=${m.id}"
                              onclick="return confirm('Delete this module?');"
                              class="btn btn-danger btn-sm">Delete</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
