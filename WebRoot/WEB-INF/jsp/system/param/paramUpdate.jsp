<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>param/update.do" name="updateForm" id="updateForm" method="post">
			<input type="hidden" name="id" value="${par.id}"/>
				<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">参数名称:</td>
						<td><input type="text" name="paramName" value="${par.paramName}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">参数类型:</td>
						<td><input type="text" name="paramType" value="${par.paramType}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">参数值:</td>
						<td><input type="text" name="sort" value="${par.paramValue}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">参数Key:</td>
						<td><input type="text" name="paramKey" value="${par.paramKey}"/></td>
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