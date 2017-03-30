<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>user/updatePwd.do" name="updatePwdForm" id="updatePwdForm" method="post">
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:50%;text-align: right;padding-top: 13px;">原密码:</td>
						<td><input type="password" id="password" name="password" required /></td>
					</tr>
					<tr>
						<td style="width:50%;text-align: right;padding-top: 13px;">新密码:</td>
						<td><input type="password" id="newPassword" name="newPassword" required /></td>
					</tr>
					<tr>
						<td style="width:50%;text-align: right;padding-top: 13px;">确认新密码:</td>
						<td><input type="password" id="checkPassword" name="checkPassword" required /></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="10">
							<button type="submit" class="btn btn-mini btn-primary">保存</button>
							<button type="button" class="btn btn-mini btn-danger" onclick="javascript:history.go(-1);">取消</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>