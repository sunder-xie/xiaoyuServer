<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>role/update.do" name="updateForm" id="updateForm" method="post">
			<input type="hidden" name="id" value="${role.id}"/>
			<div>
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">角色编号:</td>
						<td><input type="text" name="roleCode" value="${role.roleCode}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">角色名称:</td>
						<td><input type="text" name="roleName" value="${role.roleName}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">顺序:</td>
						<td><input type="text" name="sort" value="${role.sort}"/></td>
						<td></td>
						<td></td>
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