<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="/css/change.css"/>
	</head>
	<body>
		<jsp:include page="commons/head.jsp"></jsp:include>
		<div class="banner"></div>
		<div class="change-contain">
			<div class="change-cont">
				<div class="change-box">
					<div class="change-tit">
					</div>
					<div class="change-topimg">
					</div>
					<div class="change-detail">
						<div class="detail-cont">
							<div class="detail-name">
								基本信息
							</div>
							<div class="detail-box">
								<form action="/update" method="post" id="upForm">
									<input type="hidden" name="carId" value="${car.carId }">
									<div class="detail-txt pp-cx-xh">
										品牌<select id="pinpai_select" name="brandId" onchange="pp_change(this)">
											<option value="0">请选择品牌</option>
										</select>
											<!-- 车系-型号 -->
											<select class="select-item" id="chexi_select" name="seriesId" onchange="cx_change(this)"></select>
											<select class="select-item" id="xinghao_select" name="modelId"></select>
									</div>
									<div class="detail-txt">
										类型
										<select name="carModel" id="carModel">
											<option value="0">请选择类型</option>
											<option value="1">轿车</option>
											<option value="2">越野车</option>
											<option value="3">MPV</option>
											<option value="4">跑车</option>
											<option value="5">面包车</option>
											<option value="6">皮卡</option>
											<option value="7">新能源</option>
											<option value="8">工程车</option>
											<option value="9">货车</option>
											<option value="10">客车</option>
											<option value="11">三轮机动车</option>
											<option value="12">老年代步车</option>
										</select>
									</div>
									<div class="detail-txt">
									   原价<input type="" name="protPrice" id="" value="${car.protPrice }" />                      
									</div>
									<div class="detail-txt">
									    现价<input type="" name="nowPrice" id="" value="${car.nowPrice }" />                      
									</div>
									<div class="detail-txt">
									  	车龄<input type="" name="carAge" id="" value="${car.carAge }" />
									</div>  
									<div class="detail-txt">
										上牌时间<input type="" name="carShangpai" id="" value="${car.carShangpai }" />
									</div>
									<div class="detail-txt">
										车辆颜色
										<select name="carColor" id="carColor">
											<option value="0">请选择颜色</option>
											<option value="黑">黑</option>
											<option value="白">白</option>
											<option value="红">红</option>
											<option value="灰">灰</option>
											<option value="银">银</option>
											<option value="蓝">蓝</option>
											<option value="黄">黄</option>
											<option value="棕">棕</option>
											<option value="绿">绿</option>
											<option value="橙">橙</option>
											<option value="紫">紫</option>
											<option value="香槟">香槟</option>
											<option value="金">金</option>
											<option value="粉">粉</option>
											<option value="其它">其它</option>
										</select>
									</div>  
									<div class="detail-txt">
										表显里程<input type="" name="carKm" id="" value="${car.carKm }" />
									</div>
									<div class="detail-txt">
										年检到期<input type="" name="carAnnual" id="" value="${car.carAnnual }" />
									</div>
									<div class="detail-txt">
										商业险到期<input type="" name="carInsurance" id="" value="${car.carInsurance }" />
									</div>
									<div class="detail-txt">
										交强险到期<input type="" name="carSali" id="" value="${car.carSali }" />
									</div>
									<div class="detail-txt">
										维修保养<input type="" name="carUpkeep" id="" value="${car.carUpkeep }" />
									</div>
									<div class="detail-txt">
										联系人<input type="" name="carContact" id="" value="${car.carContact }" />
									</div>
									<div class="detail-txt">
										联系电话<input type="" name="carPhone" id="" value="${car.carPhone }" />
									</div>
									<div id="district" data-toggle="distpicker">
										看车地址
										<select name="carProvince" data-province="${car.carProvince}"></select>
										<select class="ad-item" name="carCity" data-city="${car.carCity}"></select>
										<select class="ad-item" name="carDistrict" data-district="${car.carDistrict}"></select>
									</div>
									<div class="detail-txt detail-address">
										详细地址<input type="" name="carAddr" id="" value="${car.carAddr }" />
									</div>
									<textarea rows="9" cols="81" name="carDescribe" style="margin-left: 150px;" placeholder="情输入车辆描述">${car.carDescribe }</textarea>
									<div class="detail-txt">
									</div> 
									<div class="detail-txt">
										<a class="detail-btn" href="javascript:;">修改</a>
									</div> 
								</form>
							</div>
						</div>
						<!-- <div class="detail-cont">
							<input type="file" id="uploadImg" accept="image/*" onchange="submitImg(this)">
							<label class="detail-name" id="lblImg" for="uploadImg">
								上传汽车图片
							</label>
						</div> -->
						
					</div>
				</div>
				<jsp:include page="commons/mall.jsp"></jsp:include>
			</div>
		</div>
	</body>
	<script src="/js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/distpicker.data.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/distpicker.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		if("${car.carModel}"!="")
		$("#carModel").val("${car.carModel}");
		if("${car.carColor}"!="")
		$("#carColor").val("${car.carColor}");
		$("#district").distpicker({placeholder: false});
		$(".detail-btn").click(function(){$("#upForm").submit();});
		$.ajax({
			type:"get",
			url:"https://xn--ehq91f.hunlian.art/getBrand",
			dataType:"json",
			success:function(ev){
				var cont=''
				$.each(ev.data,function(r,q){
					cont+='<option value="'+q['brandPinpaiId']+'">'+q['brandPinpai']+'</option>'
				})
				$('.detail-box .detail-txt #pinpai_select').append(cont);
				var brandId = "${car.brandId}";
				if(brandId!=""){
					$("#pinpai_select").val(brandId);
					pp_change($("#pinpai_select"));
				}
			}
		
		})
		
		function pp_change(a){
			$.ajax({
				type:"get",
				url:"https://xn--ehq91f.hunlian.art/getSeries?brandId="+$(a).val(),
				dataType:"json",
				success:function(ev){
					var cont='<option value="0">请选择车系</option>'
					$('.detail-box .detail-txt #chexi_select option').remove()
					$.each(ev.data,function(r,q){
						cont+='<option value="'+q['seriesChexiId']+'">'+q['seriesChexi']+'</option>'
					})
					$('.detail-box .detail-txt #chexi_select').append(cont);
					var seriesId = "${car.seriesId}";
					if(seriesId!=""){
						$("#chexi_select").val(seriesId);
						cx_change($("#chexi_select"));
					}
				}
			})
		}
		
		function cx_change(n){
			var brandId=$('#pinpai_select').val()
			var seriesId=$(n).val()
			$.ajax({
				type:"get",
				url:"https://xn--ehq91f.hunlian.art/getModel",
				data:{
					'brandId':brandId,
					'seriesId':seriesId
				},
				dataType:"json",
				success:function(ev){
					var cont=''
					if(ev.data.length==0){
						$('#xinghao_select').hide();
					}else
						$('#xinghao_select').show();
					cont='<option value="0">请选择型号</option>'
					$('.detail-box .detail-txt #xinghao_select option').remove()
					$.each(ev.data,function(r,q){
						cont+='<option value="'+q['modelId']+'">'+q['modelName']+'</option>'
					})
					$('.detail-box .detail-txt #xinghao_select').append(cont);
					$("#xinghao_select").val("${car.modelId}");
				}
			})
		}	
	</script>
</html>
