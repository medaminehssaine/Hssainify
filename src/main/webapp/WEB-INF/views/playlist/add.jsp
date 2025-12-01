<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3"><c:choose><c:when test="${not empty playlist}">Edit Playlist</c:when><c:otherwise>Add Playlist</c:otherwise></c:choose></h3>

    <form method="post" action="${pageContext.request.contextPath}/playlists/save">

        <c:if test="${not empty playlist}">
            <input type="hidden" name="id" value="${playlist.id}" />
        </c:if>

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input class="form-control" name="nom" value="${playlist.nom}" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Description</label>
            <input class="form-control" name="description" value="${playlist.description}" />
        </div>

        <button class="btn btn-success"><c:choose><c:when test="${not empty playlist}">Update</c:when><c:otherwise>Save</c:otherwise></c:choose></button>
        <a href="${pageContext.request.contextPath}/playlists" class="btn btn-secondary">Cancel</a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
