<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container mt-5">

    <div class="text-center mb-5">
        <h1 class="display-4"><i class="fa-solid fa-music text-primary"></i> Music Library System</h1>
        <p class="lead text-muted">Manage your artists, albums, songs, and playlists</p>
        <p class="text-muted">MCD 27 - By Mohammed Amine Hssaine</p>
    </div>

    <div class="row g-4">

        <!-- Artists Card -->
        <div class="col-md-6 col-lg-3">
            <div class="card h-100 shadow-sm border-0 hover-lift">
                <div class="card-body text-center p-4">
                    <div class="mb-3">
                        <i class="fa-solid fa-user-music fa-3x text-primary"></i>
                    </div>
                    <h5 class="card-title fw-bold">Artists</h5>
                    <p class="card-text text-muted">Manage music artists and their information</p>
                    <a href="${pageContext.request.contextPath}/artistes" class="btn btn-primary w-100">
                        <i class="fa-solid fa-arrow-right me-2"></i>View Artists
                    </a>
                </div>
            </div>
        </div>

        <!-- Albums Card -->
        <div class="col-md-6 col-lg-3">
            <div class="card h-100 shadow-sm border-0 hover-lift">
                <div class="card-body text-center p-4">
                    <div class="mb-3">
                        <i class="fa-solid fa-compact-disc fa-3x text-success"></i>
                    </div>
                    <h5 class="card-title fw-bold">Albums</h5>
                    <p class="card-text text-muted">Browse and manage music albums</p>
                    <a href="${pageContext.request.contextPath}/albums" class="btn btn-success w-100">
                        <i class="fa-solid fa-arrow-right me-2"></i>View Albums
                    </a>
                </div>
            </div>
        </div>

        <!-- Songs Card -->
        <div class="col-md-6 col-lg-3">
            <div class="card h-100 shadow-sm border-0 hover-lift">
                <div class="card-body text-center p-4">
                    <div class="mb-3">
                        <i class="fa-solid fa-music-note fa-3x text-warning"></i>
                    </div>
                    <h5 class="card-title fw-bold">Songs</h5>
                    <p class="card-text text-muted">Explore your complete song library</p>
                    <a href="${pageContext.request.contextPath}/chansons" class="btn btn-warning w-100">
                        <i class="fa-solid fa-arrow-right me-2"></i>View Songs
                    </a>
                </div>
            </div>
        </div>

        <!-- Playlists Card -->
        <div class="col-md-6 col-lg-3">
            <div class="card h-100 shadow-sm border-0 hover-lift">
                <div class="card-body text-center p-4">
                    <div class="mb-3">
                        <i class="fa-solid fa-list-music fa-3x text-danger"></i>
                    </div>
                    <h5 class="card-title fw-bold">Playlists</h5>
                    <p class="card-text text-muted">Create and manage custom playlists</p>
                    <a href="${pageContext.request.contextPath}/playlists" class="btn btn-danger w-100">
                        <i class="fa-solid fa-arrow-right me-2"></i>View Playlists
                    </a>
                </div>
            </div>
        </div>

    </div>

    <div class="mt-5 p-4 bg-light rounded">
        <h5 class="mb-3"><i class="fa-solid fa-info-circle text-info me-2"></i>Features</h5>
        <div class="row">
            <div class="col-md-6">
                <ul class="list-unstyled">
                    <li class="mb-2"><i class="fa-solid fa-check text-success me-2"></i>Full CRUD operations for all entities</li>
                    <li class="mb-2"><i class="fa-solid fa-check text-success me-2"></i>Artist and album management</li>
                    <li class="mb-2"><i class="fa-solid fa-check text-success me-2"></i>Song cataloging with genres</li>
                </ul>
            </div>
            <div class="col-md-6">
                <ul class="list-unstyled">
                    <li class="mb-2"><i class="fa-solid fa-check text-success me-2"></i>Custom playlist creation</li>
                    <li class="mb-2"><i class="fa-solid fa-check text-success me-2"></i>Many-to-many relationships</li>
                    <li class="mb-2"><i class="fa-solid fa-check text-success me-2"></i>Spring MVC + JPA + MySQL</li>
                </ul>
            </div>
        </div>
    </div>

</div>

<style>
.hover-lift {
    transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
}
.hover-lift:hover {
    transform: translateY(-5px);
    box-shadow: 0 10px 25px rgba(0,0,0,0.15) !important;
}
</style>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
