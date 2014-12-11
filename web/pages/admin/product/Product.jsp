<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <script>
            function aaa(id){
                var a=confirm("Are you sure, you want to delete?");
                if(a){
                    document.thisform.productid.value=id;
                    document.thisform.method.value='delete';
                    document.thisform.action="/RBOneShop/ProductList";
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
                        <input type="hidden" name="productid"/>
                        <input type="hidden" name="method"/>
                        <h3>Product Detail</h3>
                        <br>
                        <a href="/RBOneShop/ProductList?method=add"><span class="glyphicon glyphicon-plus"></span>&nbsp;Add</a>
                        <br>
                        <div class="table-responsive">
                            <display:table id="data" class="table table-bordered" name="sessionScope.productdetails" pagesize="10"  decorator="com.rboneshop.MyDecorator">
                                <display:column property="modelno" title="Name"/>
                                <display:column property="categoryname" title="Category Name"/>
                                <display:column property="price" title="Price"/>
                                <display:column property="make" title="Make"/>
                                <display:column property="pview" title="View" />
                                <display:column property="pedit" title="Edit" />
                                <display:column property="pdelete" title="Delete"/>
                            </display:table>
                        </div>
                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
