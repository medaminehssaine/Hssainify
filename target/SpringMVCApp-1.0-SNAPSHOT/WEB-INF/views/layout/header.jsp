<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MCD 27 - Music Library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-p6O1X2kq+Yp6gkK1l0Q+u1Yp6+Xbz1Xk1u9ZQ1K6e1q1K6X1+eA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <style>
        :root{
            --brand:#0d6efd;
            --muted:#6c757d;
        }
        body { background: #f4f6f9; color: #222; }
        .site-header{ background: linear-gradient(90deg, #0d6efd33, #6f42c133); }
        .navbar-brand { font-weight:700; letter-spacing:0.4px; }
        .card { border: none; box-shadow: 0 6px 18px rgba(15,15,15,0.06); }
        .table thead { background:#f8fafc; }
        footer.site-footer{ padding:24px 0; color:var(--muted); }
    </style>
</head>
<body>
<header class="site-header mb-4">
    <div class="container py-3 d-flex justify-content-between align-items-center">
        <div class="d-flex align-items-center gap-3">
            <a class="navbar-brand text-dark" href="${pageContext.request.contextPath}/">
                <i class="fa-solid fa-music text-primary"></i>
                <span class="ms-2">MCD 27 — Music Library</span>
            </a>
        </div>
        <div>
            <small class="text-muted">Manage songs, albums, artists & playlists</small>
        </div>
    </div>
</header>
<div class="container">
    <c:if test="${not empty message}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${error}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
</div>
