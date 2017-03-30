<div class="navbar navbar-inverse">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="brand"><small><i class="icon-leaf"></i>小鱼代收后台管理平台</small> </a>
			<ul class="nav ace-nav  pull-right">
				<li class="light-blue user-profile">
					<a class="user-menu dropdown-toggle" href="javascript:;" data-toggle="dropdown">
						<img alt="FH" src="static/avatars/user.jpg" class="nav-user-photo" />
						<span id="user_info">${sessionUser.name}</span>
						<i class="icon-caret-down"></i>
					</a>
					<ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
						<li><a target="mainFrame" href="<%=basePath%>user/toUpdatePwd.do;" style="cursor:pointer;"><i class="icon-user"></i> 修改登录密码</a></li>
						<li class="divider"></li>
						<li><a href="logout_logout.do"><i class="icon-off"></i> 退出</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>

