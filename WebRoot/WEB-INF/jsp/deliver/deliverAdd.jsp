<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>deliver/add.do" name="addForm" id="addForm" method="post">
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="text-align: right;padding-top: 13px;">快递公司编号:</td>
						<td><input type="text" name="deliverNo" required /></td>
						<td style="text-align: right;padding-top: 13px;">快递公司名称:</td>
						<td><input type="text" name="deliverName" required /></td>
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