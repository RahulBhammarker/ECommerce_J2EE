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
                <li class="active"><a href="CustomerHome">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Category <strong class="caret"></strong></a>

                    <ul class="dropdown-menu">
                        <c:forEach items="${cat}" var="cate">
                            <li><a href="CustomerHome?id=${cate.jcatid}">${cate.jcatname}</a></li>   
                        </c:forEach>     
                    </ul><!-- end dropdown-menu -->

                </li>                                               
            </ul>
            <form class="navbar-form pull-left">
                <input type="text" name="option" size="10" id="input_field" class="form-control" placeholder="Enter product name..">
                <a id="search" href="#" onclick="abc()"><span class="glyphicon glyphicon-search"></span></a>
            </form><!-- end form -->


            <ul class="nav navbar-nav pull-right">
                
                <c:choose>
                    <c:when test="${sessionScope.uname!=null}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Your Account <span class="caret"></span></a>
                            
                            <ul class="dropdown-menu">
                                <li> <a href="/RBOneShop/CustomerList?method=fetch"><span class="glyphicon glyphicon-home"></span> Profile</a></li>
                                <li class="divider"></li>
                                <li><a href="/RBOneShop/pages/customer/Logout.jsp"><span class="glyphicon glyphicon-off"></span> Logout</a></li>                                
                            </ul> 
                        </li>
                        
                        <li class="nav navbar-form pull-right" id="cart"><span class="glyphicon glyphicon-shopping-cart"></span>${sessionScope.size}&nbsp;</li>                        
                        
                    </c:when>

                    <c:otherwise>
                        <li><a href="/RBOneShop/pages/customer/MyAccount.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
                    </c:otherwise>
                </c:choose>
                                
            </ul><!-- end navbar pull-right -->
            
        </div><!-- end navbar-collapse -->  
        
    </div><!-- end container -->
    
</nav><!-- end navbar -->