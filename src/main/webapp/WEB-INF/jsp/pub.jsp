<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>我的发布</title>
		<link rel="stylesheet" type="text/css" href="css/pub.css"/>
		<style>
			.pub-tit span {
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
		<div class="pub-contain">
			<div class="pub-cont">
				<div class="pub-box">
					<div class="pub-tit">
						<span>各位先生，女士，朋友们，大家好！<span>
						<span>本网站是一家专业提供二手车信息服务的商务平台，我们只提供二手车买卖信息服务，不参与买卖双方的交易过程。买方和卖方直接联系，没有任何第三方吃一分钱的差价。我们本来想全免费提供信息服务的，但考虑到网站平台需要资金维护运作，所以本网站只收取3元钱的网络维护费用。对于几千几万的一部车辆来说，3元钱也不算什么吧？希望大家多多支持并理解，谢谢！</span>
						<span>如果客户另外需要我们的服务(比如代办车辆过户手续等)，可以直接联系我们的客服人员。</span>
						<span>本网站是真正意义上的，没有第三方吃差价。不像某些网商平台，说的没有第三方吃差价，实际上全是套路，各位可以对比一下。希望大家相互传播本网站，谢谢！</span>
					</div>
					<div class="pub-topimg">
						
					</div>
					<div class="pub-detail">
						<c:forEach items="${carList }" var="car">
							<div class="pub-car-box">
								<div class="pub-car">
									<span>${car.brand.brandPinpai }</span>
									<span>${car.series.seriesChexi }</span>
									<span>${car.config.configChexingmingcheng }</span>
									<span>${car.nowPrice }万</span>
								</div>
								<div class="pub-btn">
									<div class="qwe">
										&nbsp;
									</div>
									<a href="/updateCar?carId=${car.carId }" class="btn-change btn-state">修改</a>
									<div class="btn-del btn-state" data-id="${car.carId }">
										删除
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<jsp:include page="commons/mall.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="commons/bottom.jsp"></jsp:include>
	</body>
	<script src="../js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$('.btn-del').click(function(){
			var cfm=confirm('确定删除？')
			if(cfm){
				location.href="/delCar?carId="+$(this).attr("data-id");
			}
		})
	</script>
</html>
