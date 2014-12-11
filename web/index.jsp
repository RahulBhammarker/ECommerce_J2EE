<!DOCTYPE HTML>
<!-- html start -->
<html>
    <jsp:include page="/design/header.jsp"/>
    <!-- body start -->
    <body>        
        <!-- main begin -->
        <div class="container" id="main">

            <div class="row" id="bigCallout">
                <div class="col-12">
                    <h1>Welcome To RB OneShop Portal</h1><br>
                    <p>Choose the user type..!!</p>
                    <br>
                    <a href="" id="alertMe" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-user"></span> Admin Page</a>

                    <div class="alert alert-success alert-block fade in" id="successAlert">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>

                        <h4>Admin Login<a href="pages/admin/adminhome.jsp"><span>.</span></a></h4>
                        <form role="form" action="AdminList" method="post">                            
                            <div class="form-group">
                                <label for="user">User</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter Admin User Id">
                            </div>
                            <div class="form-group">
                                <label for="pass">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                    </div><!-- end alert -->
                    
                    <br>

                    <a href="CustomerHome?" type="button" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-shopping-cart"></span> Customer Page</a>

                </div>
            </div><!-- end features -->
        </div><!-- end container -->
        <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/script.js" type="text/javascript"></script>  

    </body><!-- body end -->
</html><!-- html end -->