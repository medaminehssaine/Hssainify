<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3"><c:choose><c:when test="${not empty album}">Edit Album</c:when><c:otherwise>Add Album</c:otherwise></c:choose></h3>

    <form method="post" action="${pageContext.request.contextPath}/albums/save">

        <c:if test="${not empty album}">
            <input type="hidden" name="id" value="${album.id}" />
        </c:if>

        <div class="mb-3">
            <label class="form-label">Title</label>
            <input class="form-control" name="titre" value="${album.titre}" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Release Date</label>
            <input type="date" class="form-control" name="dateSortie" value="${album.dateSortie}" />
        </div>

        <div class="mb-3">
            <label class="form-label">Artist</label>
            <select class="form-select" name="artiste">
                <c:forEach var="ar" items="${artistes}">
                    <option value="${ar.id}" <c:if test="${album != null && album.artiste != null && ar.id == album.artiste.id}">selected</c:if>>${ar.nom}</option>
                </c:forEach>
            </select>
        </div>

        <button class="btn btn-success"><c:choose><c:when test="${not empty album}">Update</c:when><c:otherwise>Save</c:otherwise></c:choose></button>
        <a href="${pageContext.request.contextPath}/albums" class="btn btn-secondary">Cancel</a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
