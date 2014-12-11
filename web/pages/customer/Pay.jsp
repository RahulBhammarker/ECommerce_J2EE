<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>

    <body>

        <div class="container" id="main">

            <%@include file="/design/customer_navigation.jsp" %>

            <div class="row">
                

                <div class="col-12" id="thisform">
                    <form action="" class="table table-responsive">
                        <div class="table table-bordered">
                        <div>
                            <b>Name</b> &nbsp; ${sessionScope.name} &nbsp;
                        </div>
                        <div> 
                            <b>Phone No</b> &nbsp; ${sessionScope.phno}
                        </div>
                        <div> 
                            <b>Email Id</b> &nbsp; ${sessionScope.email}
                        </div>

                        <div>
                            <b>Address</b> &nbsp; ${sessionScope.addr}
                        </div>
                        </div>

                        <display:table id="data" class="table table-bordered" name="sessionScope.items" pagesize="3"  decorator="com.rboneshop.MyDecorator">

                            <display:column property="itemname" title="Item Name"/>
                            <display:column property="qty" title="Quantity"/>
                            <display:column property="price" title="Price"/>
                            <display:column property="subtotal" title="Sub Total"/>
                        </display:table>
                        <div align="center"><b>Grant Total</b> &nbsp; ${sessionScope.grant}</div>
                        <div align="center"><b><a href="/RBOneShop/OrdersList?opn=add">Print</a></b></div>
                       

                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
