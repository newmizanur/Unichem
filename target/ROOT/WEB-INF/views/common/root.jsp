<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>
        <tiles:getAsString name="pageTitle" ignore="true"/>
    </title>

    <!-- Bootstrap Core CSS -->
    <link href="/contents/<c:out value='${applicationVersion}'/>/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/contents/<c:out value='${applicationVersion}'/>/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/contents/<c:out value='${applicationVersion}'/>/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/contents/<c:out value='${applicationVersion}'/>/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <!--Top Navigation -->
        <tiles:insertAttribute name="topNavigation"/>

        <!--Left Side Navigation -->
        <tiles:insertAttribute name="leftSideNavigation"/>
    </nav>



    <!-- #content -->
<tiles:insertAttribute name="content"/>


</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="/contents/<c:out value='${applicationVersion}'/>/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/contents/<c:out value='${applicationVersion}'/>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/contents/<c:out value='${applicationVersion}'/>/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/contents/<c:out value='${applicationVersion}'/>/dist/js/sb-admin-2.js"></script>

</body>

</html>
