<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container mt-4">
    <div class="alert alert-danger">
        <h4 class="alert-heading">An error occurred</h4>
        <p>Request: <strong>${url}</strong></p>
        <p>Exception: <strong>${exception.class.name}</strong></p>
        <pre style="max-height:400px;overflow:auto">${exception}</pre>
    </div>
    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Home</a>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
