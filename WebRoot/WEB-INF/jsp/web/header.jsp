<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="fixed" id="header">
    <div class="header">
        <div class="width60">会员${sessionScope.member.memberNo}</div>
        <div class="right"><a href="<%=basePath%>api/toPromote.do?id=${sessionScope.member.id}">我的推广二维码</a></div>
    </div>
</div>