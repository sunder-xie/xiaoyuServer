<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body id="wrapper">
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
			  <div class="row-fluid">
					<div class="row-fluid">
						<form id="menuCriteriaQuery" action="<%=basePath%>dept/queryList.do" method="post">
							<table>
	                        	<tr>
	                            	<td style="vertical-align: top;">
	                            	<input type="text" name="deptName" value="${dept.deptName}" placeholder="请输入部门名称"/>
	                        			<button type="submit" class='btn btn-mini btn-info btn-rbg' style="margin-top:0" >查询</button>
									</td>
	                            </tr>
	                        </table>
							<table id="table_report" class="table table-striped table-bordered table-hover">
		                    	<thead>
		                        	<tr>
		                            	<th class="center">序号</th>
										<th class="center">部门名称</th>
										<th class="center">部门级别</th>
										<th class="center">部门类型</th>
										<th class="center">状态</th>
		                            </tr>
		                   		</thead>
		                        <c:choose>
									<c:when test="${!empty page.records}">
					                   	<tbody>
					                       	<c:forEach items="${page.records}" var="dept" varStatus="vs">
					                           	<tr class="odd gradeX">
					                               	<td class="center">${vs.count}</td>
													<td class="center">${dept.deptName}</td>
													<td class="center">${dept.deptLevel}</td>
													<td class="center">${dept.deptType}</td>
													<td class='center'>
														<systab:codeDictionary codeType="deptStatus" codeKey="${dept.status}">${codeDictionary.codeValue}</systab:codeDictionary>
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