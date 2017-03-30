<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="top.jsp"%>
		<style type="text/css">
			.commitopacity{position:absolute; width:100%; height:100px; background:#7f7f7f; filter:alpha(opacity=50); -moz-opacity:0.8; -khtml-opacity: 0.5; opacity: 0.5; top:0px; z-index:99999;}
		</style>
	</head>
	<body>
		<%@ include file="head.jsp"%>
		<div class="container-fluid" id="main-container">
			<a href="#" id="menu-toggler"><span></span></a>
			<%@ include file="left.jsp"%>
			<div id="main-content" class="clearfix">
				<div id="jzts" style=" width:100%; position:fixed; z-index:99999999;">
					<div class="commitopacity" id="bkbgjz"></div>
					<div style="padding-left: 70%;padding-top: 1px;">
						<div style="float: left;margin-top: 3px;"><img src="static/images/loadingi.gif" /> </div>
						<div style="margin-top: 5px;"><h4 class="lighter block red">&nbsp;加载中 ...</h4></div>
					</div>
				</div>
				<div>
					<iframe name="mainFrame" id="mainFrame" frameborder="0" src="tab.do" 
							style="margin:0 auto;width:100%;height:100%;"></iframe>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="static/js/myjs/index.js"></script>
</html>
