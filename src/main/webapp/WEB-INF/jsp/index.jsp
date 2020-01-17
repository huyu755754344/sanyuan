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
	</head>
	<body>
		<jsp:include page="commons/head.jsp"></jsp:include>
		<div class="banner"></div>
		<div class="home-contain">
			<div class="home-cont">
				<div class="home-box">
					<div class="home-tit"></div>
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
