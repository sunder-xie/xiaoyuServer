var locat = (window.location+'').split('/'); 
$(function(){if('tool'== locat[3]){locat =  locat[0]+'//'+locat[2];}else{locat =  locat[0]+'//'+locat[2]+'/'+locat[3];};});

$(top.hangge());

//清除空格
String.prototype.trim=function(){
     return this.replace(/(^\s*)|(\s*$)/g,'');
};


function uploadTwo(){
	if($("#hasTp1").val()=="no"){
		$("#tipsTwo").tips({
			side:3,
	        msg:'请选择',
	        bg:'#AE81FF',
	        time:2
	    });
	return false;
	}
	$('#uploadify1').uploadifyUpload();
}	