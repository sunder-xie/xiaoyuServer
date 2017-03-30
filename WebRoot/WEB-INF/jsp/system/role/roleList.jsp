<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
		<script type="text/javascript">
			function roleDelete(roleId) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>role/delete.do?id=" +roleId;
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
						<form id="menuCriteriaQuery"  method="post">
							<table>
	                        	<tr>
	                            	<td style="vertical-align: top;">
	                            	<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0"  href="<%=basePath%>role/toAdd.do">增加</a>
									</td>
	                            </tr>
	                        </table>
							<table id="table_report" class="table table-striped table-bordered table-hover">
		                    	<thead>
		                        	<tr>
		                            	<th class="center">序号</th>
										<th class="center">角色编号</th>
										<th class="center">角色名称</th>
										<th class="center">顺序</th>
										<th class="center">操作</th>
		                            </tr>
		                   		</thead>
		                        <c:choose>
									<c:when test="${!empty page.records}">
					                   	<tbody>
					                       	<c:forEach items="${page.records}" var="role" varStatus="vs">
					                           	<tr class="odd gradeX">
					                               	<td class="center">${vs.count}</td>
													<td class="center">${role.roleCode}</td>
													<td class="center">${role.roleName}</td>
													<td class="center">${role.sort}</td>
							                 		<td class='center'>
							                 		<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0" href="<%=basePath%>role/toUpdate.do?id=${role.id}">权限分配</a>
														<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0" href="<%=basePath%>role/toUpdate.do?id=${role.id}">修改</a>
														<a class="btn btn-mini btn-danger btn-rbg-delete" onclick="roleDelete('${role.id}');" style="margin-top:0">删除</a>
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