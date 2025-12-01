<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />

<div class="container">

    <h3 class="mb-3">Playlist: ${playlist.nom}</h3>

    <p>${playlist.description}</p>

    <h5>Songs</h5>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Order</th>
                <th>Title</th>
                <th>Artist</th>
                <th>Album</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${playlist.items}">
                <tr>
                    <td>${item.ordre}</td>
                    <td>${item.chanson.titre}</td>
                    <td>${item.chanson.artiste.nom}</td>
                    <td>${item.chanson.album.titre}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/playlists/removeSong?playlistId=${playlist.id}&chansonId=${item.chanson.id}" class="btn btn-danger btn-sm">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h5>Add song</h5>
    <form method="post" action="${pageContext.request.contextPath}/playlists/addSong">
        <input type="hidden" name="playlistId" value="${playlist.id}" />
        <div class="row">
            <div class="col-md-6">
                <select class="form-select" name="chansonId">
                    <c:forEach var="c" items="${chansons}">
                        <option value="${c.id}">${c.titre} - ${c.artiste.nom}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-2">
                <input type="number" name="ordre" class="form-control" placeholder="Order" />
            </div>
            <div class="col-md-4">
                <button class="btn btn-primary">Add</button>
                <a href="${pageContext.request.contextPath}/playlists" class="btn btn-secondary">Back</a>
            </div>
        </div>
    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
