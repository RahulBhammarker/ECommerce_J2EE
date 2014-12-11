<!DOCTYPE HTML>
<!-- html start -->
<html>
    <jsp:include page="/design/header.jsp"/>
    <script type="text/JavaScript">        
        function timedRedirect(redirectTo, timeoutPeriod) {
        ${sessionScope.uname=null}
        ${sessionScope.pwd=null}
        setTimeout("location.href = redirectTo;",timeoutPeriod);
        }        
    </script>
    <!-- body start -->
    <body onload="JavaScript:timedRedirect(redirectTo = '/RBOneShop/index.jsp', timeoutPeriod = '2000')">        
        <!-- main begin -->
        <div class="container" id="main">

            <div class="row" id="features">
                <div class="col-12">
                    <h2><b>Successfully Logged Out..!!</b></h2>
                    <h1>Thanks for visiting RB OneShop</h1><br>
                    <br><br><br>
                </div>
            </div><!-- end features -->
        </div><!-- end container -->

    </body><!-- body end -->
</html><!-- html end -->