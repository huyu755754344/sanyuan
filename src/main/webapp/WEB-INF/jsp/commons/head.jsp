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
			#district select{
				width: 120px;
				height: 28px;
			}
			.active{
				background: red;
			}
			
		</style>
	</head>
	<body>
		<div class="header-cont">
			<div class="header-box">
				<img src="/img/zu9.png" >
				<a href="javascript:;">登录</a>
				<a href="javascript:;">注册</a>
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
				<a href="javascript:;" <c:if test="${type==5 }">class="active"</c:if> >客服中心</a>
			</div>
		</div>
	</body>
	<script src="/js/distpicker.data.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/distpicker.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	$("#district").distpicker({
		placeholder: false
	})
	</script>
</html>
