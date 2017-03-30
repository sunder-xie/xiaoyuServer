<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
		<script type="text/javascript">
			function upgrade(id) {
				bootbox.confirm("确定升级为一级代理吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>member/upgrade.do?id=" + id;
					}
				});
			}
			function deleteMember(id) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>member/delete.do?id=" + id;
					}
				});
			}
			function stopOrUsingMember(id, status) {
				var flag = "停用";
				if (status == '1') {
					flag="启用";
				}
				bootbox.confirm("确定" + flag + "吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>member/stopOrUsing.do?id=" + id + "&status=" + status;
					}
				});
			}
		</script>
	</head>
	<body>
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
			  <div class="row-fluid">
					<div class="row-fluid">
						<form action="member/queryList.do" method="post" name="listForm" id="listForm">
							<table style="width:100%">
								<tr>
									<td align="left" width="50%">
										<input autocomplete="off" id="nav-search-input" type="text" name="memberNo"  value="${member.memberNo}" placeholder="这里输入会员编号" />
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
										<th class="center">会员编号</th>
<!-- 										<th class="center">会员姓名</th> -->
										<th class="center">会员类型</th>
<!-- 										<th class="center">微信名称</th> -->
										<th class="center">微信openId</th>
										<th class="center">手机号码</th>
										<th class="center">注册时间</th>
										<th class="center">状态</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="member" varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<td class='center'>${member.memberNo}</td>
<%-- 												<td class='center'>${member.name}</td> --%>
												<td class='center'>${member.memberType}</td>
<%-- 												<td class='center'>${member.wechatName}</td> --%>
												<td class='center'>${member.wechatOpenid}</td>
												<td class='center'>${member.phone}</td>
												<td class='center'><fmt:formatDate value="${member.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												<td class='center'>
													<c:if test="${member.status == 0}">停用</c:if>
													<c:if test="${member.status == 1}">正常</c:if>
												</td>
												<td class='center'>
													<a type="button" class="btn btn-mini btn-danger" onclick="deleteMember('${member.id}');">删除</a>
													<c:if test="${member.status == 1}">
														<a type="button" class="btn btn-mini btn-danger" onclick="stopOrUsingMember('${member.id}', '0');">停用</a>
													</c:if>
													<c:if test="${member.status == 0}">
														<a type="button" class="btn btn-mini btn-danger" onclick="stopOrUsingMember('${member.id}', '1');">启用</a>
													</c:if>
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

