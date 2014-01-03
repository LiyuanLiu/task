<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../css/main.css" type="text/css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.change.js"></script>
    <script type="text/javascript" src="../js/messages_zh.js"></script>
    <script type="text/javascript" src="../js/validator.js"></script>
    <script type="text/javascript" src="../js/function.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            slide();
            autoSlide();
        });
    </script>
</head>
<body class="bodyStyle">
<div id="masthead">
    <h1 id="siteName">任务跟踪</h1>
    <div id="info"><a href="#">注册</a></div>
    <div id="pagecell1">
        <div id="pageName"><h2>Welcome to online!</h2></div>
        <div id="scrollImgs" class="leftImg">
            <div class="slideBox" id="slideBox">
                <div class="slide slide01">
                    <a href="#" class="pic"><img src="../images/1.jpg"></a>
                    <span class="txt"><a href="#">酷跑11111111111</a></span>
                </div>
                <div class="slide slide02">
                    <a href="#" class="pic"><img src="../images/2.jpg"></a>
                    <span class="txt"><a href="#">酷跑2222222222</a></span>
                </div>
                <div class="slide slide03">
                    <a href="#" class="pic"><img src="../images/3.jpg"></a>
                    <span class="txt"><a href="#">酷跑33333333333</a></span>
                </div>
                <div class="slide slide04">
                    <a href="#" class="pic"><img src="../images/4.jpg"></a>
                    <span class="txt"><a href="#">酷跑44444444444</a></span>
                </div>
                <div class="slide slide05">
                    <a href="#" class="pic"><img src="../images/5.jpg"></a>
                    <span class="txt"><a href="#">酷跑55555555555</a></span>
                </div>
                <ul class="btns">
                    <li class="current"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                </ul>
            </div>
        </div>

        <div id="login" class="loginForm">
            <form id="loginForm1" action="/online/login/doLogin" method="post">
                <table align="center" border="1" cellpadding="5px" height="300px" width="400px">
                    <tr align="left" >
                        <td height="34px">UserName</td><td><input type="text" name="userName" id="userName"></td>
                    </tr>
                    <tr align="left" >
                        <td height="34px">Password</td><td><input type="password" name="userPassword" id="userPassword"></td>
                    </tr>
                    <tr align="left">
                        <td height="34px"><a href="javascript:void(0);" onclick="login()">login</a></td>
                    </tr>
                </table>
            </form>

        </div>
        <div id="siteInfo"> <img src="" width="44" height="22" /> <a href="#">About Us</a> | <a href="#">Site Map</a> | <a href="#">Privacy Policy</a> | <a href="#">Contact Us</a> | &copy;2003 Company Name </div>
    </div>
</div>
</body>
</html>