<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Albums</h3>

    <a href="${pageContext.request.contextPath}/albums/add" class="btn btn-primary mb-3">+ Add Album</a>

    <table class="table table-striped table-bordered">
        <thead class="table-secondary">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Release Date</th>
            <th>Artist</th>
            <th width="160">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="a" items="${albums}">
            <tr>
                <td>${a.id}</td>
                <td>${a.titre}</td>
                <td><c:out value="${a.dateSortie}"/></td>
                <td>${a.artiste.nom}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/albums/add?id=${a.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/albums/delete?id=${a.id}" onclick="return confirm('Delete this album?');" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
