<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/artistes">Artists</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/albums">Albums</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/chansons">Songs</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/playlists">Playlists</a></li>
            </ul>

            <form class="d-flex ms-auto" action="${pageContext.request.contextPath}/search" method="get">
                <input class="form-control me-2" type="search" name="q" placeholder="Search songs, artists..." aria-label="Search">
                <button class="btn btn-outline-primary" type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
    </div>
</nav>
