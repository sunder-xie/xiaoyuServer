<div id="sidebar" >
	<ul class="nav nav-list">
		<li class="active" id="fhindex">
			<a href="main/index"><i class="icon-dashboard"></i><span>后台首页</span></a>
		</li>
		<c:forEach items="${menuList}" var="menu">
			<c:if test="${menu.hasMenu}">
				<li id="lm${menu.id }">
					<a style="cursor:pointer;" class="dropdown-toggle" >
						<i class="${menu.menuIcon == null ? 'icon-desktop' : menu.menuIcon}"></i>
						<span>${menu.menuName }</span>
						<b class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<c:forEach items="${menu.subMenuList}" var="sub">
							<li id="z${sub.id }">
								<a style="cursor:pointer;" target="mainFrame"  
										onclick="siMenu('z${sub.id }','lm${menu.id }','${sub.menuName }','${sub.menuUrl }')">
								<i class="icon-double-angle-right"></i>${sub.menuName }</a>
							</li>
						</c:forEach>
				  	</ul>
				</li>
			</c:if>
		</c:forEach>
	</ul>
	<div id="sidebar-collapse"><i class="icon-double-angle-left"></i></div>
</div>

