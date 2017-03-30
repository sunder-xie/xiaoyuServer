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
						<form action="member/querySubList.do" method="post" name="listForm" id="listForm">
							<input type="hidden" name="id" value="${member.id}" />
							<table>
								<tr>
									<td style="vertical-align:top;">
										<span class="input-icon">
<%-- 											<input autocomplete="off" id="nav-search-input" type="text" name="memberNo"  value="${member.memberNo}" placeholder="这里输入会员编号" /> --%>
<!-- 											<i id="nav-search-icon" class="icon-search"></i> -->
<!-- 											<button class="btn btn-mini btn-info" type="submit">查询</button> -->
											<button class="btn btn-mini btn-danger" type="button" onclick="javascript:history.go(-1);">返回</button>
										</span>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">会员编号</th>
										<th class="center">注册时间</th>
										<th class="center">级别</th>
										<th class="center">上级会员编号</th>
										<th class="center">支付次数</th>
										<th class="center">支付总金额</th>
										<th class="center">红包总金额</th>
										<th class="center">代理总分润</th>
										<th class="center">未发放分润</th>
										<th class="center">状态</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="member" varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<td class='center'>${member.memberNo}</td>
												<td class='center'><fmt:formatDate value="${member.registDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												<td class='center'>${member.rank}级会员</td>
												<td class='center'>${member.superiorMemberNo}</td>
												<td class='center'>${member.payCount}</td>
												<td class='center'>${member.payAmount}</td>
												<td class='center'>${member.redPacketMoney}</td>
												<td class='center'>${member.agentTotalMoney}</td>
												<td class='center'>${member.unsendAgencyFee}</td>
												<td class='center'>
													<c:if test="${member.status == 0}">停用</c:if>
													<c:if test="${member.status == 1}">正常</c:if>
												</td>
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

