<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>codeDictionary/add.do" name="addForm" id="addForm" method="post" style="margin-top: 40px;">
			<div id="dance">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">字典类型:</td>
						<td><input type="text" name="codeType" required/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">字典类型名称:</td>
						<td><input type="text" name="codeTypeName" required /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">字典Key:</td>
						<td><input type="text" name="codeKey" required /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">字典值:</td>
						<td><input type="text" name="codeValue" required /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">顺序:</td>
						<td><input type="text" name="sort" required /></td>
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