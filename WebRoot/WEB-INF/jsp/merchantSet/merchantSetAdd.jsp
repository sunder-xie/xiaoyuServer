<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>merchantSet/add.do" name="addForm" id="addForm" method="post">
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">商户名称:</td>
						<td><input type="text" name="merchantName" /></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">商户号:</td>
						<td><input type="text" name="merchantNo" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">抽成比例:</td>
						<td><input type="text" name="rakeProportion" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">商户余额:</td>
						<td><input type="text" name="merchantBalance" /></td>
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