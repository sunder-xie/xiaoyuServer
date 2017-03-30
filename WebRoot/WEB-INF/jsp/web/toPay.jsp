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
	    <title>去支付</title>
	    <link href="<%=basePath%>static-web/css/style.css" rel="stylesheet"/>
	    <script src="<%=basePath%>static-web/js/jquery-1.8.3.min.js"></script>
	</head>
	<body style="background:#FEA500">
<%-- 	<body id="bg" style="background-image: url('<%=basePath%>static-web/img/bg.png');background-position: center center;background-repeat: no-repeat;background-size: cover;position: relative"> --%>

		<!-- 头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 内容 -->
		<div class="content">
		    <div class="pay">
		        <p class="font">￥${money}</p>
		        <div class="text-button">
		            <a onclick="callpay();"><p class="immediately">立即支付</p></a>
		        </div>
		        <div>
		            <p class="margin5">支付十元抢！1~200元红包</p>
		            <p class="margin5" style="color:#999999">支付即表示您同意<a style="font-size:15px;color:#999999" href="<%=basePath%>api/agreement.do">【精彩红动协议】</a></p>
		        </div>
		    </div>
		    <div class="Sweep ">
		        <p style="color:#FFA604;font-size:12px;">申请代理，请联系在线微信客服</p>
		        <p style="margin-top:5px;font-size:12px;color:#999999;padding-bottom: 10px;">如有疑问请扫描以下二维码关注公众号，联系在线客服！</p>
		        <div style="border:1px solid #333;border-radius:5px">
		            <img src="<%=basePath%>static-web/img/Sweep.gif" style="width:75%"/>
		        </div>
		    </div>
		</div>
		<!-- 底部 -->
		<jsp:include page="footer.jsp"></jsp:include>
		<div class="position"></div>
	</body>

    <script type="text/javascript">
    function callpay(){
		WeixinJSBridge.invoke(
			'getBrandWCPayRequest',{
				"appId" : "${appid}",
				"timeStamp" : "${timeStamp}",
				"nonceStr" : "${nonceStr}", 
				"package" : "${packageValue}",
				"signType" : "MD5", 
				"paySign" : "${sign}" 
			},function(res){
                WeixinJSBridge.log(res.err_msg);
                if(res.err_msg == "get_brand_wcpay_request:ok"){  
                    window.location.href="<%=basePath%>api/redPacket.do"
                }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
//                     alert("用户取消支付!");  
                }else{  
					alert("支付失败!");  
                }  
            })
        }
	</script>
</html>