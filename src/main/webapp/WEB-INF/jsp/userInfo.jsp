<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/detail.css"/>
		<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
		<script type="text/javascript" src="/js/jquery-cookie.js"></script>
</head>
<body>
<form id="form-reg" action="/register" method="post">
								<div class="">
									
									<span>实名认证</span>
								</div>
								<div class="">
									<input type="text" name="userName" id="userName" value="" placeholder="姓名" />
								</div>
								<div class="">
									<input type="text" name="userIdCard" id="userIdCard" value="" placeholder="身份证" />
								</div>
								<div class="">
									身份
									<input type="radio" name="identity" id="" checked="checked" value="0" />个人
									<input type="radio" name="identity" id="" value="1" />商家
								</div>
								<div class="">
									<input type="text" name="phone" id="phone" value="" placeholder="手机号" />
								</div>
								<div class="">
									<input type="text" name="code" id="code" value="" />
									<a href="javascript:;" id="getcode">获取验证码</a>
								</div>
								<a class="reg-btn regSub" href="javascript:;">确定</a>
							</form>
</body>
<script type="text/javascript">
var s=60;
function timer (cl){
	s--;
	$(cl).html('重新发送('+s+')');
	$(cl).css({'pointer-events':'none'})
	if(s==0){
		s=60;
		$(cl).html('获取验证码');
		$(cl).css('pointer-events','')
		return;
	}else
	setTimeout(function(){
		timer (cl);
	},1000);
}
$('#getcode').click(function(){
	if(verfiyPhone($('#phone'))){
		timer($('#getcode'));
		var phone = $('#phone').val();
		$.post("/sendCode",{"phone":phone},function(){});
	}
})

$('.getCode').click(function(){
	if(verfiyPhone($('#log_phone'))){
		timer($('.getCode'));
		var phone = $('#log_phone').val();
		$.post("/sendLCode",{"phone":phone},function(){});
	}
})
function verfiyPhone(p){
	var phone = $(p).val().trim();
	if(phone==null||phone==""){
		alert('请输入手机号');
		return false;
	}else if(!/^1[3456789]\d{9}$/.test(phone)){ 
		alert('格式不正确')
	  	return false;
    }
	return true;
}
	function verfiyCode(){
		var flag = false;
		var code =$("#code").val().trim();
		if(code==""||code==null){
			alert("请填写验证码");
			flag = false;
		}else{
			var phone = $('#phone').val().trim();
			$.ajax({
	    		type:"post",
				url:"/verfiyCode",
				data:{"code":code,"phone":phone},
				dataType:"json",
				async:false,
				success:function(result){
		    		if(result.status=="200"){
		    			flag = true;
		    		}else{
		    			alert('验证码有误');
		    		  	flag = false;
		    		}
				}
	    	})
		}
		return flag;
	}
	function verfiyName(){
		if($('#userName').val().length>=2 && /[\u4E00-\u9FA5\uF900-\uFA2D]/.test($('#userName').val())){
			return true
		}else{
			alert('姓名格式不正确')
			return false
		}
	}

	function verfiyIdCard(){
		if(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test($('#userIdCard').val())){
			return true
		}else{
			alert('身份证格式不正确');
			return false
		}
	}
	function approveIdCard(){
		var flag=false;
		if(verfiyName()&&verfiyIdCard()){
			$.ajax({
				type:"get",
				url:"/verfiyIdCard?name="+$('#userName').val()+'&idCard='+$('#userIdCard').val(),
				dataType:"json",
				async:false,
				success:function(ev){
					if(ev.status=="01"){
						flag=true
					}else{
						flag=false
						alert(ev.msg);
					}
				}
			})
		}
		return flag;
	}
	
	$(".regSub").click(function(){
		if(approveIdCard()&&verfiyCode()){
			$("#form-reg").submit();
		}
	});

</script>
</html>