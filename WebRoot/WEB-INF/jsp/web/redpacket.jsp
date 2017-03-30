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
            margin-top:10px;
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
/*             margin-top: 41px; */
            text-align: center;
            padding:0px 10px;
        }
        .width100{
            border:1px solid #000000;
            width:100%;
            height:94px;
            color:#000000;
        }
        .width34{
            padding: 5px 0px;
            width:34%;
            border-right:1px solid #000000;
            color:#000000;float: left;
            overflow: hidden;
            height:93px;

        }
        .width22{
            width:22%;
            border-right:1px solid #000000;
            float: left;
            overflow: hidden;
            height:94px;
            color:#000000;
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
                color:#000000;float: left;
                overflow: hidden;
                height:100px;
            }
            .width22{
                width:22%;
                border-right:1px solid #000000;
                float: left;
                overflow: hidden;
                height:100px;
                color:#000000;
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
         @-webkit-keyframes flipInY {
            0% {
                -webkit-transform:  rotate3d(0,1,0,90deg);
                transform:  rotate3d(0,1,0,90deg);
                -webkit-transition-timing-function: ease-in;
                transition-timing-function: ease-in;
                opacity: 0
            }

            40% {
                -webkit-transform: rotate3d(0,1,0,-30deg);
                transform:  rotate3d(0,1,0,-30deg);
                -webkit-transition-timing-function: ease-in;
                transition-timing-function: ease-in
            }

            60% {
                -webkit-transform:  rotate3d(0,1,0,10deg);
                transform: rotate3d(0,1,0,10deg);
                opacity: 1
            }

            80% {
                -webkit-transform: rotate3d(0,1,0,-5deg);
                transform:  rotate3d(0,1,0,-5deg)
            }

            100% {
                -webkit-transform: perspective(400px);
                transform: perspective(400px)
            }
        }

        @keyframes flipInY {
            0% {
                -webkit-transform:  rotate3d(0,1,0,90deg);
                transform:  rotate3d(0,1,0,90deg);
                -webkit-transition-timing-function: ease-in;
                transition-timing-function: ease-in;
                opacity: 0
            }

            40% {
                -webkit-transform: rotate3d(0,1,0,-30deg);
                transform:  rotate3d(0,1,0,-30deg);
                -webkit-transition-timing-function: ease-in;
                transition-timing-function: ease-in
            }


            60% {
                -webkit-transform:  rotate3d(0,1,0,10deg);
                transform: rotate3d(0,1,0,10deg);
                opacity: 1
            }

            80% {
                -webkit-transform: rotate3d(0,1,0,-5deg);
                transform:  rotate3d(0,1,0,-5deg)
            }

            100% {
                -webkit-transform: perspective(400px);
                transform: perspective(400px)
            }
        }
		@-moz-keyframes flipInY {
            0% {
                -webkit-transform:  rotate3d(0,1,0,90deg);
                transform:  rotate3d(0,1,0,90deg);
                -webkit-transition-timing-function: ease-in;
                transition-timing-function: ease-in;
                opacity: 0
            }

            40% {
                -webkit-transform: rotate3d(0,1,0,-30deg);
                transform:  rotate3d(0,1,0,-30deg);
                -webkit-transition-timing-function: ease-in;
                transition-timing-function: ease-in
            }


            60% {
                -webkit-transform:  rotate3d(0,1,0,10deg);
                transform: rotate3d(0,1,0,10deg);
                opacity: 1
            }

            80% {
                -webkit-transform: rotate3d(0,1,0,-5deg);
                transform:  rotate3d(0,1,0,-5deg)
            }

            100% {
                -webkit-transform: perspective(400px);
                transform: perspective(400px)
            }
        }
        @-o-keyframes flipInY {
            0% {
                -webkit-transform:  rotate3d(0,1,0,90deg);
                transform:  rotate3d(0,1,0,90deg);
                -webkit-transition-timing-function: ease-in;
                transition-timing-function: ease-in;
                opacity: 0
            }

            40% {
                -webkit-transform: rotate3d(0,1,0,-30deg);
                transform:  rotate3d(0,1,0,-30deg);
                -webkit-transition-timing-function: ease-in;
                transition-timing-function: ease-in
            }


            60% {
                -webkit-transform:  rotate3d(0,1,0,10deg);
                transform: rotate3d(0,1,0,10deg);
                opacity: 1
            }

            80% {
                -webkit-transform: rotate3d(0,1,0,-5deg);
                transform:  rotate3d(0,1,0,-5deg)
            }

            100% {
                -webkit-transform: perspective(400px);
                transform: perspective(400px)
            }
        }
        .flipInY {
            -webkit-animation-name: flipInY;
            animation-name: flipInY;
            -webkit-animation-duration:4s;
            animation-duration:4s;
            transform:  rotate(360deg);
        }
    </style>
	</head>
		<body>
<%-- 	<body id="bg" style="background-image: url('<%=basePath%>static-web/img/bg.png');background-position: center center;background-repeat: no-repeat;background-size: cover;position: relative"> --%>
		<jsp:include page="header.jsp"></jsp:include>
		<div id="red-bg" style="background-image: url('<%=basePath%>static-web/img/red-bg_all.png');background-position: center center;background-repeat: no-repeat;background-size:100%;position: relative">
			
		<div class="height">
			<div class="border">
			    <div class="width100">
			        <div class="width34">
			            <p style="font-size:12px;overflow:hidden">猜拆红包</p>
			            <p style="font-size:12px;overflow:hidden">以下6个红包随机金额如右图所示</p>
			            <p style="font-size:12px;overflow:hidden">点开的红包金额即是你所获的红包金额</p>
			        </div>
			        <div class="width22">
			            <p class="text-color">${redPacketGroup[0]}元</p>
			            <p class="text-color_all">${redPacketGroup[1]}元</p>
			        </div>
			        <div class="width22">
			            <p class="text-color">${redPacketGroup[2]}元</p>
			            <p class="text-color_all">${redPacketGroup[3]}元</p>
			        </div>
			        <div class="width22" style="border-right:none;">
			            <p class="text-color">${redPacketGroup[4]}元</p>
			            <p class="text-color_all">${redPacketGroup[5]}元</p>
			        </div>
			    </div>
			</div>
			<div class="text">
				<c:if test="${redPacket.drowStatus == 0}">
					<input type="hidden" id="redPacketId" value="${redPacket.id}" />
					<div class="packet">
					    <a class="text-left" style="text-align:center;">
					    	<img id="0" class="animate" src="<%=basePath%>static-web/img/redpacket.png" style="width:75%;"/>
					    </a>
					    <a class="text-left" style="text-align:center;">
					    	<img id="1" class="animate" src="<%=basePath%>static-web/img/redpacket.png" style="width:75%;"/>
					    </a>
					    <a class="text-right" style="text-align:center">
					    	<img id="2" class="animate" src="<%=basePath%>static-web/img/redpacket.png" style="width:75%;"/></a>
					</div>
				    <div class="packet">
				        <a class="text-left" style="text-align:center">
				        	<img id="3" class="animate" src="<%=basePath%>static-web/img/redpacket.png" style="width:75%;"/>
				        </a>
					    <a class="text-left" style="text-align:center">
					    	<img id="4" class="animate" src="<%=basePath%>static-web/img/redpacket.png" style="width:75%;"/>
					    </a>
					    <a class="text-right" style="text-align:center">
					    	<img id="5" class="animate" src="<%=basePath%>static-web/img/redpacket.png" style="width:75%;"/>
					    </a>
				    </div>
			    </c:if>
			    <c:if test="${redPacket.drowStatus == 1}">
			    	<c:if test="${flag == '1'}">恭喜您，您获得一个奖励红包，请查收</c:if>
				    <div class="packet">
					    <a class="text-left" style="text-align:center;position:relative">
					    	<img src="<%=basePath%>static-web/img/newRedpacket.png" style="width:75%;"/>
					    	<span style="position: absolute; top: 48%;bottom:0; left: 0; right:0;"><c:if test="${sort == 0}"><span style="border:1px solid #ffffff;padding:0px 5px;"></c:if>${redPacketGroup[0]}<c:if test="${sort == 0}"></span></c:if></span> 
					    </a>
					    <a class="text-left" style="text-align:center;position:relative">
					    	<img src="<%=basePath%>static-web/img/newRedpacket.png" style="width:75%;"/>
					    	<span style="position: absolute; top: 48%;bottom:0; left: 0; right:0;"><c:if test="${sort == 1}"><span style="border:1px solid #ffffff;padding:0px 5px;"></c:if>${redPacketGroup[1]}<c:if test="${sort == 1}"></span></c:if></span>
					    </a>
					    <a class="text-right" style="text-align:center;position:relative">
					    	<img src="<%=basePath%>static-web/img/newRedpacket.png" style="width:75%;"/>
					    	<span style="position: absolute; top: 48%;bottom:0; left: 0; right:0;"><c:if test="${sort == 2}"><span style="border:1px solid #ffffff;padding:0px 5px;"></c:if>${redPacketGroup[2]}<c:if test="${sort == 2}"></span></c:if></span>
					    </a>
					</div>
				    <div class="packet">
				        <a class="text-left" style="text-align:center;position:relative">
				        	<img src="<%=basePath%>static-web/img/newRedpacket.png" style="width:75%;"/>
				        	<span style="position: absolute; top: 48%;bottom:0; left: 0; right:0;"><c:if test="${sort == 3}"><span style="border:1px solid #ffffff;padding:0px 5px;"></c:if>${redPacketGroup[3]}<c:if test="${sort == 3}"></span></c:if></span>
				        </a>
					    <a class="text-left" style="text-align:center;position:relative">
					    	<img src="<%=basePath%>static-web/img/newRedpacket.png" style="width:75%;"/>
					    	<span style="position: absolute; top: 48%;bottom:0; left: 0; right:0;"><c:if test="${sort == 4}"><span style="border:1px solid #ffffff;padding:0px 5px;"></c:if>${redPacketGroup[4]}<c:if test="${sort == 4}"></span></c:if></span>
					    </a>
					    <a class="text-right" style="text-align:center;position:relative">
					    	<img src="<%=basePath%>static-web/img/newRedpacket.png" style="width:75%;"/>
					    	<span style="position: absolute; top: 48%;bottom:0; left: 0; right:0;"><c:if test="${sort == 5}"><span style="border:1px solid #ffffff;padding:0px 5px;"></c:if>${redPacketGroup[5]}<c:if test="${sort == 5}"></span></c:if></span>
					    </a>
				    </div>
			    </c:if>
			</div>
		</div>	
		</div>
		<!-- 底部 -->
		<jsp:include page="footer.jsp"></jsp:include>
		
	<script>
	    //整屏显示背景图片
	    $(function(){
	        var winH= $(window).height();
	        $("#red-bg").css("height",winH+"px");
	    });
	    
	    //上下左右居中
	    window.onload = function() {
	        jQuery.fn.center = function() {
	            this.css("position", "absolute");
	            this.css("top", ($(window).height() - this.height()) / 2 + $(window).scrollTop() + "px");
	            this.css("left", ($(window).width() - this.width()) / 2 + $(window).scrollLeft() + "px");
	            return this;
	        }
	        $(".height").center();
	        window.onscroll = $('.height').center();
	        window.onresize = $('.height').center();
	        window.onload = $('.height').center();
	    }
	    
	    //点击图片旋转效果
	    $(".animate").click(function(){
	        $(this).addClass("flipInY");
	        var id = $("#redPacketId").val();
	        var sort = $(this).attr("id");
	        setTimeout(function(){
				window.location.href = "<%=basePath%>api/packing.do?id=" + id + "&sort=" + sort;
			}, 1000);
	    });
// 	    $(function(){
// 	        var winH= $("#red-bg").height()-140;
// 	        $(".height").css("height",winH+"px");
// 	    });
	</script>
	</body>
	
</html>