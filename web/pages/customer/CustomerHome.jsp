<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>
        <div class="container" id="main">

            <%@include file="/design/customer_navigation.jsp" %>

            <div class="row" id="features">
                <c:forEach items="${pro}" var="prod">
                    <div class="col-sm-4 feature">                    
                        <div class="panel">
                            <a href="ProductList?method=fetch2&id=${prod.productid}"><img src="photo/${prod.photo}" alt="Sorry..!!" width="100" height="195" /></a>
                            <br>
                            <h3 class="panel-title">${prod.modelno}</h3>
                            <p class="price"><b>Price: <span>${prod.price}</span></b></p>
                            <a href="MasterOrderList?method=add&pid=${prod.productid}&itemname=${prod.modelno}&price=${prod.price}&opt=0" class="btn btn-warning btn-block"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</a>                       
                        </div><!-- end panel -->                
                    </div><!-- end feature -->               
                </c:forEach>
            </div><!-- end features -->

        </div><!-- end container -->

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
