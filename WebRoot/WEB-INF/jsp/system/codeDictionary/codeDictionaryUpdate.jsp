<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>codeDictionary/update.do" name="updateForm" id="updateForm" method="post">
			<input type="hidden" name="id" value="${codeDictionary.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">字典类型:</td>
						<td><input type="text" name="codeType" value="${codeDictionary.codeType}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">字典类型名称:</td>
						<td><input type="text" name="codeTypeName" value="${codeDictionary.codeTypeName}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">字典Key：</td>
						<td><input type="text" name="codeKey" value="${codeDictionary.codeKey}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">字典值:</td>
						<td><input type="text" name="codeValue" value="${codeDictionary.codeValue}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">顺序</td>
						<td><input type="text" name="sort" value="${codeDictionary.sort}"/></td>
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