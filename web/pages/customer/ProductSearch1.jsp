<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>
        <div class="container" id="main">

            <%@include file="/design/customer_navigation.jsp" %>

            <div class="row" id="features">
                <div class="col-12">
                    <h3>${prodetails.modelno}</h3>
                    <a href="#"><img src="photo/${prodetails.photo}" alt="Red Bell" width="200" height="390" /></a>
                    <p class="price">Price: <span>${prodetails.price}</span></p>
                    <a href="MasterOrderList?method=add&pid=${prodetails.productid}&itemname=${prodetails.modelno}&price=${prodetails.price}&opt=0" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</a>

                </div>
            </div><!-- end features -->

        </div><!-- end container -->

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
