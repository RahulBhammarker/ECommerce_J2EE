<!-- head start -->
<head>
    <meta charset="utf-8">
    <title>RBOneShop</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <link rel="shortcut icon" href="/RBOneShop/images/rblogo.ico" />
    <link href="/RBOneShop/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/RBOneShop/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">

    function abc(){
        //alert("search"+document.getElementById('input_field').value);
        var a = document.getElementById('input_field').value;
        var lnk = document.getElementById('search');
        lnk.href = "/RBOneShop/ProductList?method=searchmenu&modelno="+a;
        lnk.click();
    }

    </script>    

</head><!-- head end -->