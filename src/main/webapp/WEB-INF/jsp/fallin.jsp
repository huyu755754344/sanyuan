<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>卖二手车</title>
		<link rel="stylesheet" type="text/css" href="css/fallin.css"/>
	</head>
	<body>
		<jsp:include page="commons/head.jsp"></jsp:include>
		<div class="banner"></div>
		<div class="fallin-contain">
			<div class="fallin-cont">
				<div class="fallin-box">
					<div class="fallin-tit">
						<div class="tit-register">
							
						</div>
						<div class="tit-txt">
							
						</div>
						<div class="tit-login">
						
						</div>
					</div>
					<div class="fallin-topimg">
						
					</div>
					<div class="fallin-detail">
						<div class="detail-cont">
							<div class="detail-name">
								基本信息
							</div>
							
							<form action="/car" method="post" id="carForm" enctype="multipart/form-data">
								<div class="detail-box">
									<div class="detail-txt pp-cx-xh">
										品牌<select id="pinpai_select" name="brandId" onchange="pp_change(this)"></select>
											<!-- 车系-型号 -->
											<select class="select-item" id="chexi_select" name="seriesId" onchange="cx_change(this)"></select>
											<select class="select-item" id="xinghao_select" name="modelId"></select>
									</div>
									<div class="detail-txt">
										类型
										<select name="carModel">
											<option value="">请选择类型</option>
											<option>轿车</option>
											<option>越野车</option>
											<option>MPV</option>
											<option>跑车</option>
											<option>面包车</option>
											<option>皮卡</option>
											<option>新能源</option>
											<option>工程车</option>
											<option>货车</option>
											<option>客车</option>
											<option>三轮机动车</option>
											<option>老年代步车</option>
										</select>
									</div>
									<div class="detail-txt">
									    原价<input type="number" name="protPrice" id="" value="" />                      
									</div>
									<div class="detail-txt">
									    现价<input type="number" name="nowPrice" id="" value="" />                      
									</div>
									<div class="detail-txt">
									  	车龄<input type="number" name="carAge" id="" value="" />
									</div>  
									<div class="detail-txt">
										上牌时间<input type="text" name="carShangpai" id="" value="" />
									</div>
									<div class="detail-txt">
										车辆颜色
										<select name="carColor">
											<option value="">请选择颜色</option>
											<option>黑</option>
											<option>白</option>
											<option>红</option>
											<option>灰</option>
											<option>银</option>
											<option>蓝</option>
											<option>黄</option>
											<option>棕</option>
											<option>绿</option>
											<option>橙</option>
											<option>紫</option>
											<option>香槟</option>
											<option>金</option>
											<option>粉</option>
											<option>其它</option>
										</select>
									</div>  
									<div class="detail-txt">
										表显里程<input type="number" name="carKm" id="" value="" />
									</div>
									<div class="detail-txt">
										年检到期<input type="text" name="carAnnual" id="" value="" />
									</div>
									<div class="detail-txt">
										商业险到期<input type="text" name="carInsurance" id="" value="" />
									</div>
									<div class="detail-txt">
										交强险到期<input type="text" name="carSali" id="" value="" />
									</div>
									<div class="detail-txt">
										维修保养<input type="text" name="carUpkeep" id="" value="" />
									</div>
									<div class="detail-txt">
										联系人<input type="text" name="carContact" id="" value="" />
									</div>
									<div class="detail-txt">
										联系电话<input type="number" name="carPhone" id="" value="" />
									</div>
									<div id="district" data-toggle="distpicker">
										看车地址
										<select name="carProvince"></select>
										<select class="ad-item" name="carCity"></select>
										<select class="ad-item" name="carDistrict"></select>
									</div>
									<div class="detail-txt detail-address">
										详细地址<input type="text" name="carAddr" id="" value="" />
									</div>
									<div class="detail-box" style="text-align: center;">
										<textarea rows="9" cols="80" placeholder="车辆描述" name="carDescribe"></textarea>
									</div>
									<div class="detail-txt">
									</div> 
									<input type="file" name="picture" id="uploadImg" accept="image/*" multiple="multiple" onchange="pictures(this)">
								<label class="detail-name" id="lblImg" for="uploadImg">
									上传汽车图片
								</label>
									<div class="detail-txt">
										<a class="detail-btn car_sub" href="javascript:;">发布</a>
									</div> 
								</div>
							</form>
						</div>
						<div class="detail-conts">
						
							
						</div>
					</div>
				</div>
				<jsp:include page="commons/mall.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="commons/bottom.jsp"></jsp:include>
	</body>
<script src="/js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/distpicker.data.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/distpicker.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/submit.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$(".lgn-btn").click(function(){
	$("#form-lgn").submit();
});
</script>
<script type="text/javascript">
var s=60;
function timer (cl){
	s--;
	$(cl).html('重新发送('+s+')');
	$(cl).css({'pointer-events':'none'})
	if(s==0){
		s=60;
		$(cl).html('获取验证码');
		$(cl).css('pointer-events','')
		return;
	}else
	setTimeout(function(){
		timer (cl);
	},1000);
}
$('#getcode').click(function(){
	if(verfiyPhone($('#phone'))){
		timer($('#getcode'));
		var phone = $('#phone').val();
		$.post("/sendCode",{"phone":phone},function(){});
	}
})

$('.getCode').click(function(){
	if(verfiyPhone($('#log_phone'))){
		timer($('.getCode'));
		var phone = $('#log_phone').val();
		$.post("/sendLCode",{"phone":phone},function(){});
	}
})
function verfiyPhone(p){
	var phone = $(p).val().trim();
	if(phone==null||phone==""){
		alert('请输入手机号');
		return false;
	}else if(!/^1[3456789]\d{9}$/.test(phone)){ 
		alert('格式不正确')
	  	return false;
    }
	return true;
}
	function verfiyCode(){
		var flag = false;
		var code =$("#code").val().trim();
		if(code==""||code==null){
			alert("请填写验证码");
			flag = false;
		}else{
			var phone = $('#phone').val().trim();
			$.ajax({
	    		type:"post",
				url:"/verfiyCode",
				data:{"code":code,"phone":phone},
				dataType:"json",
				async:false,
				success:function(result){
		    		if(result.status=="200"){
		    			flag = true;
		    		}else{
		    			alert('验证码有误');
		    		  	flag = false;
		    		}
				}
	    	})
		}
		return flag;
	}
	function verfiyName(){
		if($('#userName').val().length>=2 && /[\u4E00-\u9FA5\uF900-\uFA2D]/.test($('#userName').val())){
			return true
		}else{
			alert('姓名格式不正确')
			return false
		}
	}

	function verfiyIdCard(){
		if(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test($('#userIdCard').val())){
			return true
		}else{
			alert('身份证格式不正确');
			return false
		}
	}
	function approveIdCard(){
		var flag=false;
		if(verfiyName()&&verfiyIdCard()){
			$.ajax({
				type:"get",
				url:"/verfiyIdCard?name="+$('#userName').val()+'&idCard='+$('#userIdCard').val(),
				dataType:"json",
				async:false,
				success:function(ev){
					if(ev.status=="01"){
						flag=true
					}else{ 
						flag=false
						alert(ev.msg);
					}
				}
			})
		}
		return flag;
	}
	
	$(".regSub").click(function(){
		if(approveIdCard()&&verfiyCode()){
			$("#form-reg").submit();
		}
	});

</script>
<script type="text/javascript">
	$(".car_sub").click(function(){
		if($('#pinpai_select').val()==''){
			alert("请选择车辆品牌")
			return false
		}else if($('#chexi_select').val()==''){
			alert("请选择车系")
			return false
		}else if($('[name=nowPrice]').val()==''){
			alert("请输入价格")
			return false
		}else if(/d/.test($('[name=nowPrice]').val())){
			alert('请输入正确的价格')
			return false
		}else if($('[name=protPrice]').val()==''){
			if(/d/.test($('[name=protPrice]').val())){
				alert("原价格式错误")
				return false
			}
		}
		else if($('[name=carAge]').val()==''){
			alert("清输入车龄")
			return false
		}else if(/d/.test($('[name=carAge]'))){
			alert('请输入正确的车龄')
			return false
		}else if($('[name=carShangpai]').val()==''){
			alert("请输入上牌时间")
			return false
		}
		else if($('[name=carColor]').val()==''){
			alert("请选择车辆颜色")
			return false
		}else if($('[name=carContact]').val()==''){
			alert("请输入联系人名字")
			return false
		}else if($('[name=carPhone]').val()==''){
			alert("请输入联系人电话")
			return false
		}else if(!/^1[3456789]\d{9}$/.test($('[name=carPhone]').val())){
			alert("联系人电话格式错误")
			return false
		}
		
		
		
		
		$("#carForm").submit();
	});
</script>
<script type="text/javascript">
	$("#district").distpicker({
		placeholder: false
	});
	$.ajax({
		type:"get",
		url:"/getBrand",
		dataType:"json",
		success:function(ev){
			var cont='<option value="">请选择品牌</option>'
			$.each(ev.data,function(r,q){
				cont+='<option value="'+q['brandPinpaiId']+'">'+q['brandPinpai']+'</option>'
			})
			$('.detail-box .detail-txt #pinpai_select').append(cont)
		}
	})
	
	function pp_change(a){
		$('#chexi_select').show();
		$.ajax({
			type:"get",
			url:"/getSeries?brandId="+$(a).val(),
			dataType:"json",
			success:function(ev){
					var cont='<option value="">请选择车系</option>'
					$('.detail-box .detail-txt #chexi_select option').remove()
					$.each(ev.data,function(r,q){
						cont+='<option value="'+q['seriesChexiId']+'">'+q['seriesChexi']+'</option>'
					})
					$('.detail-box .detail-txt #chexi_select').append(cont)
			}
		})
	}
	
	function cx_change(n){
		var brandId=$('#pinpai_select').val()
		var seriesId=$(n).val()
		$.ajax({
			type:"get",
			url:"/getModel",
			data:{'brandId':brandId,'seriesId':seriesId},
			dataType:"json",
			success:function(ev){
				if(ev.data.length==0)
					$('#xinghao_select').hide();
				else
					$('#xinghao_select').show();
				var cont='<option value="">请选择型号</option>'
				$('.detail-box .detail-txt #xinghao_select option').remove()
				$.each(ev.data,function(r,q){
					cont+='<option value="'+q['modelId']+'">'+q['modelName']+'</option>'
				})
				$('.detail-box .detail-txt #xinghao_select').append(cont)
			}
		})
	}
	var msg = GetQueryString("result");
	if(msg=="false") alert("请先登录");
	if(msg=="0") alert("手机号有误");
	if(msg=="1") alert("验证码有误");
</script>
<script type="text/javascript">
var input = document.getElementById("uploadImg"); // 获取input节点
input.onchange = function() {
　　　　//var file = this.files[0];
console.log(this.files.length);
var num =this.files.length;
	 if(num<=6){
		　　$.each(this.files,function(index,value){
			if (!!value) {
			　　　　　　var reader = new FileReader(); // 图片文件转换为base64
			　　　　　　reader.readAsDataURL(value);//用文件加载器加载文件
			　　　　　　reader.onload = function() { // 显示图片
						$(".detail-conts").append("<img src='"+this.result+"'>");
					}
			　　　　} 
		　　　})
	 }
	 else { 
		alert("图片不超过6张");
		return false;	
	 }
　 
　　}


</script>
</html>
