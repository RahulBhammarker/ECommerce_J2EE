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
                    <form role="form" id="thisform" name="thisform" action="/RBOneShop/ProductList" enctype="multipart/form-data" method="post">
                        <h3>Add Product</h3>
                        <input type="hidden" name="opn" value="add"/>
                        <input type="hidden" name="todo" value="upload"/>
                        <table>
                            <div class="form-group">
                            <label>Category Name*</label>
                            <select class="form-control" name="categoryid" required>
                                <option value="">Select</option>${cat}
                            </select>                         
                            </div>
                            <div class="form-group">
                            <label>Price*</label>
                            <input type="text" class="form-control" name="price" required>
                            </div>
                            <div class="form-group">
                            <label>Material</label>
                            <input type="text" class="form-control" name="make">
                            </div>
                            <div class="form-group">
                            <label>Supplier Name*</label>
                            <select name="supplierid" class="form-control" required><option value="">Select</option>${supp}</select>
                            </div>                            
                            <div class="form-group">
                            <label>Model name*</label>
                            <input type="text" class="form-control" name="modelno" required/>
                            </div>
                            <div class="form-group">
                            <label>Description</label>
                            <input type="text" class="form-control" name="remarks"/>
                            </div>
                            <div class="form-group">
                            <label>Stock In Hand</label>
                           <input type="text" class="form-control" name="stockinhand" required/>
                            </div>
                            <div class="form-group">
                            <label>Photo*</label>
                            <input type="file"  name="uploadfile" required/>
                            <p class="help-block">Fromat should be .png or .jpg <br>Resolution : 400px x 400px</p>
                            </div>
                            
                            
                            <button type="submit" class="btn btn-default" value="Add">Add</button>
                            <button type="button" class="btn btn-default" value="Cancel" onclick="history.go(-1)">Cancel</button>                            
                        </table>

                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
