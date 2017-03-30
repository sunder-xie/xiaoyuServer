<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="footer">
    <p class="button"><a href="<%=basePath%>api/auth.do">去支付</a></p>
    <p class="button"><a href="<%=basePath%>api/unpacking.do">拆红包</a></p>
<%--     <p class="button"><a href="<%=basePath%>api/redPacket.do">拆红包</a></p> --%>
    <p class="button"><a href="<%=basePath%>api/theAgent.do">代理业绩</a></p>
    <p class="button"><a href="<%=basePath%>api/customerService.do">联系客服</a></p>
</div>