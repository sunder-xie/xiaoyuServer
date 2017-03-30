<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
		<script type="text/javascript">
			function deleteDeliver(id) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>deliver/delete.do?id=" + id;
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
						<form action="deliver/queryList.do" method="post" name="listForm" id="listForm">
							<table style="width:100%">
								<tr>
									<td align="left" width="50%">
										<span class="input-icon">
											<input id="nav-search-input" type="text" name="deliverNo" 
													value="${deliver.deliverNo}" placeholder="输入快递公司编号" />
											<input id="nav-search-input" type="text" name="deliverName" 
													value="${deliver.deliverName}" placeholder="输入快递公司名称" />
											<button class="btn btn-mini btn-info" type="submit">查询</button>
											<a class="btn btn-mini btn-info" href="<%=basePath%>deliver/toAdd.do" >新增</a>
										</span>
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
										<th class="center">快递公司编号</th>
										<th class="center">快递公司名称</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="deliver" varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<td class='center'>${deliver.deliverNo}</td>
												<td class='center'>${deliver.deliverName}</td>
												<td class='center'>
													<a type="button" class="btn btn-mini btn-danger" onclick="deleteDeliver('${deliver.id}');">删除</a>
													<a type="button" class="btn btn-mini btn-info" href="<%=basePath%>deliver/toUpdate.do?id=${deliver.id}">修改</a>
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

