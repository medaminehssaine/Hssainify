<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm mb-4">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <i class="fa-solid fa-music me-2"></i>
            Music Library
        </a>
        
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link ${pageContext.request.requestURI.contains('/artistes') ? 'active' : ''}" href="${pageContext.request.contextPath}/artistes">
                        <i class="fa-solid fa-user-music me-1"></i> Artists
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${pageContext.request.requestURI.contains('/albums') ? 'active' : ''}" href="${pageContext.request.contextPath}/albums">
                        <i class="fa-solid fa-compact-disc me-1"></i> Albums
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${pageContext.request.requestURI.contains('/chansons') ? 'active' : ''}" href="${pageContext.request.contextPath}/chansons">
                        <i class="fa-solid fa-music-note me-1"></i> Songs
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${pageContext.request.requestURI.contains('/playlists') ? 'active' : ''}" href="${pageContext.request.contextPath}/playlists">
                        <i class="fa-solid fa-list-music me-1"></i> Playlists
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
