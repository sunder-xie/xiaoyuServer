<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>menu/update.do" name="updateForm" id="updateForm" method="post">
			<input type="hidden" name="id" value="${menu.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">菜单名称:</td>
						<td><input type="text" name="menuName" value="${menu.menuName}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">菜单URL:</td>
						<td><input type="text" name="menuUrl" value="${menu.menuUrl}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">菜单图标</td>
						<td><input type="text" name="menuIcon" value="${menu.menuIcon}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">菜单排序:</td>
						<td><input type="text" name="sort" value="${menu.sort}"/></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="10">
							<button type="submit" class="btn btn-mini btn-primary">保存</button>
							<button type="button" class="btn btn-mini btn-danger" onclick="javascript:history.go(-1);">返回</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>