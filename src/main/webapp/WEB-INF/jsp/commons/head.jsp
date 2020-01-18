<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			body{
				margin: 0;
				padding: 0;
			}
			.header-cont{
				/* width: 100%; */
		/* 		max-width: 1920px;
				min-width: 1200px; */
				height: 167px;
				overflow: hidden;
			}
			.header-cont .header-box{
				width: 1200px;
				margin: 10px auto;
				height: 101px;
				/* overflow: hidden; */
			}
			.header-cont .header-box img{
				float: left;
			}
			.header-cont .header-box #district{
				width: 680px;
				float: left;
				margin-left: 60px;
				line-height: 100px;
			}
			.header-cont .header-box a {
				text-decoration:underline;
				cursor: pointer;
				color: #222;
				float: right;
				margin-right: 10px;
				margin-top: 20px;
				font-size: 16px;
			}
			.header-cont .header-bar{
				width: 1200px;
				margin: 28px auto 0;
				overflow: hidden;
			}
			.header-cont .header-bar a{
				display: block;
				text-align: center;
				text-decoration: none;
				color: #333333;
				float: left;
				margin-right: 60px;
				width: 81px;
				font-size: 18px;
				font-weight: 500;
				/* border-bottom: 1px solid #FF435C; */
				padding-bottom: 6px;
			}
			.header-cont .header-bar > span{
				display: block;
				text-align: center;
				text-decoration: none;
				color: #333333;
				float: left;
				margin-right: 60px;
				width: 81px;
				font-size: 18px;
				font-weight: 500;
				/* border-bottom: 1px solid #FF435C; */
				padding-bottom: 6px;
				cursor: pointer;
			}
			#district select{
				width: 120px;
				height: 28px;
			}
			.active{
				background: red;
			}
			.kf-close {
				display: inline-block;
				width: 26px;
				height: 26px;
				background: #D8D8D8;
				border-radius: 50%;
				text-align: center;
				line-height: 26px;
				cursor: pointer;
			}
			.showBorder{
				display: none;
				width: 169px;
				height: 27px;
				border: 1px solid #222;
				position: absolute;
				top: 118px;
				left: 765px;
				padding: 5px 0 5px 20px;
			}
		</style>
	</head>
	<body>
		<div class="header-cont">
			<div class="header-box">
				<img src="/img/zu9.png" >
				<div class="inner-box">

				</div>
				<!-- <div id="district" data-toggle="distpicker">
					省：<select name="userProvince"></select>
					市：<select name="userCity"></select>
					区：<select name="userDistrict"></select>
				</div> -->
			</div>
			<div class="header-bar">
				<a href="/" <c:if test="${type==1 }">class="active"</c:if> >首页</a>
				<a href="/search" <c:if test="${type==2 }">class="active"</c:if> >买二手车</a>
				<a href="/sellCar" <c:if test="${type==3 }">class="active"</c:if> >卖二手车</a>
				<a href="/myCar" <c:if test="${type==4 }">class="active"</c:if> >我的发布</a>
				<!-- <a href="javascript:;" <c:if test="${type==5 }">class="active"</c:if> >客服中心</a> -->
				<span id="ckkfphone">客服中心</span>
				<div class="showBorder">023-6841-1167  	<span class="kf-close" id="kf-close">X</span></div>
			</div>
		</div>
	</body>
	<script src="/js/distpicker.data.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="/js/jquery-cookie.js" charset="utf-8"></script>
	<script src="/js/distpicker.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$("#district").distpicker({
			placeholder: false
		})

	$(document).ready(
		$.post("/sanyuanLogin",function(result){
			
			var name = $.cookie('userName');
			
			var str = '';
			if(result.status=="200"){
				str += '<a class="rgst rl" href="/logout">退出</a>';
				str += '<a href="/manage" class="login myName">'+name+'</a>';
			}else{
				str += '<a target="_blank" class="rgst rl" href="/toRegister" target="_blank">注册</a>';
				str += '<a class="login rl" href="/toLogin" target="_blank">登录</a>';
			}
			$(".inner-box").html(str);
		},"json")
			
	)
	$('#ckkfphone').click(function(){
		$('.showBorder').show();
	})
	$('#kf-close').click(function(){
		$('.showBorder').hide();
	})

	</script>
</html>
