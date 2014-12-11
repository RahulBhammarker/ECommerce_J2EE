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
                    <form role="form" id="thisform" action="/RBOneShop/SupplierList">
                        <h3>Update Supplier</h3>
                        <input type="hidden" name="opn" value="update"/>
                        <input type="hidden" name="suppid" value="${supp.suppid}"/>
                        <table>
                            <div class="form-group">
                            <label>Supplier Company</label>
                            <input type="text" class="form-control" name="suppcompany" value="${supp.suppcompany}">
                            </div>
                            <div class="form-group">
                            <label>Contact Person</label>
                            <input type="text" class="form-control" name="contactperson" value="${supp.contactperson}">
                            </div>
                            <div class="form-group">
                            <label>Address</label>
                            <input type="text" class="form-control" name="address" value="${supp.address}">
                            </div>
                            <div class="form-group">
                            <label>Phone No.</label>
                            <input type="tel" class="form-control" name="phone" value="${supp.phone}">
                            </div>
                            <div class="form-group">
                            <label>Mobile No.</label>
                            <input type="tel" class="form-control" name="mobile" value="${supp.mobile}">
                            </div>
                            <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" value="${supp.email}">
                            </div>
                            <div class="form-group">
                            <label>Web Address</label>
                            <input type="url" class="form-control" name="webaddress" value="${supp.webaddress}">
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
