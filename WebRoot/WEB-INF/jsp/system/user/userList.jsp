<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
		<script type="text/javascript">
			function deleteUser(id) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>user/delete.do?id=" + id;
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
						<form id="menuCriteriaQuery" action="<%=basePath%>user/queryList.do" method="post">
							<table>
	                        	<tr>
	                            	<td style="vertical-align: top;">
		                            	<input type="text" name="userName" value="${user.userName}" placeholder="请输入用户名"/>
		                        		<input type="text" name="name" value="${user.name}" placeholder="请输入名称"/>
	                        			<button type="submit" class='btn btn-mini btn-info btn-rbg' style="margin-top:0" >查询</button>
	                            	<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0"  href="<%=basePath%>user/toAdd.do">增加</a>
									</td>
	                            </tr>
	                        </table>
							<table id="table_report" class="table table-striped table-bordered table-hover">
		                    	<thead>
		                        	<tr>
		                            	<th class="center">序号</th>
										<th class="center">用户名</th>
										<th class="center">密码</th>
										<th class="center">名称</th>
										<th class="center">最后登入时间</th>
										<th class="center">状态</th>
										<th class="center">手机号码</th>
										<th class="center">操作</th>
		                            </tr>
		                   		</thead>
		                        <c:choose>
									<c:when test="${!empty page.records}">
					                   	<tbody>
					                       	<c:forEach items="${page.records}" var="user" varStatus="vs">
					                           	<tr class="odd gradeX">
					                               	<td class="center">${vs.count}</td>
													<td class="center">${user.userName}</td>
													<td class="center">${user.password}</td>
													<td class="center">${user.name}</td>
													<td class="center">${user.lastLoginDate}</td>
													<td class='center'>
													<systab:codeDictionary codeType="userStatus" codeKey="${user.status}">${codeDictionary.codeValue}</systab:codeDictionary>
													</td>
													<td class="center">${user.phone}</td>
							                 		<td class='center'>
														<a class="btn btn-mini btn-danger btn-rbg-delete" onclick="deleteUser('${user.id}');" style="margin-top:0">删除</a>
														<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0" href="<%=basePath%>user/toUpdate.do?id=${user.id}">修改</a>
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