<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><g:layoutTitle default="Dashboard"/></title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="//code.ionicframework.com/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <asset:stylesheet src="AdminLTE/application.css" />

    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

    <g:layoutHead/>
</head>
<body class="skin-black">
<!-- header logo: style can be found in header.less -->
<header class="header">
    <a href="index.html" class="logo">
        <!-- Add the class icon to your logo image or logo icon to add the margining -->
        <asset:image src="icon-48x48.png" class="icon pull-left"/>
        FnUI
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <sec:ifLoggedIn>
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-user"></i>
                        <span><sec:username/> <i class="caret"></i></span>
                    </a>
                    <ul class="dropdown-menu">
                        %{--<!-- User image -->--}%
                        %{--<li class="user-header bg-light-blue">--}%
                            %{--<img src="../img/avatar3.png" class="img-circle" alt="User Image" />--}%
                            %{--<p>--}%
                                %{--Jane Doe - Web Developer--}%
                                %{--<small>Member since Nov. 2012</small>--}%
                            %{--</p>--}%
                        %{--</li>--}%
                        %{--<!-- Menu Body -->--}%
                        %{--<li class="user-body">--}%
                            %{--<div class="col-xs-4 text-center">--}%
                                %{--<a href="#">Followers</a>--}%
                            %{--</div>--}%
                            %{--<div class="col-xs-4 text-center">--}%
                                %{--<a href="#">Sales</a>--}%
                            %{--</div>--}%
                            %{--<div class="col-xs-4 text-center">--}%
                                %{--<a href="#">Friends</a>--}%
                            %{--</div>--}%
                        %{--</li>--}%
                        %{--<!-- Menu Footer-->--}%
                        <li class="user-footer">
                            %{--<div class="pull-left">--}%
                                %{--<a href="#" class="btn btn-default btn-flat">Profile</a>--}%
                            %{--</div>--}%
                            <div class="pull-right">
                                <g:form controller="logout" action="index" method="POST">
                                    <g:submitButton class="btn btn-default btn-flat" name="Sign out" />
                                </g:form>
                            </div>
                        </li>
                    </ul>
                </li>
                </sec:ifLoggedIn>
            </ul>
        </div>
    </nav>
</header>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <adminlte:mainNavigation />
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Right side column. Contains the navbar and content of the page -->
    <aside class="right-side">
        <g:layoutBody/>
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->


<!-- jQuery 2.0.2 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->

<asset:javascript src="AdminLTE/application.css" />

</body>
</html>
