<nav class="nav-sidebar">
    <h3>Category</h3>
    <ul class="nav">
        <c:forEach items="${cat}" var="cate">
            <li><a href="CustomerHome?id=${cate.jcatid}">${cate.jcatname}</a></li>   
        </c:forEach>  
    </ul>
</nav>