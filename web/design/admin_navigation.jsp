<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse" type="button">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <header class="navbar-header">
            <a class="navbar-brand" href="/RBOneShop/index.jsp"><img src="/RBOneShop/images/rblogo.jpg" class="img-circle"  id="brandlogo" alt="RB OneShop" height="40" width="40">neShop</a>
        </header>
        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/RBOneShop/pages/admin/adminhome.jsp" class="active">Home</a></li>
                <li><a href="/RBOneShop/pages/admin/master.jsp" target="_parent">Master</a></li>                
                <li><a href="/RBOneShop/pages/admin/search.jsp">Search</a></li>
                <li><a href="/RBOneShop/pages/admin/report.jsp">Reports</a></li>
                <!-- still working on charts will be release soon -->
                <!--
                <li><a href="/RBOneShop/pages/admin/chart.jsp">Charts</a></li>                                                               
                -->
            </ul>            
            <!-- The following <ul> Part is being disabled intentionally -->
            <%-- 
            <ul class="nav navbar-nav pull-right" role="menu">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> My Account <span class="caret"></span></a>

                    <ul class="dropdown-menu"><li><a href="#"><span class="glyphicon glyphicon-home"></span> Profile</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="glyphicon glyphicon-off"></span> Log Out</a></li>
                    </ul><!-- end dropdown-menu -->
                </li>
            </ul><!-- end navbar pull-right -->
            --%>    
        </div><!-- end navbar-collapse -->  
    </div><!-- end container -->
</nav><!-- end navbar -->