<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="/css/login.css"/>
		<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
	</head>
	<body>
		
		<div class="header-cont">
			<div class="header-box">
				<img src="img/logo.png" width="471">
			</div>
		</div>
		<div class="banner"></div>
		<div class="login-contain">
			<div class="login-cont">
				<div class="login-box">
					<div class="login-u-b">
						<form id="login-user" action="" method="post">
							<div class="">
								<input type="" autocomplete="off" name="phone" id="rgs-f" value="" placeholder="请输入手机号" />
							</div>
							<div class="">
								<input type="password" name="password" id="password" value="" placeholder="请输入密码" autocomplete="new-password" />
								<span id="vft-b"></span>
							</div>
							<a class="login-btn" href="javascript:;">登录</a>
							<a class="login-rgst" href="/toRegister">注册</a>
							<a class="login-forget" href="/toForget" target="_blank">忘记密码</a>
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
			if($('#rgs-f').val()==''||$('#rgs-f').val()==null||$('#password').val()==''||$('#password').val()==null){
				$('#vft-b').html('账号或密码不能为空')
				return false
			}else{
				$('#vft-b').html('');
				return true; 
			}
		}
		$(".login-btn").click(function(){
			
			if(fun()){
				
				$.ajax({
					type:'post',
					url:'192.168.1.188:84/login',
					data:$("#login-user").serialize(),
					crossDomain: true,                 //加这二行支持ajax跨域，允许跨域
	                xhrFields: {withCredentials: true},//加这二行支持ajax跨域，携带凭证   
					  success:function(result){
						   location.href="/";
					   } 
				})
				
				
				
				
				
			}
		});
	</script>
	
	
</html>
