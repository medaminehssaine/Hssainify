<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3"><c:choose><c:when test="${not empty chanson}">Edit Song</c:when><c:otherwise>Add Song</c:otherwise></c:choose></h3>

    <form method="post" action="${pageContext.request.contextPath}/chansons/save">

        <c:if test="${not empty chanson}">
            <input type="hidden" name="id" value="${chanson.id}" />
        </c:if>

        <div class="mb-3">
            <label class="form-label">Title</label>
            <input class="form-control" name="titre" value="${chanson.titre}" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Duration (seconds)</label>
            <input type="number" class="form-control" name="duree" value="${chanson.duree}" />
        </div>

        <div class="mb-3">
            <label class="form-label">Genre</label>
            <input class="form-control" name="genre" value="${chanson.genre}" />
        </div>

        <div class="mb-3">
            <label class="form-label">Album</label>
            <select class="form-select" name="album">
                <option value="">-- None --</option>
                <c:forEach var="al" items="${albums}">
                    <option value="${al.id}" <c:if test="${chanson != null && chanson.album != null && al.id == chanson.album.id}">selected</c:if>>${al.titre}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Artist</label>
            <select class="form-select" name="artiste">
                <option value="">-- None --</option>
                <c:forEach var="ar" items="${artistes}">
                    <option value="${ar.id}" <c:if test="${chanson != null && chanson.artiste != null && ar.id == chanson.artiste.id}">selected</c:if>>${ar.nom}</option>
                </c:forEach>
            </select>
        </div>

        <button class="btn btn-success"><c:choose><c:when test="${not empty chanson}">Update</c:when><c:otherwise>Save</c:otherwise></c:choose></button>
        <a href="${pageContext.request.contextPath}/chansons" class="btn btn-secondary">Cancel</a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
