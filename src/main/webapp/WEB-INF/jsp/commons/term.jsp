<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="/css/term.css"/>
	</head>
	<body>
		<div class="filter-cont">
			<div class="filter-box">
				<ul class="garbage">
					<li>车型：</li>
					<li>
						<a class="select_all select" href="javascript:;" data-id="carModel">不限</a>
						<a class="model_cl" href="javascript:;">越野车</a>
						<a class="model_cl" href="javascript:;">跑车</a>
						<a class="model_cl" href="javascript:;">轿车</a>
						<a class="model_cl" href="javascript:;">工程车</a>
						<a class="model_cl" href="javascript:;">MPV</a>
						<a class="model_cl" href="javascript:;">面包车</a>
						<a class="model_cl" href="javascript:;">皮卡</a>
						<a class="model_cl" href="javascript:;">新能源</a>
						<a class="model_cl" href="javascript:;">货车</a>
						<a class="model_cl" href="javascript:;">客车</a>
						<a class="model_cl" href="javascript:;">三轮机动车</a>
						<a class="model_cl" href="javascript:;">老年代步车</a>
						<input type="hidden" id="carModel" value="${carModel }">
					</li>
				</ul>
				<ul class="garbage">
					<li>品牌：</li>
					<li>
						<a class="select_all select" href="javascript:;" data-id="brand">不限</a>
						<a class="cl_p" href="javascript:;" data-id="15">宝马</a>
						<a class="cl_p" href="javascript:;" data-id="33">奥迪</a>
						<a class="cl_p" href="javascript:;" data-id="36">奔驰</a>
						<a class="cl_p" href="javascript:;" data-id="1">大众</a>
						<a class="cl_p" href="javascript:;" data-id="14">本田</a>
						<a class="cl_p" href="javascript:;" data-id="38">别克</a>
						<a class="cl_p" href="javascript:;" data-id="3">丰田</a>
						<a class="cl_p" href="javascript:;" data-id="8">福特</a>
						<a class="cl_p" href="javascript:;" data-id="26">奇瑞</a>
						<a class="cl_p" href="javascript:;" data-id="12">现代</a>
						<a class="cl_p" href="javascript:;" data-id="58">马自达</a>
						<a class="cl_p" href="javascript:;" data-id="75">比亚迪</a>
						<a class="cl_p" href="javascript:;" data-id="72">雪铁龙</a>
						<a class="cl_p" href="javascript:;" data-id="25">吉利</a>
						<a id="moreBraindbtn" class="filter_btn">其它品牌<em></em></a>
					</li>
					<div class="other" style=" display: none;overflow: hidden; width: 760px;clear: both;margin-left: 55px;">
						<ul> 
							<li>A</li>
							<li>B</li>
							<li>C</li>
							<li>D</li>
							<li>F</li>
							<li>G</li>
							<li>H</li>
							<li>J</li>
							<li>K</li>
							<li>L</li>
							<li>M</li>
							<li>N</li>
							<li>O</li>
							<li>P</li>
							<li>Q</li>
							<li>R</li>
							<li>S</li>
							<li>T</li>
							<li>V</li>
							<li>W</li>
							<li>X</li>
							<li>Y</li>
							<li>Z</li>
						</ul>
						<div class="all-car"></div>
						<input type="hidden" id="brand" value="${brandId }">
						<input type="hidden" id="brandName" value="${brandName }">
					</div>
				</ul>
				<ul class="garbage">
					<li>车系：</li>
					<li class="vhc">
						
					</li>
				</ul>
				<input type="hidden" id="seriesId" value="${seriesId }">
				<ul class="garbage">
					<li>价格：</li>
					<li>
						<a class="select_all select" href="javascript:;" data-id="price">不限</a>
						<a href="javascript:;" class="pic" data-val="0,3">3万元以内</a>
						<a href="javascript:;" class="pic" data-val="3,5">3-5万元</a>
						<a href="javascript:;" class="pic" data-val="5,7">5-7万元</a>
						<a href="javascript:;" class="pic" data-val="7,10">7-10万元</a>
						<a href="javascript:;" class="pic" data-val="10,99999">10万元以上</a>
						<!-- <span class="priceFilter">
							<span class="text text2"><input type="text" size="3"  onchange="cknum(this)" min="0"
								 name="b_q" autocomplete="off"></span>
							<span class="dev">-</span>
							<span class="text text2"><input type="text" size="3"  onchange="cknum(this)" min="0"
								 name="b_q" autocomplete="off"></span>
							<i class="filter_unit">万元</i>
							<button class="defined" type="button">确定</button>
						</span> -->
						<input type="hidden" id="price" value="${price }">
					</li>
				</ul>
				<ul class="garbage">
					<li>更多：</li>
					<li>
						<!-- <span>车龄</span> -->
						<select class="filter-drop" name="">
							<option  selected disabled style="display: none;">车龄</option>
							<option value="0,1">1年以内</option>
							<option value="1,3">1-3年</option>
							<option value="3,5">3-5年</option>
							<option value="5,8">5-8年</option>
							<option value="8,10">8-10年</option>
							<option value="10,9999">10年以上</option>
						</select>
					</li>
					<li>
						<!-- <span>排量</span> -->
						<select class="filter-drop" name="">
							<option  selected disabled style="display: none;">排量</option>
							<option >1.0以下</option>
							<option >1.0-1.6</option>
							<option >1.6-2.0</option>
							<option >2.0-2.5</option>
							<option >2.5-3.0</option>
							<option>3.0-4.0</option>
							<option>4.0以上</option>
						</select>
					</li>
					<li>
						<!-- <span>里程</span> -->
						<select class="filter-drop" name="">
							<option  selected disabled style="display: none;">里程</option>
							<option >1万公里内</option>
							<option >1-3万公里</option>
							<option >3-5万公里</option>
							<option >5-8万公里</option>
							<option >8-12万公里</option>
							<option>12-18万公里</option>
							<option>18万公里以上</option>
						</select>
					</li>
					<li>
						<!-- <span>变速箱</span> -->
						<select class="filter-drop" name="">
							<option  selected disabled style="display: none;">变速箱</option>
							<option >1年以内</option>
							<option >1-3年</option>
							<option >3-5年</option>
							<option >5-8年</option>
							<option >8-10年</option>
							<option>10年以上</option>
						</select>
					</li>
					<li>
						<!-- <span>颜色</span> -->
						<select class="filter-drop" name="">
							<option selected disabled style="display: none;">颜色</option>
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
					</li>
				</ul>
				<ul class="garbage">
					<li>地区:</li>
					<li>
						<div id="district" >
							<select class="userProvince" name="userProvince"></select>
							<select class="ad-item userCity"  name="userCity"></select>
							<select class="ad-item userDistrict" name="userDistrict"></select>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</body>
	
</html>
