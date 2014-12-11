<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <script>
        function aaa(id) {
            var a = confirm("Are you sure, you want to delete?");
            if (a) {
                document.thisform.suppid.value = id;
                document.thisform.opn.value = 'delete';
                document.thisform.action = "/RBOneShop/SupplierList";
                document.thisform.submit();
            }
        }
    </script>
    <body>

        <div class="container" id="main">

            <%@include file="/design/admin_navigation.jsp" %>

            <div class="row">
                <div class="col-sm-2" id="sidebar">
                    <%@include file="/design/mastersidebar.jsp" %>
                </div>

                <div class="col-sm-9">
                    <form role="form" id="thisform" name="thisform">
                        <input type="hidden" name="suppid"/>
                        <input type="hidden" name="opn"/>
                        <h3>Supplier Detail</h3>
                        <br>
                        <a href="/RBOneShop/pages/admin/supplier/SupplierAdd.jsp"><span class="glyphicon glyphicon-plus"></span>&nbsp;Add</a>
                        <br>
                        <div class="table-responsive">
                            <display:table id="data" class="table table-bordered" name="sessionScope.suppdetails" pagesize="3"  decorator="com.rboneshop.MyDecorator">
                                <display:column property="suppcompany" title="Company"/>
                                <display:column property="contactperson" title="Contcact Person"/>
                                <display:column property="address" title="Address"/>
                                <display:column property="phone" title="Phone"/>
                                <display:column property="mobile" title="Mobile"/>
                                <display:column property="email" title="Email"/>
                                <display:column property="webaddress" title="Web Address"/>
                                <display:column property="sedit" title="Edit"/>
                                <display:column property="sdelete" title="Delete"/>
                            </display:table>
                        </div>
                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
