<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Playlists</h3>

    <a href="${pageContext.request.contextPath}/playlists/add" class="btn btn-primary mb-3">+ Add Playlist</a>

    <table class="table table-striped table-bordered">
        <thead class="table-secondary">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th width="160">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${playlists}">
            <tr>
                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.description}</td>
                <td>${p.dateCreation}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/playlists/view?id=${p.id}" class="btn btn-info btn-sm">View</a>
                    <a href="${pageContext.request.contextPath}/playlists/add?id=${p.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/playlists/delete?id=${p.id}" onclick="return confirm('Delete this playlist?');" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
