<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head lang="en">
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
	    <title>拆红包</title>
	    <link href="<%=basePath%>static-web/css/style.css" rel="stylesheet"/>
	    <script src="<%=basePath%>static-web/js/jquery-1.8.3.min.js"></script>
	    <style type="text/css">
        .margin45{
            /*margin-top: 45px;*/
            text-align: center;
            padding-top: 35px;
        }
        .packet{
            width:100%;
            padding:3px 10px 0px 10px;
            overflow: hidden;
        }
        .text-left{
            width:33.3%;
            float:left
        }
        .text-right{
            width:33.3%;
            float:right
        }
        .border{
            margin-top: 41px;
            text-align: center;
            padding:0px 10px;
        }
        .width100{
            border:1px solid #000000;
            width:100%;
            height:94px;
        }
        .width34{
            padding: 5px 0px;
            width:34%;
            border-right:1px solid #000000;
            color:#ffffff;float: left;
            overflow: hidden;
            height:93px;

        }
        .width22{
            width:22%;
            border-right:1px solid #000000;
            float: left;
            overflow: hidden;
            height:94px;
            color:#ffffff;
        }
        .text-color{
            height:48px;
            border-bottom:1px solid #000000;
            line-height: 48px;
        }
        .text-color_all{
            height:48px;
            /*border-bottom:1px solid #000000;*/
            line-height: 48px;
        }
        @media screen and (max-width:321px){
            .width100{
                border:1px solid #000000;
                width:100%;
                height:101px;
            }
            .width34{
                /*padding: 5px 5px;*/
                width:34%;
                border-right:1px solid #000000;
                color:#ffffff;float: left;
                overflow: hidden;
                height:100px;
            }
            .width22{
                width:22%;
                border-right:1px solid #000000;
                float: left;
                overflow: hidden;
                height:100px;
                color:#ffffff;
                font-size:12px;
            }
            .text-color{
                height:50px;
                border-bottom:1px solid #000000;
                line-height: 50px;
            }
            .text-color_all{
                height:50px;
                /*border-bottom:1px solid #000000;*/
                line-height:50px;
            }
        }
        @media screen and (min-width:321px) and (max-width:414px){
            .border{
                margin-top:60px;
                text-align: center;
                padding:0px 10px;
            }
            .packet{
                width:100%;
                padding:10px 10px 10px 10px;
                overflow: hidden;
            }
        }
    </style>
	</head>
	<body style="background:#FEA500">
<%-- 	<body id="bg" style="background-image: url('<%=basePath%>static-web/img/bg.png');background-position: center center;background-repeat: no-repeat;background-size: cover;position: relative"> --%>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="text-pay">
			<button class="immediately_all" onclick="javascript:window.location.href='<%=basePath%>api/auth.do'">继续去支付</button>
		    <p class="text-font">我收到的红包</p>
			<c:if test="${redPacketList != null && redPacketList.size() > 0}">
			<c:forEach items="${redPacketList}" var="redPacket">
			<div class="list">
				<div class="text-list">
					<p class="dete"><fmt:formatDate value="${redPacket.grantDate}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
					<c:if test="${redPacket.drowStatus == '1'}"><p class="width20">${redPacket.grantMoney}元</p></c:if>
					<c:if test="${redPacket.drowStatus == '0'}"><p class="width20">XXX元</p></c:if>
					<c:if test="${redPacket.drowStatus == '1'}"><p class="width20">已拆封</p></c:if>
					<c:if test="${redPacket.drowStatus == '0'}">
						<p class="width20"><a href="<%=basePath%>api/redPacket.do?id=${redPacket.id}" style="color: #F75314;">去拆封</a></p>
					</c:if>
				</div>
			</div>
			</c:forEach>
			</c:if>
		</div>
		<!-- 
		<div id="center" style="background-image: url('<%=basePath%>static-web/img/bg.png');background-position: center center;background-size: cover;">
			<c:if test="${unpackingList != null && unpackingList.size() > 0}">
			<c:forEach items="${unpackingList}" var="unpacking">
			    <div class="redpacket">
			        <p class="swap">精彩互换</p>
			        <p class="text-swap">给您发了一个红包</p>
			        <p class="swap">恭喜发财大吉大利</p>
			        <p class="btn"><a href="<%=basePath%>api/packing.do?id=${unpacking.id}&sort=0">拆红包</a></p>
			    </div>
		    </c:forEach>
		    </c:if>
		</div>
		 -->
		<jsp:include page="footer.jsp"></jsp:include>
		<div class="position" style="height:45px;"></div>
	<script>
	    //整屏显示背景图片
	    $(function(){
	        var winH= $(window).height();
	        $("#bg").css("height",winH+"px");
	    });
	    
	    $(function(){
	        var winH= $("#red-bg").height()-140;
	        $(".height").css("height",winH+"px");
	    });
	</script>
	</body>
	
</html>