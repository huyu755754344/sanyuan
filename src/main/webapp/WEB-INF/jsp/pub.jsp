<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>我的发布</title>
		<link rel="stylesheet" type="text/css" href="css/pub.css"/>
	</head>
	<body>
		<jsp:include page="commons/head.jsp"></jsp:include>
		<div class="banner"></div>
		<div class="pub-contain">
			<div class="pub-cont">
				<div class="pub-box">
					<div class="pub-tit">
						
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
