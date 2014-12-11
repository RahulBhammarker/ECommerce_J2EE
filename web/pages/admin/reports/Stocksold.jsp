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
                    <form name="thisform" id="thisform" action="/RBOneShop/StockSold">
                        <h3>Stocks sold</h3>
                        <input type="hidden" name="method" value="dates"/>
                        <br>
                        <table class="table table-bordered">
                            <div class="form-group">
                                <label for="datepicker">From Date</label>
                                <input type="text" name="fromdate" class="form-control datepicker"></input>
                            </div>                         
                            <div class="form-group">
                                <label for="datepicker">To Date</label>
                                <input type="text" name="todate" class="form-control datepicker"></input>
                            </div>                         

                            <button type="submit" class="btn btn-default" value="Search">Search</button>
                            <button type="button" class="btn btn-default" value="Cancel" onclick="history.go(-1)">Cancel</button>                            
                        </table>

                    </form>
                    <br>
                    <display:table id="data" name="stocksold" class="table table-bordered" pagesize="10"  decorator="com.rboneshop.MyDecorator">
                        <display:column property="categoryname" title="Category Name"  media="html" sortable="true" group="1"/>
                        <display:column property="modelno" title="Product Model Number"  sortable="true"/>
                        <display:column property="units" title="Units Sold"  sortable="true"/>

                    </display:table> 

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
