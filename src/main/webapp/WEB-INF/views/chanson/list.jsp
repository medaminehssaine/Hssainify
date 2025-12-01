<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Songs</h3>

    <a href="${pageContext.request.contextPath}/chansons/add" class="btn btn-primary mb-3">+ Add Song</a>

    <table class="table table-striped table-bordered">
        <thead class="table-secondary">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Duration (s)</th>
            <th>Genre</th>
            <th>Album</th>
            <th>Artist</th>
            <th width="160">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${chansons}">
            <tr>
                <td>${c.id}</td>
                <td>${c.titre}</td>
                <td>${c.duree}</td>
                <td>${c.genre}</td>
                <td>${c.album.titre}</td>
                <td>${c.artiste.nom}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/chansons/add?id=${c.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/chansons/delete?id=${c.id}" onclick="return confirm('Delete this song?');" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
