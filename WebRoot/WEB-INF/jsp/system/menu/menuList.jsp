<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
		<script type="text/javascript">
			function menuDelete(menuId) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>menu/delete.do?id=" +menuId;
					}
				});
			}
			// 展开/折叠
			function openClose(id,curObj,trIndex){
				var txt = $(curObj).text();
				if(txt=="展开"){
					$(curObj).text("折叠");
					$("#tr"+id).after("<tr id='tempTr"+id+"'><td colspan='5' class='center'>数据载入中</td></tr>");
					if(trIndex%2==0){
						$("#tempTr"+id).addClass("main_table_even");
					}
					var url = "menu/querySubList.do?parentMenuId=" + id;
					$.get(url,function(data){
						if(data.length > 0 && data[0] != null && data[0] != '') {
							var html = "";
							$.each(data,function(i){
								html = "<tr style='height:24px;line-height:24px;' align='center' name='subTr" + id + "'>";
								html += "<td></td>";
								html += "<td class='center'><span style='width:80px;display:inline-block;'></span>";
								if(i==data.length-1)
									html += "<img src='static/images/joinbottom.gif' style='vertical-align: middle;'/>";
								else
									html += "<img src='static/images/join.gif' style='vertical-align: middle;'/>";
								html += "<span style='width:100px;text-align:left;display:inline-block;'>" + this.menuName + "</span>";
								html += "</td>";
								html += "<td>" + this.menuUrl + "</td>";
								html += "<td></td>";
								html += "<td class='center'>" + this.sort + "</td>";
								html += "<td class='center'><a class='btn btn-mini btn-danger btn-rbg-delete' onclick='menuDelete(\"" + this.id + "\")'>删除</a> "
										+ " <a class='btn btn-mini btn-info btn-rbg' href='<%=basePath%>menu/toUpdate.do?id=" + this.id + "'>修改</a></td>";
								html += "</tr>";
								$("#tempTr"+id).before(html);
							});
							$("#tempTr"+id).remove();
							if(trIndex%2==0){
								$("tr[name='subTr"+id+"']").addClass("main_table_even");
							}
						}else{
							$("#tempTr"+id+" > td").html("没有相关数据");
						}
					},"json");
				}else{
					$("#tempTr"+id).remove();
					$("tr[name='subTr"+id+"']").remove();
					$(curObj).text("展开");
				}
			}
		</script>
	</head>
	<body id="wrapper">
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
			  <div class="row-fluid">
					<div class="row-fluid">
						<form id="menuCriteriaQuery" action="<%=basePath%>menu/queryList.do" method="post">
							<table>
	                        	<tr>
	                            	<td style="vertical-align: top;">
	                            	<input type="text" name="menuName" value="${menu.menuName}" placeholder="请输入菜单名称"/>
	                            	<button type="submit" class='btn btn-mini btn-info btn-rbg' style="margin-top:0" >查询</button>
	                            	<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0"  href="<%=basePath%>menu/toAdd.do">增加</a>
									</td>
	                            </tr>
	                        </table>
							<table id="table_report" class="table table-striped table-bordered table-hover">
		                    	<thead>
		                        	<tr>
		                            	<th class="center">序号</th>
										<th class="center">菜单名称</th>
										<th class="center">菜单URL</th>
										<th class="center">菜单图标</th>
										<th class="center">菜单排序</th>
										<th class="center">操作</th>
		                            </tr>
		                   		</thead>
		                        <c:choose>
									<c:when test="${!empty page.records}">
					                   	<tbody>
					                       	<c:forEach items="${page.records}" var="menu" varStatus="vs">
					                           	<tr class="odd gradeX" id="tr${menu.id}">
					                               	<td class="center">${vs.count}</td>
													<td class="center">${menu.menuName}</td>
													<td class="left">${menu.menuUrl}</td>
													<td class="center">${menu.menuIcon}</td>
													<td class="center">${menu.sort}</td>
							                 		<td class='center'>
							                 			<a class='btn btn-mini btn-info btn-rbg' onclick="openClose('${menu.id}',this,${vs.index})" >展开</a>
														<a class="btn btn-mini btn-danger btn-rbg-delete" onclick="menuDelete('${menu.id}');">删除</a>
														<a class='btn btn-mini btn-info btn-rbg' href="<%=basePath%>menu/toUpdate.do?id=${menu.id}">修改</a>
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