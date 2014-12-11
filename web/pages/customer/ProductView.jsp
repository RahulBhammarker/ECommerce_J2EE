<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>

        <div class="container" id="main">

            <%@include file="/design/customer_navigation.jsp" %>

            <div class="row" id="thisform">
                
               
                    <div class="col-lg-2">
                        <table>
                            <tr><td><img src="photo/${pro.photo}" width="200px" height="390px"/></td></tr> 
                        </table>
                        
                    </div>
                    <div class="col-lg-offset-3">
                         <table class="table table-responsive">
                            <tr><td>Model Name</td><td> ${pro.modelno}</td></tr>                                                       
                            <tr><td>Price</td><td>${pro.price}</td></tr>
                            <tr><td>Material</td><td>${pro.make}</td></tr>                            
                            <tr><td>Description</td><td> ${pro.remarks}</td></tr>
                            <tr>
                                <td>
                                    <a href="MasterOrderList?method=add&pid=${pro.productid}&itemname=${pro.modelno}&price=${pro.price}&opt=0" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</a>
                                    &nbsp;
                                    <input type="button" value="Back" onclick="history.go(-1)" />
                                </td>
                            </tr>
                         </table>
                    </div>
                    

               
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
