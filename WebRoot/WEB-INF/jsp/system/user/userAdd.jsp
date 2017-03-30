<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>role/add.dRo" name="roleForm" id="roleForm" method="post" style="margin-top: 40px;">
			<div id="dance">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">用户名:</td>
						<td><input type="text" name="userName" required/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">密码:</td>
						<td><input type="text" name="password" required /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">名称:</td>
						<td><input type="text" name="name" required /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">最后登入时间:</td>
						<td><input type="text" name="lastLoginDate" required /></td>
					</tr>
						<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;" >用户状态</td>	
					   <td> 
					    	<select name="userStatus" id="userStatus" class="chzn-select" required data-placeholder="请选择用户状态"
								 style="vertical-align:top;width: 220px;" title="用户状态">
								<option value=""></option>
								<systab:codeDictionary codeType="userStatus" codeKey="all">
									<option value="${codeDictionary.codeKey}">${codeDictionary.codeValue}</option>
								</systab:codeDictionary>
							</select>
						</td>
						<td style="width:120px;text-align: right;padding-top: 13px;">手机号码:</td>
						<td><input type="text" name="phone" required /></td>
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