<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
		<script type="text/javascript">
			function paramDelete(paramId) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>param/delete.do?id=" +paramId;
					}
				});
			}	
		</script>
	</head>
	<body id="wrapper">
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
			  <div class="row-fluid">
					<div class="row-fluid">
						<form id="menuCriteriaQuery" action="<%=basePath%>param/queryList.do" method="post">
							<table>
	                        	<tr>
	                            	<td style="vertical-align: top;">
	                        			<input type="text" name="paramName" value="${param.paramName}" placeholder="请输入参数名称"/>
	                        			<button type="submit" class='btn btn-mini btn-info btn-rbg' style="margin-top:0" >查询</button>
	                            	<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0"  href="<%=basePath%>param/toAdd.do">增加</a>
									</td>
	                            </tr>
	                        </table>
							<table id="table_report" class="table table-striped table-bordered table-hover">
		                    	<thead>
		                        	<tr>
		                            	<th class="center">序号</th>
										<th class="center">参数名称</th>
										<th class="center">参数类型</th>
										<th class="center">参数值</th>
										<th class="center">参数Key</th>
										<th class="center">操作</th>
		                            </tr>
		                   		</thead>
		                        <c:choose>
									<c:when test="${!empty page.records}">
					                   	<tbody>
					                       	<c:forEach items="${page.records}" var="par" varStatus="vs">
					                           	<tr class="odd gradeX">
					                               	<td class="center">${vs.count}</td>
													<td class="center">${par.paramName}</td>
													<td class="center">${par.paramType}</td>
													<td class="center">${par.paramValue}</td>
													<td class="center">${par.paramKey}</td>
							                 		<td class='center'>
														<a class="btn btn-mini btn-danger btn-rbg-delete" onclick="paramDelete('${par.id}');" style="margin-top:0">删除</a>
														<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0" href="<%=basePath%>param/toUpdate.do?id=${par.id}">修改</a>
													</td>
				                                </tr>
					                        </c:forEach>
					                    </tbody>
					                </c:when>
									<c:otherwise>
										<tbody>
											<tr>
												<td colspan="100" style="text-align: center;">
													<font color="red">此页没有相关数据！</font>
												</td>
											</tr>
										</tbody>
									</c:otherwise>
								</c:choose>
		                   	</table>
		                   	<div align="right">
								<%@include  file="../../page.jsp" %>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>