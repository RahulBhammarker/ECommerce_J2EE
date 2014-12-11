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
                        <h3>Update Product</h3>
                        <input type="hidden" name="opn" value="update"/>
                        <input type="hidden" name="todo" value="upload"/>
                        <input type="hidden" name="productid" value="${pro.productid}"/>
                        <table>
                            <div class="form-group">
                                <label>Category Name</label>
                                <select name="categoryid">
                                    <option value="${catid}">${catname}</option>${cat}
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input type="text" class="form-control" name="price" value="${pro.price}"/>
                            </div>
                            <div class="form-group">
                                <label>Material</label>
                                <input type="text" class="form-control" name="make" value="${pro.make}">
                            </div>
                            <div class="form-group">
                                <label>Photo</label>
                                <img src="photo/${pro.photo}" width="100px" height="195px"/>
                                <input type="hidden" class="form-control" name="uploadfile" value="${pro.photo}"/>
                                <br/> 
                                <input type="file"  name="uploadfile"/>
                            </div>
                            <div class="form-group">
                                <label>Supplier Name</label>
                                <select name="supplierid" class="form-control"><option value="${suppid}">${suppname}</option>${supp}</select>
                            </div>
                            <div class="form-group">
                                <label>Model Name*</label>
                                <input type="text" name="modelno" class="form-control" value="${pro.modelno}"/>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input type="text" name="remarks" class="form-control" value="${pro.remarks}"/>
                            </div>
                            <div class="form-group">
                                <label>Stock in hand</label>
                                <input type="text" name="stockinhand" class="form-control" value="${pro.stockinhand}"/>                                
                            </div>
                            
                            <button type="submit" class="btn btn-default" value="Update">Update</button>
                            <button type="button" class="btn btn-default" value="Cancel" onclick="history.go(-1)">Cancel</button>                            
                        </table>

                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
