<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>联系客服</title>
    <link href="<%=basePath%>static-web/css/style.css" rel="stylesheet"/>
    <script src="<%=basePath%>static-web/js/jquery-1.8.3.min.js"></script>
</head>
<body style="background:#FEA500">
<%-- <body id="bg" style="background-image: url('<%=basePath%>static-web/img/bg.png');background-position: center center;background-repeat: no-repeat;background-size: cover;position: relative"> --%>

<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<div class="content"  style="padding:0px 15px 0px 0px ">
    <div class="Sweep">
        <p style="font-size:12px;color:#999999;padding-bottom: 10px;">如有疑问请扫描以下二维码关注公众号，联系在线客服！</p>
        <div style="border:1px solid #333;border-radius:5px">
            <img src="<%=basePath%>static-web/img/qrcode.jpg" style="width:80%"/>
        </div>
    </div>
</div>

<!-- 底部 -->
<jsp:include page="footer.jsp"></jsp:include>
<div class="position"></div>
	<script>
	
		//控制文本上下左右居中
	 	window.onload = function() {
	        jQuery.fn.center = function() {
	            this.css("position", "absolute");
	            this.css("top", ($(window).height() - this.height()) / 2 + $(window).scrollTop() + "px");
	            this.css("left", ($(window).width() - this.width()) / 2 + $(window).scrollLeft() + "px");
	            return this;
	        }
	        $(".content").center();
	        window.onscroll = $('.content').center();
	        window.onresize = $('.content').center();
	        window.onload = $('.content').center();
	    }
	    //整屏显示背景图片
	    $(function(){
	        var winH= $(window).height();
	        $("#bg").css("height",winH+"px");
	    });
	</script>
</body>
</html>