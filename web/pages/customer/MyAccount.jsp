<!DOCTYPE html>
<!-- html begin -->
<html>
    <%@include file="/design/header.jsp" %>
    <body>
        <div class="container" id="main">

            <%@include file="/design/customer_navigation.jsp" %>

            <div class="row" id="features">
                <div class="col-md-6">
                    <form action="/RBOneShop/CustomerList" method="post">
                        <table>                            
                            <input type="hidden" name="method" value="register"/>
                            <div>                              
                                <img src="/RBOneShop/images/Key.png" width="150px" height="150px"  />
                                <h3>Already have an Account?</h3>
                            </div>
                            <br>
                            <h3>Login</h3>
                            <div class="form-group">
                                <label for="uname" class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="uname" id="uname" placeholder="Email" required>
                                </div>
                            </div>                          
                            <div class="form-group">
                                <label for="uname" class="col-sm-2 control-label">Password</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" name="pwd" id="pwd1">
                                </div>
                            </div>                   
                            <div class="form-group">
                                <div class="col-sm-6">
                                    <button type="submit" class="btn btn-default" value="Log in">Submit</button>
                                </div>
                            </div>                            
                        </table>
                    </form> 
                </div>

                <img src="/RBOneShop/images/line.PNG"  height="350px" valign="center" align="left"/>

                <div class="col-md-offset-7">
                    <form role="form" action="/RBOneShop/CustomerList" method="post"> 
                        <table width="100%">
                            <h3>OR Fill this form to Sign Up</h3>
                            <input type="hidden" name="opn" value="add">
                            <tr><td>Username*</td><td><input type="text" class="form-control" name="cusername" required/></td></tr>
                            <tr><td>Password*</td><td> <input type="password" class="form-control" name="cpassword" required/></tr>
                            <tr><td>Name*</td><td> <input type="text" name="name" class="form-control" required/></td></tr>
                            <tr><td>Address*</td><td> <input type="text" class="form-control" name="address" required/></td></tr>
                            <tr><td>Mobile No.*</td><td> <input type="text" class="form-control" name="mobile" required/></td></tr>
                            <tr><td>Email Id*</td><td> <input type="text" class="form-control" name="email" required/></td></tr>
                            <tr><td>&nbsp;</td></tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td align="center"><button type="submit" class="btn btn-default btn-block">Submit</button></td>
                            </tr>
                        </table>
                    </form>
                </div>

            </div><!-- end features -->

        </div><!-- end container -->

        <%@include file="/design/footer.jsp" %>

    </body><!-- end of body -->
    
</html><!-- end html -->
