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
    <title>代理业绩</title>
    <link href="<%=basePath%>static-web/css/style.css" rel="stylesheet"/>
</head>
<body style="background:#FEA500">
<%-- <body id="bg" style="background-image: url('<%=basePath%>static-web/img/bg.png');background-position: center center;background-repeat: no-repeat;background-size: cover;position: relative"> --%>

<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<div class="content">
    <div class="text-pay_all">
        <p class="text-font_all">代理佣金总计：<span style="color:#F44336">${member.agentTotalMoney}元</span></p>
        <p class="text-font_all">待发放佣金&nbsp;&nbsp;&nbsp;：<span style="color:#F44336">${member.unsendAgencyFee}元</span></p>
    </div>
    <div style="padding-top:15px;padding-bottom:10px;margin:0px;">
        <p style="line-height: 20px;color:#000000;font-size:14px;text-indent:2em">
            请注意，成为代理后请关注在线客服公众号以便联系客服和接受最新消息。佣金
            一元以上当日22点后系统自动发放代理佣金，直接发送到您的微信红包，请注意查收。
            佣金不足1元以上累计至一元以上当天晚上22点发放您的佣金！申请代理及其他问题请
            联系在线客服处理。
        </p>
    </div>
    <div class="Sweep ">
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
	    //整屏显示背景图片
	    $(function(){
	        var winH= $(window).height();
	        $("#bg").css("height",winH+"px");
	    });
	</script>
</body>
</html>