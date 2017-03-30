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
	    <title>推广二维码</title>
	   	<link href="<%=basePath%>static-web/css/style.css" rel="stylesheet"/>
	   	<script src="<%=basePath%>static-web/js/jquery-1.8.3.min.js"></script>
	   	<script src="<%=basePath%>static-web/js/jquery.qrcode.js"></script>
	   	<script src="<%=basePath%>static-web/js/qrcode.js"></script>
	   	<style type="text/css">
        .positionFixed{
            text-align: center;
            width: 100%;
            position:absolute;
	        bottom:34%;
        }
        .center{
            position:relative;
            padding:15px 0px;
            text-align: center;
            width: 100%;
            z-index:-1;
            margin-top:-40px;
        }
       .text-head {
            text-align: center;
            padding-top: 5px;
            padding-bottom: 5px;
         }
         .text-head_all {
            text-align: center;
            padding-top: 5px;
            padding-bottom: 5px;
         }
        .red-weixin{
            font-size:50px;
            color:#ffffff;
            line-height: 60px;
        }
        .pay-weixin{
            font-size:33px;
            color:#ffffff;
            line-height: 60px;
        }
        .payPacket{
            color:#ffffff;
            font-size:20px;
            line-height:30px;
        }
        @media screen and (max-width:321px){
            .text-head {
                text-align: center;
                padding-top: 5px;
                padding-bottom: 5px;
            }
            .text-head_all {
                text-align: center;
                padding-top: 5px;
                padding-bottom: 15px;
            }
            .red-weixin{
                font-size: 38px;
                color: #ffffff;
                line-height: 45px;
            }
            .pay-weixin{
                font-size: 25px;
                color: #ffffff;
                line-height: 40px;
            }
            .payPacket{
                color:#ffffff;
                font-size:16px;
                line-height:30px;
            }
        }
        @media screen and (min-width:321px) and (max-width:376px){
            .text-head {
                text-align: center;
                padding-top: 5px;
                padding-bottom: 5px;
            }
            .red-weixin{
                font-size: 45px;
                color: #ffffff;
                line-height: 50px;
            }
            .pay-weixin{
                font-size: 29px;
                color: #ffffff;
                line-height: 54px;
            }
            .payPacket{
                color:#ffffff;
                font-size:18px;
                line-height:30px;
            }
        }
    </style>
	</head>
	<body style="background:#FEA500">
		<div class="text-head_all" style="z-index: 99999999;">
		    <p class="red-weixin">微信红包</p>
		    <p class="pay-weixin">微信安全支付</p>
		    <div class="positionFixed">
		        <a><img src="${fileUrl}" style="width:35%;"/></a>
		    </div>
		</div>
		<div class="center" style="padding:0px;">
		    <img src="<%=basePath%>static-web/img/red-bg.png" style="width:80%;" />
		</div>
		
		<div class="text-head"  style="margin-top:-55px;">
		    <p class="red-weixin">抢红包</p>
		    <p class="pay-weixin">游戏规则</p>
		    <p class="payPacket">支付10元抢1-200元红包</p>
<!-- 		    <p class="payPacket">加入代理免费即享6%佣金</p> -->
			<p class="payPacket">申请代理，请联系在线微信客服</p>
		</div>
<!-- 	    <div class="positionFixed"> -->
<%-- 			<a><img src="${fileUrl}" style="width:60%;"/></a> --%>
<!-- 	    </div> -->
	    <!-- 底部 -->
<%-- 		<jsp:include page="footer.jsp"></jsp:include> --%>
<!-- 		<div class="position"></div> -->
		<script type="text/javascript">
			//整屏显示背景图片
// 			$(function(){
// 				var winH= $(window).height();
// 				$("#bg").css("height",winH+"px");
// 			});
		</script>
	</body>
</html>