<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<a class="btn btn-mini btn-info">共${page.totalRecordsNum}条记录</a>
<a class="btn btn-mini btn-info">第${page.pageNum}页 / 共${page.totalPage}页</a>
<a class="btn btn-mini btn-info" onclick="firstPage('1');" >首页</a>
<a class="btn btn-mini btn-info" onclick="prevPage('${page.prevPageNum}');">上一页</a>
<a class="btn btn-mini btn-info" onclick="nextPage('${page.nextPageNum}');">下一页</a>
<a class="btn btn-mini btn-info" onclick="endPage('${page.totalPage}');">尾页</a>
<input type="hidden" id="pageNum" name="pageNum" value="${page.pageNum}" /> 
<input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}" /> 
