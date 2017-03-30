<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>merchantSet/update.do" name="addForm" id="addForm" method="post">
			<input type="hidden" id="merchantId" name="id" value="${merchantSet.id}" />
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">商户名称:</td>
						<td><input type="text" name="merchantName" value="${merchantSet.merchantName}" /></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">商户号:</td>
						<td><input type="text" name="merchantNo" value="${merchantSet.merchantNo}" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">抽成比例:</td>
						<td><input type="text" name="rakeProportion" value="${merchantSet.rakeProportion}" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">商户余额(库存值):</td>
						<td><input type="text" name="merchantBalance" value="${merchantSet.merchantBalance}" /></td>
					</tr>
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">微信appId:</td>
						<td><input type="text" name="appId" value="${merchantSet.appId}" /></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">微信appSecret:</td>
						<td><input type="text" name="appSecret" value="${merchantSet.appSecret}" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">微信partner:</td>
						<td><input type="text" name="partner" value="${merchantSet.partner}" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">微信partnerKey:</td>
						<td><input type="text" name="partnerKey" value="${merchantSet.partnerKey}" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">平台总收入金额:</td>
						<td><input type="text" name="totalIncomeAmt" value="${merchantSet.totalIncomeAmt}" readonly /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">平台总红包金额:</td>
						<td><input type="text" name="totalRedPacketAmt" value="${merchantSet.totalRedPacketAmt}" readonly /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">库存标准值:</td>
						<td><input type="text" name="standardAmt" value="${merchantSet.standardAmt}" readonly /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">平台总支付笔数:</td>
						<td><input type="text" name="totalPayCount" value="${merchantSet.totalPayCount}" readonly /></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="10">
							<button type="submit" class="btn btn-mini btn-primary">保存</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>