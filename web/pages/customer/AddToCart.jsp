<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <script>
        function aaa(id) {
            var a = confirm("Are you sure, you want to delete?");
            if (a) {

                document.thisform.pid.value = id;
                document.thisform.method.value = 'delete';
                document.thisform.action = "/RBOneShop/MasterOrderList";
                document.thisform.submit();
            }
        }

    </script>
    <body>

        <div class="container" id="main">

            <%@include file="/design/customer_navigation.jsp" %>

            <div class="row">
                <div class="col-sm-2" id="sidebar">
                    <%@include file="/design/categorysidebar.jsp" %>
                </div>

                <div class="col-sm-9">
                    <form name="thisform" id="thisform" action="/RBOneShop/MasterOrderList">
                        <input type="hidden" name="pid"/>
                        <input type="hidden" name="method"/>
                        <input type="hidden" name="opt" value="0"/>
                        <display:table id="data" class="table table-bordered" name="sessionScope.items" pagesize="3"  decorator="com.rboneshop.MyDecorator">

                            <display:column property="itemname" title="Item Name"/>
                            <display:column property="qty" title="Quantity"/>
                            <display:column property="price" title="Price"/>
                            <display:column property="subtotal" title="Sub Total"/>

                        </display:table>
                        <div align="center"><b>Grant Total</b> &nbsp; ${sessionScope.grant}</div>
                        <div align="center"><a href="/RBOneShop/BuyNow"><img src="/RBOneShop/images/buy.png" width="60" height="60"/></a></div>

                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
