<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>menu/add.do" name="menuForm" id="defaultForm" method="post" style="margin-top: 40px;">
			<div id="dance">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr class="form-group">
						<td style="width:70px;text-align: right;padding-top: 13px;">菜单名称:</td>
						<td><input type="text" name="menuName"  required data-bv-notempty-message="菜单名称必须填" required/></td>
					</tr>
					<tr class="form-group">
						<td style="width:120px;text-align: right;padding-top: 13px;">菜单URL:</td>
						<td><input type="text" name="menuUrl" data-bv-stringlength="true" data-bv-stringlength-min="6" data-bv-stringlength-max="30" data-bv-stringlength-message="用户名必须超过6,小于30个字符长" required/></td>
					</tr>
					<tr class="form-group">
						<td style="width:120px;text-align: right;padding-top: 13px;">菜单图标:</td>
						<td><input type="text" name="menuIcon" required /></td>
					</tr>
					<tr class="form-group">
						<td style="width:120px;text-align: right;padding-top: 13px;">菜单排序:</td>
						<td><input type="text" name="sort"   required   /></td>
					</tr>
					<tr class="form-group">
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