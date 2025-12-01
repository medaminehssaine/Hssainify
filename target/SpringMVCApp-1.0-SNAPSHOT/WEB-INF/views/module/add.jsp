<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Add Module</h3>

    <!-- ✔ FORMULAIRE VERS /module/save -->
    <form action="${pageContext.request.contextPath}/module/save" method="post">

        <div class="mb-3">
            <label class="form-label">Code</label>
            <input class="form-control" name="code" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Title</label>
            <input class="form-control" name="intitule" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Program</label>

            <select class="form-select" name="filiere" required>
                <c:forEach var="f" items="${model.filieres}">
                    <option value="${f.id}">${f.nom}</option>
                </c:forEach>
            </select>

        </div>

          <button class="btn btn-success">Save</button>

          <!-- ✔ Lien correct vers /module/list -->
          <a href="${pageContext.request.contextPath}/module/list" 
              class="btn btn-secondary">Cancel</a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
