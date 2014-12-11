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
                    <form name="thisform" id="thisform" action="/RBOneShop/CustomersOrders">
                        <h3>Customers Orders</h3>
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
                    <display:table id="data" name="customerorders" class="table table-bordered" pagesize="10"  decorator="com.rboneshop.MyDecorator">
                        <display:column property="name" title="Customer Name" media="html" sortable="true" group="1"/>
                        <display:column property="address" title="Address" media="html" sortable="true" group="1"/>
                        <display:column property="mobile" title="Mobile Number" media="html" sortable="true" group="1"/>
                        <display:column property="date" title="Order Date"/>
                        <display:column property="amount" title="Order Amount"/>

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
