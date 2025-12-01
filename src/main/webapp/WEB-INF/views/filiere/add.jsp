<%@ page contentType="text/html; charset=UTF-8" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Add Program</h3>

    <!-- ✔ ENVOI VERS /filiere/save -->
    <form method="post" action="${pageContext.request.contextPath}/filiere/save">

        <div class="mb-3">
            <label class="form-label">Program Name</label>
            <input class="form-control" name="nom" required />
        </div>

        <button class="btn btn-success">Save</button>

        <!-- ✔ Retour vers /filiere/list -->
        <a href="${pageContext.request.contextPath}/filiere/list"
           class="btn btn-secondary">Cancel</a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
