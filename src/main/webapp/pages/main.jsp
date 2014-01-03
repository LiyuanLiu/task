<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script>
        $(document).ready(function(){
            $.ajax({
                type:"GET",
                url:"/online/${user.userCode}/news",
                data:{"areaCode":"Beijing"},
                success:function(data){$('#content').html(data);},
                error:function(error){ alert(error);}
            });
        });
        $(document).ready(function(){
            $.ajax({
                type:"GET",
                url:"/online/task/${user.userCode}/queryUnderTask",
                success: function(data){
                    var innerHtml ="";
                    var tasks = data.underTasks;
                    for(var i=0; i< tasks.length; i++){
                        innerHtml += "<a href='/{id}/showTask'>${task.taskName}</a>";
                    }
                    if(innerHtml == null || innerHtml == "" || innerHtml == "undefined"){
                        $('#links').html("无代办任务");
                    }else{
                        $('#links').html(innerHtml);
                    }

                } ,
                error:function(error){
                    $('#links').html(error);
                }
            });

        });
    </script>
</head>
<body class="bodyStyle">
<div class="skipLinks">skip to: <a href="#content">page content</a> | <a href="#pageNav">links on this page</a> | <a href="#globalNav">site navigation</a> | <a href="#siteInfo">footer (site information)</a> </div>
<div id="masthead">
    <h1 id="siteName">任务跟踪</h1>
    <div id="info"> <a href="####">登录</a> | <a href="#">注册</a></div>
    <div id="globalNav"> <img alt="" src="../images/gblnav_left.gif" height="32" width="4" id="gnl" /> <img alt="" src="../images/glbnav_right.gif" height="32" width="4" id="gnr" />
    <div id="globalLink">
        <a href="/online/task/${user.userCode}/taskMain" id="gl1" class="glink">我的任务</a>
        <a href="/online/${user.userCode}/roadMap" id="gl2" class="glink">我的成长之路</a>
        <a href="/online/${user.userCode}/myHoby" id="gl3" class="glink">我的爱好</a>
        <a href="/online/${user.userCode}/friendship" id="gl4" class="glink">朋友圈</a>
        <a href="/online/${user.userCode}/contactUs" id="gl5" class="glink">联系我哦</a>
        <a href="/online/${user.userCode}/admin" id="gl6" class="glink" style="display: none">管理员</a></div>
        <form id="search" action="">
            <input name="searchFor" type="text" size="10" />
            <a href="">search</a>
        </form>
    </div>
    <div id="subglobal1" class="subglobalNav">
        <a href="#">subglobal1 link</a> |
        <a href="#">subglobal1 link</a> |
        <a href="#">subglobal1 link</a> |
        <a href="#">subglobal1 link</a> |
        <a href="#">subglobal1 link</a> |
        <a href="#">subglobal1 link</a> |
        <a href="#">subglobal1 link</a>
    </div>
    <div id="pagecell1">
        <img alt="" src="../images/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="../images/tr_curve_white.gif" height="6" width="6" id="tr" />
        <!--子路径，待修改
        <div id="breadCrumb"> <a href="#">Breadcrumb</a> / <a href="#">Breadcrumb</a> / <a href="#">Breadcrumb</a> / </div> -->
        <!--当前页面位置，待修改-->
        <div id="pageName"><h2>Page Name</h2><img alt="small logo" src="" height="59" width="66"/> </div>
        <div id="pageNav">
            <div id="relatedLinks">
                <h3>代办任务</h3>
                <div id="links"></div>
            </div>
            <!--大目录，待修改
            <div id="sectionLinks"> <a href="#">Section Link</a> <a href="#">Section Link</a> <a href="#">Section Link</a> <a href="#">Section Link</a> <a href="#">Section Link</a> <a href="#">Section Link</a> </div> -->
            <!--子目录，待修改
            <div class="relatedLinks">
                <h3>Related Link Category</h3>
                <a href="#">Related Link</a> <a href="#">Related Link</a> <a href="#">Related Link</a> <a href="#">Related Link</a> <a href="#">Related Link</a> <a href="#">Related Link</a> </div> -->
            <!--广告位，待修改-->
            <div id="advert"> <img src="" alt="" width="107" height="66" /> Advertisement copy goes here. Advertisement copy goes here. </div>
        </div>
        <div id="content">
        </div>
        <div id="siteInfo"> <img src="" width="44" height="22" /> <a href="#">About Us</a> | <a href="#">Site Map</a> | <a href="#">Privacy Policy</a> | <a href="#">Contact Us</a> | &copy;2003 Company Name </div>
    </div>
</div>
</body>
<script type="text/javascript">
  /*
    var menuitem1 = new menu(7,1,"hidden");
    var menuitem2 = new menu(7,2,"hidden");
    var menuitem3 = new menu(7,3,"hidden");
    var menuitem4 = new menu(7,4,"hidden");
    var menuitem5 = new menu(7,5,"hidden");
    var menuitem6 = new menu(7,6,"hidden");
    var menuitem7 = new menu(7,7,"hidden"); */
</script>
</html>