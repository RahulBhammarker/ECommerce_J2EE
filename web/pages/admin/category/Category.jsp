<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <script>
        function aaa(id) {
            var a = confirm("Are you sure, you want to delete?");
            if (a) {
                document.thisform.jcatid.value = id;
                document.thisform.opn.value = 'delete';
                document.thisform.action = "/RBOneShop/CategoryList";
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
                        <input type="hidden" name="jcatid"/>
                        <input type="hidden" name="opn"/>
                        <h3>Category Detail</h3>
                        <br>
                        <a href="/RBOneShop/pages/admin/category/CategoryAdd.jsp"><span class="glyphicon glyphicon-plus"></span>&nbsp;Add</a>
                        <br>
                        <div class="table-responsive">
                            <display:table id="data" name="sessionScope.catdetails" class="table table-bordered" pagesize="3"  decorator="com.rboneshop.MyDecorator">
                                <display:column property="jcatname" title="Name"    />
                                <display:column property="jcatdetails" title="Details"   />
                                <display:column property="cedit" title="Edit" />
                                <display:column property="cdelete" title="Delete"/>
                            </display:table>
                        </div>
                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
