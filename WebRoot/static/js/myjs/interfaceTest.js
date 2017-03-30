var locat = (window.location+'').split('/'); 
$(function(){if('tool'== locat[3]){locat =  locat[0]+'//'+locat[2];}else{locat =  locat[0]+'//'+locat[2]+'/'+locat[3];};});


$(top.hangge());

//重置
function gReload(){
	top.jzts();
	$("#serverUrl").val('');
	$("#json-field").val('');
	$("#S_TYPE_S").val('');
	self.location.reload();
}

//请求类型
function setType(value){
	$("#S_TYPE").val(value);
}

function intfBox(){
	var intfB = document.getElementById("json-field");
	var intfBt = document.documentElement.clientHeight;
	intfB .style.height = (intfBt  - 320) + 'px';
}
intfBox();
window.onresize=function(){  
	intfBox();
};

//js  日期格式
function date2str(x,y) {
     var z ={y:x.getFullYear(),M:x.getMonth()+1,d:x.getDate(),h:x.getHours(),m:x.getMinutes(),s:x.getSeconds()};
     return y.replace(/(y+|M+|d+|h+|m+|s+)/g,function(v) {return ((v.length>1?"0":"")+eval('z.'+v.slice(-1))).slice(-(v.length>2?v.length:2))});
 	};