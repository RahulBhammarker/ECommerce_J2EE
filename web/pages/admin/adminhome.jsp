<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>
        <div class="container" id="main">
            <%@include file="/design/admin_navigation.jsp" %>

            <div class="row">
                <div class="col-sm-2" id="sidebar">
                    <nav class="nav-sidebar">
                        <h3>Administration</h3>
                        <ul class="nav">
                            <li><a href="/RBOneShop/pages/admin/master.jsp">Master</a></li>                            
                            <li><a href="/RBOneShop/pages/admin/search.jsp">Search</a></li>
                            <li class="nav-divider"></li>
                            <li><a href="/RBOneShop/pages/admin/report.jsp">Reports</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-sm-9">
                    
                </div>

            </div><!-- end container -->
        </div>
        
        <%@include file="/design/footer.jsp" %>
        
    </body><!-- end of body -->
</html><!-- end html -->
