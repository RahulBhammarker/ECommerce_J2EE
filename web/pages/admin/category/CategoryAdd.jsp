<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>

        <div class="container" id="main">

            <%@include file="/design/admin_navigation.jsp" %>

            <div class="row">
                <div class="col-sm-2" id="sidebar">
                    <%@include file="/design/mastersidebar.jsp" %>
                </div>

                <div class="col-sm-9">
                    <form role="form" id="thisform" name="thisform" action="/RBOneShop/CategoryList">
                        <h3>Add Category</h3>
                        <input type="hidden" name="opn" value="add"/>
                        <table>
                            <div class="form-group">
                            <label>Category Name : </label>
                            <input type="text" class="form-control" name="jcatname">
                            </div>
                            <div class="form-group">
                            <label>Category Details* : </label>
                            <input type="text" class="form-control" name="jcatdetails" required >
                            </div>
                            
                            
                            <button type="submit" class="btn btn-default" value="Add">Submit</button>
                            <button type="button" class="btn btn-default" value="Cancel" onclick="history.go(-1)">Cancel</button>                            
                        </table>

                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
