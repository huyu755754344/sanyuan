<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="/css/index.css"/>
		<style>
			.home-tit span {
				display: block;
				font-size: 14px;
				text-indent:28px;
				text-align: justify;
				line-height: 28px;
			}
		</style>
	</head>
	<body>
		<jsp:include page="commons/head.jsp"></jsp:include>
		<div class="banner"></div>
		<div class="home-contain">
			<div class="home-cont">
				<div class="home-box">
					<div class="home-tit">
						<span>各位先生，女士，朋友们，大家好！<span>
						<span>本网站是一家专业提供二手车信息服务的商务平台，我们只提供二手车买卖信息服务，不参与买卖双方的交易过程。买方和卖方直接联系，没有任何第三方吃一分钱的差价。我们本来想全免费提供信息服务的，但考虑到网站平台需要资金维护运作，所以本网站只收取3元钱的网络维护费用。对于几千几万的一部车辆来说，3元钱也不算什么吧？希望大家多多支持并理解，谢谢！</span>
						<span>如果客户另外需要我们的服务(比如代办车辆过户手续等)，可以直接联系我们的客服人员。</span>
						<span>本网站是真正意义上的，没有第三方吃差价。不像某些网商平台，说的没有第三方吃差价，实际上全是套路，各位可以对比一下。希望大家相互传播本网站，谢谢！</span>
					</div>
					<div class="home-topimg"></div>
					<div class="home-recommend">
						<div class="rec-tit">
							推荐车型
						</div>
						<div class="rec-allcar">
							<c:forEach items="${carList }" var="car" begin='0' end='14'>
								<div class="rec-cars" onclick="window.open('/detail?carId=${car.carId}')">
									<img class="rec-carimg" src="${car.imgPath }" >
									<div class="rec-imgintro">
										<div class="intro-left">
											${car.brand.brandPinpai }
										</div>
										<div class="intro-right">
											<div class="y-s">
												${carShangpai }&nbsp;&nbsp;  ${car.carKm }公里
											</div>
											<div class="prise">
												<del>原价:${car.protPrice }万</del>
												<span id="now-prise">${car.nowPrice }万</span>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="home-recommend">
						<div class="home-bottomimg2"></div>
						<div class="rec-allcar">
							<c:forEach items="${carList }" var="car" begin='15' end='29'>
								<div class="rec-cars" onclick="window.open('/detail?carId=${car.carId}')">
									<img class="rec-carimg" src="${car.imgPath }" >
									<div class="rec-imgintro">
										<div class="intro-left">
											${car.brand.brandPinpai }
										</div>
										<div class="intro-right">
											<div class="y-s">
												${carShangpai }&nbsp;&nbsp;  ${car.carKm }公里
											</div>
											<div class="prise">
												<del>原价:${car.protPrice }万</del>
												<span id="now-prise">${car.nowPrice }万</span>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="home-bottomimg"></div>
					<div class="home-music">
						<div class="music-tit">
							情感音乐
						</div>
						<div class="home-disc">
							<jsp:include page="commons/disc.jsp"></jsp:include>
						</div>
					</div>
				</div>
				<jsp:include page="commons/mall.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="commons/bottom.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
	$(".rec-allcar div").eq(2)
	$(".rec-allcar").children().eq(14).append("<div class='home-bottomimg'></div>")
	
	</script>
</html>
