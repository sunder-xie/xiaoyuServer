<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
			  	<div class="row-fluid">
					<div class="row-fluid">
						<form action="order/queryList.do" method="post" name="listForm" id="listForm">
							<table style="width:100%">
								<tr>
									<td align="left" width="50%">
										<input id="nav-search-input" type="text" name="memberNo" 
												value="${redPacket.memberNo}" placeholder="输入会员编号" />
										<button class="btn btn-mini btn-info" type="submit">查询</button>
									</td>
									<td align="right" width="50%">
										<%@include  file="../page.jsp" %>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">订单号</th>
										<th class="center">会员编号</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="order" varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<td class='center'>${order.orderNo}</td>
												<td class='center'>${order.memberId}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr class="main_info">
											<td colspan="100" class="center" >没有相关数据</td>
										</tr>
									</c:otherwise>
								</c:choose>
								</tbody>
							</table>
							<div align="right">
								<%@include  file="../page.jsp" %>
							</div>
						</form>
					</div>
	  			</div>
			</div>
		</div>
	</body>
</html>

