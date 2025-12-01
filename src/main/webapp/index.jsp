<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container mt-4">

    <div class="alert alert-primary text-center fw-bold">
        Welcome to MCD 27 - Music Library
    </div>

    <div class="row mt-4">

        <!-- Artists -->
        <div class="col-md-3">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h5 class="card-title">Artists</h5>
                    <p class="card-text">Manage artists.</p>

                    <a href="${pageContext.request.contextPath}/artistes"
                       class="btn btn-primary">Open</a>
                </div>
            </div>
        </div>

        <!-- Albums -->
        <div class="col-md-3">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h5 class="card-title">Albums</h5>
                    <p class="card-text">Manage albums.</p>

                    <a href="${pageContext.request.contextPath}/albums"
                       class="btn btn-primary">Open</a>
                </div>
            </div>
        </div>

        <!-- Songs -->
        <div class="col-md-3">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h5 class="card-title">Songs</h5>
                    <p class="card-text">Manage songs.</p>

                    <a href="${pageContext.request.contextPath}/chansons"
                       class="btn btn-primary">Open</a>
                </div>
            </div>
        </div>

        <!-- Playlists -->
        <div class="col-md-3">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h5 class="card-title">Playlists</h5>
                    <p class="card-text">Manage playlists and their songs.</p>

                    <a href="${pageContext.request.contextPath}/playlists"
                       class="btn btn-primary">Open</a>
                </div>
            </div>
        </div>

    </div>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
