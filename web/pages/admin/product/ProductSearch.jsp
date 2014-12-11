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
                    <form name="thisform" id="thisform" action="/RBOneShop/ProductList">
                        <h3>Product Search</h3>
                        <input type="hidden" name="method" value="search"/>
                        <br>
                        <table>
                            <div class="form-group">
                                <label>Category Name</label>
                                <select name="categoryid" class="form-control" required><option value=""></option>${cat}</select>
                            </div>                         

                            <button type="submit" class="btn btn-default" value="Search">Search</button>
                            <button type="button" class="btn btn-default" value="Cancel" onclick="history.go(-1)">Cancel</button>                            
                        </table>

                    </form>
                    <br>
                    <display:table id="data" name="sessionScope.catproductdetails" class="table table-bordered" pagesize="3"  decorator="com.rboneshop.MyDecorator">
                        <display:column property="modelno" title="Model No."/>
                        <display:column property="price" title="Price"/>
                        <display:column property="make" title="Make"/>

                    </display:table> 

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
