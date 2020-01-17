<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>${car.brand.brandPinpai} ${car.series.seriesChexi} ${car.config.configPailiangL }L ${car.config.configBiansuxiang }</title>
		<link rel="stylesheet" type="text/css" href="/css/detail.css"/>
		<link rel="stylesheet" type="text/css" href="/css/swiper.css"/>
		<link rel="stylesheet" type="text/css" href="/css/laye/theme/default/layer.css"/>
		<style>
			.layerBox {
				width: 100%;
				height: 100%;
				background-image: url('/img/wx-apply.png');
			}
			.layerShow {
				width: 233px;
				height: 233px;
				background-color: pink;
				position: absolute;
				top: 201px;
				left: 40px;
			}
		</style>
	</head>
	<body>
		<jsp:include page="commons/head.jsp"></jsp:include>
		<div class="banner"></div>
		<div class="intro-contain">
			<div class="intro-cont">
				<div class="intro-box">
					<div class="intro-tit">
						
					</div>
					<div class="intro-topimg">
						
					</div>
					<div class="intro-carimg">
						<div class="intro-left">
							<div class="swiper-container gallery-top">
								<div class="swiper-wrapper">
									<c:forEach items="${pictureList }" var="pricture">
										<div class="swiper-slide" style="background-image:url(${pricture.picture})"></div>
									</c:forEach>
								</div>
								<!-- Add Arrows -->
							</div>
							<div class="swiper-container gallery-thumbs">
								<div class="swiper-wrapper">
									<c:forEach items="${pictureList }" var="pricture">
										<div class="swiper-slide swiper-little" style="background-image:url(${pricture.picture})"></div>
									</c:forEach>
								</div>
								<div class="swiper-button-next swiper-button-white"></div>
								<div class="swiper-button-prev swiper-button-white"></div>
							</div>
						</div>
						<ul class="intro-right">
							<li>${car.brand.brandPinpai} ${car.series.seriesChexi} ${car.config.configPailiangL }L ${car.config.configBiansuxiang }</li>
							<li>
								<div class="c-item">
									<div class="">
										${car.carKm }万公里
									</div>
									<div class="">
										表显里程
									</div>
								</div>
								<div class="c-ver"></div>
								<div class="c-item">
									<div class="">
										${car.carShangpai }
									</div>
									<div class="">
										首次上牌
									</div>
								</div>
								<div class="c-ver"></div>
								<div class="c-item">
									<div class="">
										${car.config.configPailiangL }L/${car.config.configBiansuxiang }
									</div>
									<div class="">
										排量／变速箱
									</div>
								</div>
							</li>
							<li>	
                            	￥<span>${car.nowPrice }</span>万
							</li>
							<li>
								<div class="c-phone" id="showPhoneNum">
									查看电话号码
								</div>
							</li>
							<li>
								<div class="sale">
									卖家：${car.user.userName }
								</div>
								<div class="address">
									看车地址：${car.carProvince }${car.carDistrict }${car.carAddr }
								</div>
							</li>
						</ul>
					</div>
					<div class="car-intro">
						<div class="ito-basic">
							<div class="car-tit">
								基本信息
							</div>                   
							<div class="car-txt">
								<div class="t-box">
									<span>车龄</span>
									<span>${car.carAge}</span>
								</div>
								<div class="t-box">
									<span>维修保养</span>
									<span>${car.carUpkeep }</span>    
								</div>	
								<div class="t-box">
									<span>年检到期</span>
									<span>${car.carAnnual }</span>    
								</div>	
								<div class="t-box">
									<span>本车排量</span>
									<span>${car.config.configPailiangL }L</span>
								</div>
								<div class="t-box">
									<span>商业险到期</span>
									<span>${car.carInsurance }</span>    
								</div>	
								<div class="t-box">
									<span>变速箱</span>
									<span>${car.config.configBiansuxiang }</span>
								</div>
								<div class="t-box">
									<span>交强险到期</span>
									<span>${car.carSali }</span>    
								</div>	
								<div class="t-box">
									<span>驱动方式</span>
									<span>${car.config.configQudongfangshi }</span>    
								</div>	
								<div class="t-box">
									<span>车辆颜色</span>
									<span>${car.carColor }</span>    
								</div>
							</div>
						</div>
						<div class="ito-basic">
							<div class="car-tit">
								车身参数
							</div>            			
							<div class="car-txt">
								<div class="t-box">
									<span>长×宽×高(mm)</span>
									<span>${car.config.configChangduMm }×${car.config.configKuanduMm }×${car.config.configGaoduMm }</span>
								</div>
								<div class="t-box">
									<span>轴距(mm)</span>
									<span>${car.config.configZhoujuMm }</span>    
								</div>	
								<div class="t-box">
									<span>前轮距(mm)</span>
									<span>${car.config.configQianlunjuMm }</span>
								</div>
								<div class="t-box">
									<span>后轮距(mm)</span>
									<span>${car.config.configHoulunjuMm }</span>    
								</div>	
								<div class="t-box">
									<span>最小离地间隙(mm)</span>
									<span>${car.config.configZuixiaolidijianxiMm }</span>
								</div>
								<div class="t-box">
									<span>车身结构</span>
									<span>${car.config.configCheshenjiegou }</span>    
								</div>	
								<div class="t-box">
									<span>整备质量(kg)</span>
									<span>${car.config.configZhengbeizhiliangKg }</span>
								</div>
								<div class="t-box">
									<span>车门数(个)</span>
									<span>${car.config.configChemenshuGe }</span>
								</div>
								<div class="t-box">
									<span>座位数(个)</span>
									<span>${car.config.configZuoweishuGe }</span>    
								</div>	
								<div class="t-box">
									<span>环保标准</span>
									<span>${car.config.configHuanbaobiaozhun }</span>    
								</div>    
								 <div class="t-box">
								 	<span></span>
								 	<span></span>    
								 </div>  
								<div class="t-box">
									<span>&nbsp;</span>
									<c:if test="${!car.getModelId().equals('')&&car.getModelId()!=null }">
										<span><a class="more-parameter" href="/getParam?brandId=${car.brandId }&seriesId=${car.seriesId }&modelId=${car.modelId }" target="_blank">更多参数</a></span>
									</c:if>    
								</div>  
								
							</div>
						</div>
						<div class="ito-basic">
							<div class="car-tit">
								配置信息
							</div>
							<div class="car-txt">
								<div class="t-box">
									<span>档位个数</span>
									<span>${car.config.configDangweigeshu }</span>
								</div>
								<div class="t-box">
									<span>发动机缸数</span>
									<span>${car.config.configQigangshuGe }</span>    
								</div>	
								<div class="t-box">
									<span>最大功率</span>
									<span>${car.config.configZuidagonglvzhuansuRpm }</span>    
								</div>	
								<div class="t-box">
									<span>综合油耗</span>
									<span>${car.config.configGongxinbuzongheyouhaoL100km }100km/L</span>
								</div>
								<div class="t-box">
									<span>进气类型</span>
									<span>${car.config.configJinqixingshi }</span>    
								</div>	
								<div class="t-box">
									<span>车身结构</span>
									<span>${car.config.configCheshenjiegou }</span>
								</div>   		
							</div>
						</div>
						<div class="ito-basic">
							<div class="car-tit">
								车辆描述
							</div>
							<div class="car-txt">
								<label>${car.carDescribe }</label>	
							</div>
						</div>
						
					</div>
				</div>
				<jsp:include page="commons/mall.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="commons/bottom.jsp"></jsp:include>
	</body>
	<script src="/js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="/css/layer/layer.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/swiper.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		var galleryTop = new Swiper('.gallery-top', {
			nextButton: '.swiper-button-next',
			prevButton: '.swiper-button-prev',
		    spaceBetween: 10,
			loopedSlides: 5,
		});
		var galleryThumbs = new Swiper('.gallery-thumbs', {
		    spaceBetween: 10,
		    centeredSlides: true,
		    slidesPerView: 'auto',
		    touchRatio: 0.2,
		    slideToClickedSlide: true,
			navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
			},
				watchSlidesVisibility: true,
				watchSlidesProgress: true,
		});
		galleryTop.params.control = galleryThumbs;
		galleryThumbs.params.control = galleryTop;
		
	　　	function GetUrlPara(){
	　　　　	var url = document.location.toString();
　　　　		var arrUrl = url.split("?");

　　　　		var para = arrUrl[1];
　　　	　		return para;
	　　	}
		
		// 显示电话号码
		$('#showPhoneNum').click(function(){
 			var dataNum = GetUrlPara()
			dataNum = dataNum.replace("=",":")
			$.ajax({
					url:"/showPhoneNum", 
					dataType:"json", 
					async:true,
					data:{ dataNum }, 
					type:"POST",  
					success:function(data){
						$('#showPhoneNum').val(data)
					},
					error: function(XMLHttpRequest, textStatus, errorThrown) {
						if(XMLHttpRequest.status == 222 ){
							layer.open({
								type: 1,    
								title: false, //不显示标题栏
								area: ['315px', '460px'],  // 设置宽高
								content: '<div class="layerBox">'
									+'<div class="layerShow"></div>'
									+'</div>'
							});
						}
	                }
				});
		})
	</script>
</html>
