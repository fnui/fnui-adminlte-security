<!DOCTYPE html>
<html class="bg-black">
<head>
    <meta charset="UTF-8">
    <title><g:message code="springSecurity.denied.title" /></title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Theme style -->
    <asset:stylesheet src="AdminLTE/application.css" />
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
</head>

<body class="bg-black">

<div class="form-box" id="login-box">
    <div class="header">Sign In</div>
    <g:if test='${flash.message}'>
        <div class='callout callout-danger'><g:message code="springSecurity.denied.message"/></div>
    </g:if>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>

