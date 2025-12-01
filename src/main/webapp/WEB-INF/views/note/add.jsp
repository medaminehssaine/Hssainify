<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Assign Grade</h3>

    <c:if test="${not empty model.message}">
        <div class="alert alert-success">${model.message}</div>
    </c:if>

    <!-- ✔ Submit to /note/save (required) -->
    <form method="post" action="${pageContext.request.contextPath}/note/save">

        <!-- Student -->
        <div class="mb-3">
            <label class="form-label">Student</label>
            <select class="form-select" name="etudiant" required>
                <c:forEach var="e" items="${model.etudiants}">
                    <option value="${e.id}">${e.nom} ${e.prenom}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Module -->
        <div class="mb-3">
            <label class="form-label">Module</label>
            <select class="form-select" name="module" required>
                <c:forEach var="m" items="${model.modules}">
                    <option value="${m.id}">${m.code} - ${m.intitule}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Grade -->
        <div class="mb-3">
            <label class="form-label">Grade</label>
            <input type="number" name="note"
                   min="0" max="20" step="0.01"
                   class="form-control" required />
        </div>

        <button class="btn btn-success">Save</button>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
