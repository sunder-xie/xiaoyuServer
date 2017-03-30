<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
		<script type="text/javascript">
			function codeDictionaryDelete(codeDictionaryId) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>codeDictionary/delete.do?id=" +codeDictionaryId;
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
						<form id="menuCriteriaQuery" action="<%=basePath%>codeDictionary/queryList.do" method="post">
							<table>
	                        	<tr>
	                        		<td style="vertical-align:top;">
	                        			<input type="text" name="codeType" value="${codeDictionary.codeType}" placeholder="请输入字典类型"/>
	                        			<input type="text" name="codeTypeName" value="${codeDictionary.codeTypeName}" placeholder="请输入字典名称"/>
	                        			<button type="submit" class='btn btn-mini btn-info btn-rbg' style="margin-top:0" >查询</button>
	                            		<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0"  href="<%=basePath%>codeDictionary/toAdd.do">增加</a>
									</td>
	                            </tr>
	                        </table>
							<table id="table_report" class="table table-striped table-bordered table-hover">
		                    	<thead>
		                        	<tr>
		                            	<th class="center">序号</th>
										<th class="center">字典类型</th>
										<th class="center">字典类型名称</th>
										<th class="center">字典Key</th>
										<th class="center">字典值</th>
										<th class="center">顺序</th>
										<th class="center">操作</th>
		                            </tr>
		                   		</thead>
		                        <c:choose>
									<c:when test="${!empty page.records}">
					                   	<tbody>
					                       	<c:forEach items="${page.records}" var="codeDictionary" varStatus="vs">
					                           	<tr class="odd gradeX">
					                               	<td class="center">${vs.count}</td>
													<td class="center">${codeDictionary.codeType}</td>
													<td class="center">${codeDictionary.codeTypeName}</td>
													<td class="center">${codeDictionary.codeKey}</td>
													<td class="center">${codeDictionary.codeValue}</td>
													<td class="center">${codeDictionary.sort}</td>
							                 		<td class='center'>
														<a class="btn btn-mini btn-danger btn-rbg-delete" onclick="codeDictionaryDelete('${codeDictionary.id}');" style="margin-top:0">删除</a>
														<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0" href="<%=basePath%>codeDictionary/toUpdate.do?id=${codeDictionary.id}">修改</a>
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