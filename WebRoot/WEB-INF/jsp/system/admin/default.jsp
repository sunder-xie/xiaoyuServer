<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="top.jsp"%>
</head>
<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="widget-box">
				<div class="widget-header widget-header-flat">
					<h4><i class="icon-star orange"></i>平台基本信息</h4>
					<div class="widget-toolbar">
							<a href="#" data-action="collapse"><i class="icon-chevron-up"></i></a>
					</div>
				</div>
				<div class="widget-body">
					 <div class="widget-main">
						<div class="row-fluid">
							<div class="span12">
								<table class="table table-striped table-bordered">
									<tbody>
										<tr>
											<td>平台用户总数量：</td>
											<td>${reportVO.totalUserCount} 人</td>
											<td class="center">&nbsp;</td>
											<td>平台累计总利润：</td>
											<td>${reportVO.totalProfit} 元</td>
										</tr>
										<tr>
											<td>累计支付总金额：</td>
											<td>${reportVO.totalPayAmt} 元</td>
											<td class="center">&nbsp;</td>
											<td>累计支付总笔数：</td>
											<td>${reportVO.totalPayCount} 笔</td>
										</tr>
										<tr>
											<td>累计红包总金额：</td>
											<td>${reportVO.totalRedPacketAmt} 元</td>
											<td class="center">&nbsp;</td>
											<td>累计分润总金额：</td>
											<td>${reportVO.totalChargeAmt} 元</td>
										</tr>
										<tr>
											<td>今日新增用户数：</td>
											<td>${reportVO.todayUserCount} 人</td>
											<td class="center"> &nbsp;</td>
											<td>今日利润总金额：</td>
											<td>${reportVO.todayProfitAmt} 元</td>
										</tr>
										<tr>
											<td>今日充值总金额：</td>
											<td>${reportVO.todayPayAmt} 元</td>
											<td class="center"> &nbsp;</td>
											<td>今日充值总笔数：</td>
											<td>${reportVO.todayPayCount} 笔</td>
										</tr>
										<tr>
											<td>今日红包总金额：</td>
											<td>${reportVO.todayRedPacketAmt} 元</td>
											<td class="center"> &nbsp;</td>
											<td>今日分润总金额：</td>
											<td>${reportVO.todayChargeAmt} 元</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- basic scripts -->
	<script src="static/1.9.1/jquery.min.js"></script>
	<script type="text/javascript">
		window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");
	</script>
	<script src="static/js/bootstrap.min.js"></script>
	<!-- page specific plugin scripts -->

	<!--[if lt IE 9]>
		<script type="text/javascript" src="static/js/excanvas.min.js"></script>
		<![endif]-->
	<script type="text/javascript" src="static/js/jquery-ui-1.10.2.custom.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.easy-pie-chart.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.flot.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.flot.pie.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.flot.resize.min.js"></script>
	<!-- ace scripts -->
	<script src="static/js/ace-elements.min.js"></script>
	<script src="static/js/ace.min.js"></script>
	<!-- inline scripts related to this page -->


	<script type="text/javascript">

		$(top.hangge());
	
		$(function() {
			$('.dialogs,.comments').slimScroll({
				height : '300px'
			});

			$('#tasks').sortable();
			$('#tasks').disableSelection();
			$('#tasks input:checkbox').removeAttr('checked').on('click',
					function() {
						if (this.checked)
							$(this).closest('li').addClass('selected');
						else
							$(this).closest('li').removeClass('selected');
					});
			var oldie = $.browser.msie && $.browser.version < 9;
			$('.easy-pie-chart.percentage')
					.each(
							function() {
								var $box = $(this).closest('.infobox');
								var barColor = $(this).data('color')
										|| (!$box.hasClass('infobox-dark') ? $box
												.css('color')
												: 'rgba(255,255,255,0.95)');
								var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)'
										: '#E2E2E2';
								var size = parseInt($(this).data('size')) || 50;
								$(this).easyPieChart({
									barColor : barColor,
									trackColor : trackColor,
									scaleColor : false,
									lineCap : 'butt',
									lineWidth : parseInt(size / 10),
									animate : oldie ? false : 1000,
									size : size
								});
							})
			$('.sparkline').each(
					function() {
						var $box = $(this).closest('.infobox');
						var barColor = !$box.hasClass('infobox-dark') ? $box
								.css('color') : '#FFF';
						$(this).sparkline('html', {
							tagValuesAttribute : 'data-values',
							type : 'bar',
							barColor : barColor,
							chartRangeMin : $(this).data('min') || 0
						});
					});

			var data = [ {
				label : "social networks",
				data : 38.7,
				color : "#68BC31"
			}, {
				label : "search engines",
				data : 24.5,
				color : "#2091CF"
			}, {
				label : "ad campaings",
				data : 8.2,
				color : "#AF4E96"
			}, {
				label : "direct traffic",
				data : 18.6,
				color : "#DA5430"
			}, {
				label : "other",
				data : 10,
				color : "#FEE074"
			} ];
			var placeholder = $('#piechart-placeholder').css({
				'width' : '90%',
				'min-height' : '150px'
			});
			$.plot(placeholder, data, {

				series : {
					pie : {
						show : true,
						tilt : 0.8,
						highlight : {
							opacity : 0.25
						},
						stroke : {
							color : '#fff',
							width : 2
						},
						startAngle : 2

					}
				},
				legend : {
					show : true,
					position : "ne",
					labelBoxBorderColor : null,
					margin : [ -30, 15 ]
				},
				grid : {
					hoverable : true,
					clickable : true
				},
				tooltip : true, //activate tooltip
				tooltipOpts : {
					content : "%s : %y.1",
					shifts : {
						x : -30,
						y : -50
					}
				}

			});

			var $tooltip = $(
					"<div class='tooltip top in' style='display:none;'><div class='tooltip-inner'></div></div>")
					.appendTo('body');
			placeholder.data('tooltip', $tooltip);
			var previousPoint = null;
			placeholder.on('plothover', function(event, pos, item) {
				if (item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : "
								+ item.series['percent'] + '%';
						$(this).data('tooltip').show().children(0).text(tip);
					}
					$(this).data('tooltip').css({
						top : pos.pageY + 10,
						left : pos.pageX + 10
					});
				} else {
					$(this).data('tooltip').hide();
					previousPoint = null;
				}

			});
			var d1 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d1.push([ i, Math.sin(i) ]);
			}
			var d2 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d2.push([ i, Math.cos(i) ]);
			}
			var d3 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.2) {
				d3.push([ i, Math.tan(i) ]);
			}

			var sales_charts = $('#sales-charts').css({
				'width' : '100%',
				'height' : '220px'
			});
			$.plot("#sales-charts", [ {
				label : "Domains",
				data : d1
			}, {
				label : "Hosting",
				data : d2
			}, {
				label : "Services",
				data : d3
			} ], {
				hoverable : true,
				shadowSize : 0,
				series : {
					lines : {
						show : true
					},
					points : {
						show : true
					}
				},
				xaxis : {
					tickLength : 0
				},
				yaxis : {
					ticks : 10,
					min : -2,
					max : 2,
					tickDecimals : 3
				},
				grid : {
					backgroundColor : {
						colors : [ "#fff", "#fff" ]
					},
					borderWidth : 1,
					borderColor : '#555'
				}
			});
			$('[data-rel="tooltip"]').tooltip();
		})
	</script>
</body>
</html>
