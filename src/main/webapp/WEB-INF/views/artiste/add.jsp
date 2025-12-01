<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3"><c:choose><c:when test="${not empty artiste}">Edit Artist</c:when><c:otherwise>Add Artist</c:otherwise></c:choose></h3>

    <form method="post" action="${pageContext.request.contextPath}/artistes/save">

        <c:if test="${not empty artiste}">
            <input type="hidden" name="id" value="${artiste.id}" />
        </c:if>

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input class="form-control" name="nom" value="${artiste.nom}" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Nationality</label>
            <input class="form-control" name="nationalite" value="${artiste.nationalite}" />
        </div>

        <button class="btn btn-success"><c:choose><c:when test="${not empty artiste}">Update</c:when><c:otherwise>Save</c:otherwise></c:choose></button>
        <a href="${pageContext.request.contextPath}/artistes" class="btn btn-secondary">Cancel</a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
