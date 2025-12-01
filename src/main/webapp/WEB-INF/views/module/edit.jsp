<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Edit Module</h3>

    <!-- ✔ FORMULAIRE VERS /module/save -->
    <form action="${pageContext.request.contextPath}/module/save" method="post">

        <!-- ID caché -->
        <input type="hidden" name="id" value="${model.module.id}" />

        <div class="mb-3">
            <label class="form-label">Code</label>
            <input class="form-control" 
                   name="code" 
                   value="${model.module.code}" 
                   required />
        </div>

        <div class="mb-3">
            <label class="form-label">Title</label>
            <input class="form-control" 
                   name="intitule" 
                   value="${model.module.intitule}" 
                   required />
        </div>

        <div class="mb-3">
            <label class="form-label">Program</label>

            <select class="form-select" name="filiere" required>
                <c:forEach var="f" items="${model.filieres}">
                    <option value="${f.id}"
                        <c:if test="${f.id == model.module.filiere.id}">selected</c:if>>
                        ${f.nom}
                    </option>
                </c:forEach>
            </select>

        </div>

        <button class="btn btn-success">Update</button>

        <!-- ✔ Lien correct -->
          <a href="${pageContext.request.contextPath}/module/list" 
              class="btn btn-secondary">Cancel</a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
