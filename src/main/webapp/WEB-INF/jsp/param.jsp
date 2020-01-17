<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>参数</title>
		<link rel="stylesheet" type="text/css" href="/css/param.css"/>
	</head>
	<body>
		<jsp:include page="commons/head.jsp"></jsp:include>
		<div class="banner"></div>
		<div class="parameter-contain">
			<div class="parameter-cont">
				<div class="parameter-box">
					<div class="parameter-tit"></div>
					<div class="parameter-topimg"></div>
					<div class="parameter-detail">
						<!-- <div class="car-allname">
							奥迪A6L
						</div> -->
						<div class="car-p-tit">
							车辆基本信息及参数
						</div>
						<div class="car-paramters">
							<div id="tab-parameter">
								<div class="th">车型信息</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('车型信息')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">基本参数</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('基本参数')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">车身参数</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('车身')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">发动机参数</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('发动机')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">电动机参数</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('电动机')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">变速箱参数</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('变速箱')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">底盘转向</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('底盘转向')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">车轮制动</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('车轮制动')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">主/被动安全装备</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('主/被动安全装备')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">辅助/操控配置</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('辅助/操控配置')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">外部/防盗配置</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('外部/防盗配置')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">内部配置</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('内部配置')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">座椅配置</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('座椅配置')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">多媒体配置</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('多媒体配置')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">灯光配置</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('灯光配置')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">玻璃/后视镜</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('玻璃/后视镜')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">空调冰箱</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('空调/冰箱')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="th">选装包</div>
								<div class="conten-list">
									<c:forEach items="${configMap}" var="configMap">
										<c:set var="config" value="${configMap.key }"></c:set>
										<c:set var="val" value="${configMap.value }"></c:set>
										<c:if test="${config.paramType.equals('选装包')}">
											<div>${config.cnName }</div>
											<div>${val }</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="commons/mall.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
