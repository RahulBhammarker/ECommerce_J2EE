<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>

        <div class="container" id="main">

            <%@include file="/design/customer_navigation.jsp" %>

            <div class="row">
                

                <div class="col-12">
                    <form role="form" id="thisform" action="/RBOneShop/CategoryList">
                        <h3>Your Profile</h3>
                        <input type="hidden" name="opn" value="update"/>
                        <table>
                            <input type="hidden" name="customerid" value="${cust.customerid}" />
                            <div class="form-group">
                            <label>Username : </label>
                            <input type="text" class="form-control" name="cusername" value="${cust.cusername}">
                            </div>
                            <div class="form-group">
                            <label>Password : </label>
                            <input type="password" class="form-control" name="cpassword" value="${cust.cpassword}">
                            </div>
                            <div class="form-group">
                            <label>Name : </label>
                            <input type="text" class="form-control" name="name" value="${cust.name}" required >
                            </div>
                            <div class="form-group">
                            <label>Address : </label>
                            <input type="text" class="form-control" name="address" value="${cust.address}" required >
                            </div>
                            <div class="form-group">
                            <label>Mobile No : </label>
                            <input type="tel" class="form-control" name="mobile" value="${cust.mobile}" required >
                            </div>
                            <div class="form-group">
                            <label>Email : </label>
                            <input type="email" class="form-control" name="email" value="${cust.email}" required >
                            </div>
                            
                            
                            <button type="submit" class="btn btn-default" value="Add">Update</button>
                            <button type="button" class="btn btn-default" value="Cancel" onclick="history.go(-1)">Cancel</button>                            
                        </table>

                    </form>

                </div>
            </div><!-- end container -->

        </div>

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
</html><!-- end html -->
