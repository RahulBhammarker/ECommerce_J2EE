<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>

        <div class="container" id="main">

            <%@include file="/design/admin_navigation.jsp" %>

            <div class="row">
                <div class="col-sm-2" id="sidebar">
                    <%@include file="/design/searchsidebar.jsp" %>
                </div>

                <div class="col-sm-9">
                    <form name="thisform" id="thisform" action="/RBOneShop/CustomerList">
                        <h3>Customer Search</h3>
                        <input type="hidden" name="method" value="search"/>
                        <br>
                        <table>
                            <div class="form-group">
                            <label>Customer Name</label>
                            <input type="text" class="form-control" name="customer">
                            </div>                         
                            
                            <button type="submit" class="btn btn-default" value="Search">Search</button>
                            <button type="button" class="btn btn-default" value="Cancel" onclick="history.go(-1)">Cancel</button>                            
                        </table>

                    </form>
                    <br>
                    <display:table id="data" class="table table-bordered" name="sessionScope.customerdetails" pagesize="10" >
                        <display:column property="name" title="Name"/>
                        <display:column property="address" title="Address"/>
                        <display:column property="mobile" title="Mobile"/>
                        <display:column property="email" title="Email"/>

                    </display:table> 
                    
                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
