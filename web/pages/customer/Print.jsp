<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>

    <body onload="window.print()">

        <div class="container" id="main">

            <%@include file="/design/customer_navigation.jsp" %>

            <div class="row">
                <div class="col-12">
                    <div align="center">                        
                        <h1><img src="/RBOneShop/images/rblogo.jpg" alt="" height="50" width="50"/>ne Shop</h1>
                        <br><br>
                        <h2>Invoice</h2>
                        <table class="table table-bordered" id="thisform">
                            <tr>
                                <td>
                                    <b>Name</b>&nbsp; ${sessionScope.name}<br/>
                                    <b>Phone No</b> &nbsp; ${sessionScope.phno}<br/>
                                    <b>Email Id</b> &nbsp; ${sessionScope.email}</td>
                                <td>
                                    <b>Address</b> &nbsp; ${sessionScope.addr}</td>
                            </tr>
                        </table>

                        <display:table id="data" class="table table-bordered" name="sessionScope.items" pagesize="15"  decorator="com.rboneshop.MyDecorator">

                            <display:column property="itemname" title="Item Name"/>
                            <display:column property="qty" title="Quantity"/>
                            <display:column property="price" title="Price"/>
                            <display:column property="subtotal" title="Sub Total"/>
                        </display:table>
                        <div align="right"><b>Grant Total</b> &nbsp; ${sessionScope.grant}</div>
                    </div>
                </div>
            </div>

        </div><!-- end container -->


    </body><!-- end of body -->
</html><!-- end html -->
