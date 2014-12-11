<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

    <body>

        <div class="container" id="main">

            <%@include file="/design/admin_navigation.jsp" %>

            <div class="row">
                <div class="col-sm-2" id="sidebar">
                    <%@include file="/design/reportsidebar.jsp" %>
                </div>

                <div class="col-sm-9">
                    <div id="thisform">
                    <h3> Stocks In Hands</h3>

                    <display:table id="data" class="table table-bordered" name="stockleft" pagesize="10"  decorator="com.rboneshop.MyDecorator">
                        <display:column property="categoryname" title="Category Name"  media="html" sortable="true" group="1"/>
                        <display:column property="modelno" title="Product Model Number"  sortable="true"/>
                        <display:column property="units" title="Stock In hand"  sortable="true"/>

                    </display:table>
                    </div>
                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>
        <script>
            $(function () {
                $(".datepicker").datepicker({
                    changeMonth: true,
                    changeYear: true
                });
            });
        </script>
    </body><!-- end of body -->
</html><!-- end html -->
