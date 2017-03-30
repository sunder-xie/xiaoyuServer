	<%@ taglib prefix="systab" uri="http://www.systab.com/jsp/tld/examples" %>
	<%@ taglib prefix="biztab" uri="http://www.biztab.com/jsp/tld/examples" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	%>
	<meta charset="utf-8" />
	<title>小鱼代收后台管理平台</title>
	<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<base href="<%=basePath%>">

	<link type="text/css" rel="stylesheet" prePath="plugins/tab/" id="skin" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/login/css/camera.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/login/css/camera.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>plugins/tab/css/import_basic.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/login/matrix-login.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/bootstrap-responsive.min.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/font-awesome.min.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/chosen.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/ace.min.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/ace-responsive.min.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/ace-skins.min.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>plugins/zTree/3.5/zTreeStyle.css"/>
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/datepicker.css" />
	
	<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
	<script type="text/javascript" src="<%=basePath%>plugins/attention/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="<%=basePath%>plugins/attention/zDialog/zDialog.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.tips.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=basePath%>plugins/tab/js/tab.js" charset="utf-8" ></script>
	<script type="text/javascript" src="<%=basePath%>plugins/tab/js/framework.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/ace.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/ace-elements.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/chosen.jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/bootbox.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/myjs/menusf.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/myjs/index.js"></script>
	<script type="text/javascript" src="<%=basePath%>plugins/zTree/3.5/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/login/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/login/js/jquery.mobile.customized.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/login/js/camera.min.js"></script>
	
	<script>
		$(function() {
			top.hangge();// 加载条
			var locat = (window.location + '').split('/');
			if('main'== locat[3]) {
				locat = locat[0] + '//' + locat[2];
			}else{
				locat = locat[0] + '//'+locat[2] + '/' + locat[3];
			};
		});
		//清除加载进度
		function hangge(){
			$("#jzts").hide();
		}
		//显示加载进度
		function jzts(){
			$("#jzts").show();
		}
		//菜单状态切换
		var fmid = "fhindex";
		var mid = "fhindex";
		function siMenu(id,fid,MENU_NAME,MENU_URL){
			if(id != mid){
				$("#" + mid).removeClass();
				mid = id;
			}
			if(fid != fmid){
				$("#" + fmid).removeClass();
				fmid = fid;
			}
			$("#" + fid).attr("class","active open");
			$("#" + id).attr("class","active");
			top.mainFrame.tabAddHandler(id,MENU_NAME,MENU_URL);
			if(MENU_URL != "druid/index.html"){
				jzts();
			}
		}
		
		$(function() {
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			//日期框
			$('.date-picker').datepicker();
			//复选框
			$('table th input:checkbox').on('click' , function(){
				var that = this;
				$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
			});
		});
		
		//分页查询(首页、上一页、下一页、尾页)
		function firstPage(pageNum) {
			$("#pageNum").val(pageNum);
			var formId = $("form").attr("id");
			$("#" + formId).submit();
		}
		
		function prevPage(pageNum) {
			$("#pageNum").val(pageNum);
			var formId = $("form").attr("id");
			$("#" + formId).submit();
		}
		
		function nextPage(pageNum) {
			$("#pageNum").val(pageNum);
			var formId = $("form").attr("id");
			$("#" + formId).submit();
		}
		
		function endPage(pageNum) {
			$("#pageNum").val(pageNum);
			var formId = $("form").attr("id");
			$("#" + formId).submit();
		}
	</script>
