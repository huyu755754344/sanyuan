<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>买二手车</title>
		<link rel="stylesheet" type="text/css" href="/css/search.css"/>
		<style>
			.car-tit span {
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
		<div class="car-contain">
			<div class="car-cont">
				<div class="car-box">
					<div class="car-tit">
						<span>各位先生，女士，朋友们，大家好！<span>
						<span>本网站是一家专业提供二手车信息服务的商务平台，我们只提供二手车买卖信息服务，不参与买卖双方的交易过程。买方和卖方直接联系，没有任何第三方吃一分钱的差价。我们本来想全免费提供信息服务的，但考虑到网站平台需要资金维护运作，所以本网站只收取3元钱的网络维护费用。对于几千几万的一部车辆来说，3元钱也不算什么吧？希望大家多多支持并理解，谢谢！</span>
						<span>如果客户另外需要我们的服务(比如代办车辆过户手续等)，可以直接联系我们的客服人员。</span>
						<span>本网站是真正意义上的，没有第三方吃差价。不像某些网商平台，说的没有第三方吃差价，实际上全是套路，各位可以对比一下。希望大家相互传播本网站，谢谢！</span>
					</div>
					<div class="car-topimg">
						
					</div>
					<div class="car-search">
						<input type="text" name="" id="bid" value="" />
						<a href="javascript:;">搜索</a>
					</div>
					<div class="car-buy">
						<div  id="details" class="buy-tit">
							二手车交易
						</div>
						<div class="buy-fiter">
							<jsp:include page="commons/term.jsp"></jsp:include>
						</div>
						<div class="clear-box">
							
						</div>
					</div>
					<div class="car-business">
						<div class="identity">
							<a href="javascript:;${identity}" class="<c:if test="${identity==0 }">select</c:if>" data-id="0">个人</a>
							<a href="javascript:;" class="<c:if test="${identity==1 }">select</c:if>" data-id="1">商家</a>
						</div>
						
						<div class="business-tit">
							车辆展示
						</div>
						<div class="business-fiter">
							<c:forEach items="${carList.getList() }" var="car">
								<c:choose>
									<c:when test="${!identity.equals('3') }">
										<c:if test="${car.user.identity==identity }">
											<div class="business-cars" onclick="window.open('/detail?carId=${car.carId}')">
												<img class="cars-carimg"  src="${car.imgPath }" >
												<div class="cars-intro">
													<div class="intro-left float">
														${car.brand.brandPinpai }
													</div>
													<div class="intro-right float">
														<del>原价:${car.protPrice }万</del>
														<span id="now-prise">${car.nowPrice }万</span>
													</div>
												</div>
											</div>
										</c:if>
									</c:when>
									<c:otherwise>
										<div class="business-cars" onclick="window.open('/detail?carId=${car.carId}')">
											<img class="cars-carimg"  src="${car.imgPath }" >
											<div class="cars-intro">
												<div class="intro-left float">
													${car.brand.brandPinpai }
												</div>
												<div class="intro-right float">
													<del>原价:${car.protPrice }万</del>
													<span id="now-prise">${car.nowPrice }万</span>
												</div>
											</div>
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
						<ul>
						<c:forEach var="num" begin="0" end="${total }" step="1">
						<li  onclick='fuck(${num})'>${num + 1 }</li>
						</c:forEach>
						</ul>
						<!-- ------------------------ -->
					</div>
				</div>
				<jsp:include page="commons/mall.jsp"></jsp:include>
			</div>
		</div>
		<script src="js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/distpicker.data.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/distpicker.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	function fuck(a){
		var url = "/search?";
		var id = $(this).attr("data-id");
		if($("#carModel").val()!=""&&$("#carModel").val()!=null)
			url+="&carModel="+$("#carModel").val();
		if($("#brand").val()!=""&&$("#brand").val()!=null)
			url+="&brandId="+$("#brand").val();
		if($("#brandName").val()!=""&&$("#brandName").val()!=null)
			url+="&brandName="+$("#brandName").val();
		if($("#seriesId").val()!=""&&$("#seriesId").val()!=null)
			url+="&seriesId="+$("#seriesId").val();
		if($(".pic").attr("data-val")!=""&&$(".pic").attr("data-val")!=null)
			url+="&price="+$("#price").val();
		if(id!=null&&id!=""){
			url+="&identity="+id;
		}
		url=url + "&pageNum="+a;
		url += "#details";
		location.href=url;
	}
	</script>
	<script type="text/javascript">
	$(".model_cl").click(function(){
		$("#carModel").val($(this).html());
		click_cl();
	});
	var model = $(".model_cl");
	var carModel = "${carModel}";
	for(var i=0;i<model.length;i++){
		if($(model[i]).html()==carModel){
			$(model[i]).addClass("select").siblings().removeClass("select");
		}
	}
	$(".cl_p").click(function(){
		$("#brand").val($(this).attr("data-id"));
		$("#seriesId").val("");
		click_cl();
	});
	var cl_p = $(".cl_p");
	var brand = "${brandId}";
	var count = 0;
	for(var i=0;i<cl_p.length;i++){
		if($(cl_p[i]).attr("data-id")==brand){
			$(cl_p[i]).addClass("select").siblings().removeClass("select");
			count++;
		}
	}
	if(count==0&&brand!=""){
		$(cl_p[cl_p.length-1]).addClass("select").html("${brandName}").siblings().removeClass("select");
	}
	
	function cl_cx(cxId){
		$("#seriesId").val(cxId);
		click_cl();
	}
	
	$(".pic").click(function(){
		$("#price").val($(this).attr("data-val"));
		click_cl();
	});
	
	var pic = $(".pic");
	var price = "${price}";
	for(var i=0;i<pic.length;i++){
		if($(pic[i]).attr("data-val")==price){
			$(pic[i]).addClass("select").siblings().removeClass("select");
			count++;
		}
	}
	
	$(".identity a").click(function(){
		click_cl($(this).attr("data-id"));
	});
	
	function click_cl(id){
		var url = "/search?";
		if($("#carModel").val()!=""&&$("#carModel").val()!=null)
			url+="&carModel="+$("#carModel").val();
		if($("#brand").val()!=""&&$("#brand").val()!=null)
			url+="&brandId="+$("#brand").val();
		if($("#brandName").val()!=""&&$("#brandName").val()!=null)
			url+="&brandName="+$("#brandName").val();
		if($("#seriesId").val()!=""&&$("#seriesId").val()!=null)
			url+="&seriesId="+$("#seriesId").val();
		if($(".pic").attr("data-val")!=""&&$(".pic").attr("data-val")!=null)
			url+="&price="+$("#price").val();
		if(id!=null&&id!=""){
			url+="&identity="+id;
		}
		url += "#details";
		location.href=url;
	}
		
	</script>
	<script type="text/javascript">
		$('#moreBraindbtn').click(function(){
			$('.garbage .other').toggle()
		})
		//第一个
		$.ajax({
			type:"get",
			url:"https://xn--ehq91f.hunlian.art/getBrand",
			dataType:"json",
			success:function(ev){
				var ctxt='';
				$.each(ev.data,function(r,q){
					if(q['brandShouzimu']=="A"){
						ctxt+='<span class="cl_sp" onclick=vehicle(this) data-id='+q["brandPinpaiId"]+'>'+q['brandPinpai']+'</span>'
					}
				})
				$('.garbage .other ul li:first').addClass('active');
				$('.garbage .other .all-car').append(ctxt)
			}
		})
		//点击字母
		$('.garbage .other ul li').click(function(){
			$('.garbage .other ul li').removeClass('active')
			$(this).addClass('active')
			var txt=$(this).html()
			$.ajax({
				type:"get",
				url:"https://xn--ehq91f.hunlian.art/getBrand?brandShouzimu="+txt,
				dataType:"json",
				success:function(ev){
					var cont=''
					$('.garbage .other .all-car span').remove()
					$.each(ev.data,function(r,q){
						cont+='<span class="cl_sp" onclick=vehicle(this) data-id='+q["brandPinpaiId"]+'>'+q["brandPinpai"]+'</span>'
					})
					$('.garbage .other .all-car').append(cont);
				}
			})
		})
		
		function get_cx(id){
			$.ajax({
				type:"post",
				url:"https://xn--ehq91f.hunlian.art/getSeries?brandId="+id,
				dataType:"json",
				success:function(ev){
					var cont='<a class="select_all select" data-id="seriesId" href="javascript:;">不限</a>'
					var len = ev.data.length
					if(len>12){
						$.each(ev.data,function(r,q){
							cont+='<a href="javascript:;" data-id='+q["seriesChexiId"]+' onclick=cl_cx('+q["seriesChexiId"]+') class="vehic t-hide">'+q["seriesChexi"]+'</a>'
						})
						cont+='<a id="moreChexibtn" href="javascript:;" onclick=more(this) class="filter_btn">更多</a>'
					}else{
						$.each(ev.data,function(r,q){
							cont+='<a href="javascript:;" data-id='+q["seriesChexiId"]+' onclick=cl_cx('+q["seriesChexiId"]+') class="vehic">'+q["seriesChexi"]+'</a>'
						})
					}
					$('.garbage .vhc a').remove()
					$('.garbage .vhc').append(cont)
					for(var i=0;i<12;i++){
						$('.garbage .vhc .vehic:nth-child('+i+')').removeClass('t-hide')
					}
					var cx = $(".vehic");
					var cx_id = "${seriesId}";
					for(var i=0;i<cx.length;i++){
						if($(cx[i]).attr("data-id")==cx_id){
							$(cx[i]).addClass("select").siblings().removeClass("select");
						}
					}
					$(".select_all").bind("click",function(){
						var id = $(this).attr("data-id");
						if(id=="brand"){
							$("#brandName").val("");
							$("#seriesId").val("");
						}
						$("#"+id).val("");
						click_cl();
					})
				}
			})
		}
		//点击品牌
		function vehicle(sp){
			var id = $(sp).attr("data-id");
			if(id==null||id=="")
				id="${brandId}";
			$("#brand").val(id);
			$("#brandName").val($(sp).html());
			click_cl();
		}
		if("${brandId}"!=""){
			get_cx("${brandId}");
		}else{
			get_cx("12");
		}
		//点击更多品牌
		$('#moreChexibtn').click(function(){
			$(this).hide()
			$('.t-hide').show()
		})
		function more(n){
			$(n).hide()
			$('.t-hide').show()
		}
		$("#district").distpicker({
			autoSelect: false
		});
		
	</script>
	<jsp:include page="commons/bottom.jsp"></jsp:include>
	</body>
</html>
