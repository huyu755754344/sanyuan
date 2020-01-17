function submitImg(ev) {
	var file = $(ev).get(0).files;
	if(file.length<1)
		return false;
	var size = file[0].size/ 1024;
	if(size>5120){
		alert("图片不超过5M");
		$(ev).val("");
		return false;
	}
	$("#inputImg").submit();
}

function pictures(ev) {
	var file = $(ev).get(0).files;
	if(file.length<1)
		return false;
	if(file.length>8){
		alert("图片不超过8张");
		$(ev).val("");
		return false;
	}
	for(var i=0;i<file.length;i++){
		var size = file[i].size/ 1024;
		if(size>5120){
			alert("图片不超过5M");
			$(ev).val("");
			return false;
		}
	}
	$("#pictureForm").submit();
}
 /*$('#selectImg').click(function(){
	 window.location.href='xxx.html';
 })*/
 
