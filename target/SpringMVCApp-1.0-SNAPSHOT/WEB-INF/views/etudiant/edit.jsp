<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Edit Student</h3>

    <!-- ✔ action correcte : /etudiants/save -->
    <form method="post" action="${pageContext.request.contextPath}/etudiants/save">

        <!-- ✔ ID caché pour l'édition -->
        <input type="hidden" name="id" value="${model.etudiant.id}" />

        <div class="mb-3">
            <label class="form-label">Last Name</label>
            <input class="form-control"
                   name="nom"
                   value="${model.etudiant.nom}"
                   required />
        </div>

        <div class="mb-3">
            <label class="form-label">First Name</label>
            <input class="form-control"
                   name="prenom"
                   value="${model.etudiant.prenom}"
                   required />
        </div>

        <div class="mb-3">
            <label class="form-label">Program</label>
            <select class="form-select" name="filiere" required>
                <c:forEach var="f" items="${model.filieres}">
                    <option value="${f.id}"
                        <c:if test="${f.id == model.etudiant.filiere.id}">
                            selected
                        </c:if>
                    >
                        ${f.nom}
                    </option>
                </c:forEach>
            </select>
        </div>

        <button class="btn btn-success">Update</button>

        <!-- ✔ Retour correct -->
          <a href="${pageContext.request.contextPath}/etudiants"
              class="btn btn-secondary">Cancel</a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
