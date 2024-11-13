<c:forEach var="entry" items="${categoryVideosMap}">
    <!-- Lấy key và value -->
    <div class="mb-4">
        <h3>${entry.key.categoryName} (${entry.key.categoryCode})</h3>
        <div class="row">
            <c:forEach var="video" items="${entry.value}">
                <div class="col-md-3 mb-3">
                    <div class="card">
                        <img src="${video.poster}" class="card-img-top" alt="${video.title}">
                        <div class="card-body">
                            <h5 class="card-title">${video.title}</h5>
                            <p class="card-text">${video.description}</p>
                            <a href="${pageContext.request.contextPath}/videos?action=details&videoId=${video.videoId}" class="btn btn-primary">Xem Chi Tiết</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:forEach>
