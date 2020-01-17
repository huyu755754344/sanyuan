<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="/css/forget.css"/>
		<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
		<script type="text/javascript" src="/js/jquery-cookie.js"></script>
	</head>
	<body>

		<div class="header-cont">
			<div class="header-box">
				<img src="img/logo.png" width="471">
			</div>
		</div>
		<div class="banner"></div>
		<div class="forget-contain">
			<div class="forget-cont">
				<div class="forget-box">
					<div class="forget-u-b">
						<form id="forget-user" action="/forget" method="post">
							<div class="">
								<input type="text" name="phone" id="rgs-id" value="" placeholder="请输入手机号" />
								<span id="vft-a"></span>
							</div>
							<div class="">
								<input type="password" name="password" id="rgs-pwd" value="" placeholder="请输入新密码" />
							</div>
							<div class="">
								<input type="password" name="" id="rgs-pwds" value="" placeholder="请再次输入密码" />
								<span id="rgs-a"></span>
							</div>
							<div class="">
								<input type="text" name="" id="code" value="" placeholder="请输入验证码" />
								<a id="getcode" href="javascript:;">获取验证码</a>
								<span id="code-a"></span>
							</div>
							<a class="forget-btn" href="javascript:;">修改</a>
						</form>
					</div>
				</div>
				<jsp:include page="commons/mall.jsp"></jsp:include>
			</div>
		</div>
				<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="commons/bottom.jsp"></jsp:include>	
	</body>
	
	<script type="text/javascript">
		function fun(){
			var flag = false;
			if($('#rgs-id').val()==''||$('#rgs-id').val()==null){
				$('#vft-a').css('color','red')
				$('#vft-a').html('请输入手机号')
				return false
			}else if($('#rgs-pwd').val()==""||$('#rgs-pwd').val()==null|| $('#rgs-pwds').val()==null||$('#rgs-pwds').val()==""){
				$('#rgs-a').css('color','red')
				$('#rgs-a').html('请输入密码')
				return false
			}else if($('#rgs-pwd').val() != $('#rgs-pwds').val()){
				$('#rgs-a').css('color','red')
				$('#rgs-a').html('两次密码不一致')
				return false
			}else if($('#code').val()==''||$('#code').val()==null){
				$('#code-a').css('color','red')
				$('#code-a').html('验证码不能为空')
				return false
			}else{
				var code = $('#code').val();
				var phone = $('#rgs-id').val().trim();
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
			    			$('#code-a').css('color','red')
			    			$('#code-a').html('验证码有误');
			    		  	flag = false;
			    		}
					}
		    	})
			}
			return flag
		}
		
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
			if($('#rgs-id').val()==''||$('#rgs-id').val()==null){
				$('#vft-a').css('color','red')
				$('#vft-a').html('请输入手机号')
				return false
			}else{
				timer($('#getcode'));
				var phone = $('#rgs-id').val();
				$.post("https://xn--ehq91f.hunlian.art/sendLCode",{"phone":phone},function(){},"jsonp");
			}
		})
		
		$(".forget-btn").click(function(){
			if(fun()){
				$("#forget-user").submit();
			}
		});
		
		vft($('#rgs-id'),$('#vft-a'),'手机号')
		pwd($('#rgs-pwd'),$('#rgs-pwds'),$('#rgs-a'))
		
		$('#code').blur(function(){
			if($('#code').val()==''||$('#code').val()==null){
				$('#code-a').css('color','red')
				$('#code-a').html('验证码不能为空')
			}else{
				$('#code-a').html('')
			}
		})
		
		function vft(obj,objx,txt){
			obj.blur(function(){
				if(obj.val()==''||obj.val()==null){
					objx.css('color','red')
					objx.html('请输入'+txt)
				}
			})
			obj.focus(function(){
				objx.html('')
			})	
		}
		
		function pwd(obj,objx,txt){
			obj.blur(function(){
				repeat(obj,objx,txt)
			})
			objx.blur(function(){
				repeat(obj,objx,txt)
			})
		}
		
		function repeat(obj,objx,txt){
			if(obj.val() != objx.val()){
				txt.css('color','red')
				txt.html('两次密码不一致')
			}else{
				txt.html('')
			}	
		}
		$('#getcode').click(function(){
			if($('#rgs-id').val()==''||$('#rgs-id').val()==null){
				$('#vft-a').css('color','red')
				$('#vft-a').html('请输入手机号')
				return false
			}else{
				timer($('#getcode'));
				var phone = $('#rgs-id').val();
				$.post("/sendCode",{"phone":phone},function(){},"jsonp");
			}
		})
	</script>
</html>
