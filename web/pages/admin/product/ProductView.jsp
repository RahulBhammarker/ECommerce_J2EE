<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>

        <div class="container" id="main">

            <%@include file="/design/admin_navigation.jsp" %>

            <div class="row">
                <div class="col-sm-2" id="sidebar">
                    <%@include file="/design/mastersidebar.jsp" %>
                </div>

                <div class="col-sm-9">
                    <div id="thisform">
                        <h3>View Product</h3>
                        <table class="table table-responsive">
                            <tr><td>Model Name</td><td> ${pro.modelno}</td></tr>
                            <tr><td>Category Name</td><td>${catname}</td></tr>
                            <tr><td>Price</td><td>${pro.price}</td></tr>
                            <tr><td>Make</td><td>${pro.make}</td></tr>
                            <tr><td>Photo</td><td><img src="photo/${pro.photo}" width="100px" height="195px"/></td></tr>
                            <tr><td>Supplier name</td><td> ${suppname}</td></tr>                            
                            <tr><td>Remarks</td><td> ${pro.remarks}</td></tr>
                            <tr><td>Stock in hand</td><td>${pro.stockinhand}</td></tr>
                            <tr><td colspan="2"> <input type="button" value="Back" onclick="history.go(-1)" /></td></tr></table>

                    </div>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
