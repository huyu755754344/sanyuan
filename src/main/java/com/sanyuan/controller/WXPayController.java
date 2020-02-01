package com.sanyuan.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPayUtil;
import com.sanyuan.mapper.SanyuanOrderMapper;
import com.sanyuan.pojo.SanyuanOrder;
import com.sanyuan.pojo.WXPayCallbackEntity;
import com.sanyuan.service.WXPayService;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.JsonUtils;
import com.sanyuan.utils.StringUtils;

@RestController
public class WXPayController {
	
	@Autowired
	private SanyuanOrderMapper orderMapper;
	
	
	@RequestMapping("/upOrder")
	public void upOrder(@RequestParam("orderId")Long orderId) {
		System.out.println("收到请求"+orderId);
		 orderMapper.updateByKey(orderId);
	}
	
	
	/**
	   * 微信支付成功回调接口
	   *
	   * @param map      返回给页面
	   * @param request  接收请求
	   * @param response 响应
	   * @return
	   * @throws Exception
	   */
	  @RequestMapping("/wxpay")
	  public void callback(Map<String, Object> map, HttpServletRequest request,
	                         HttpServletResponse response) throws Exception {
		  
	      //log.info("用户支付成功,回调！");
	      String inputLine;
	      String notityXml = "";
	      request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
	      response.setHeader("Access-Control-Allow-Origin", "*");
	      // 微信给返回的东西
	      try {
	          while ((inputLine = request.getReader().readLine()) != null) {
	              notityXml += inputLine;
	          }
	          request.getReader().close();
	      } catch (Exception e) {
	          e.printStackTrace();
	          //log.info("xml获取失败");
	          response.getWriter().write(setXml("FAIL", "xml获取失败"));
	      }
	      if (StringUtils.isEmpty(notityXml)) {
	        //  log.info("xml为空");
	    	  response.getWriter().write(setXml("FAIL", "xml为空"));
	      }
	     
	      WXPayService wxService = WXPayService.getInstance(GlobalConst.CERTPATH, GlobalConst.NOTIFYURL);
	      if (!wxService.checkSign(notityXml)) {
	          response.getWriter().write(setXml("FAIL", "验签失败"));
	      }
	   //   log.info("xml的值为：" + notityXml);
	      Map<String, String> xmlMap = WXPayUtil.xmlToMap(notityXml); // 解析成map
	      String json = JSON.toJSONString(xmlMap); // map 转成json
	     // log.info(json);
	      
	      WXPayCallbackEntity returnPay = JsonUtils.jsonToPojo(json, WXPayCallbackEntity.class);
	     // log.info(("转换后对象为：" + returnPay.toString()));
	     // log.info(("订单号：" + returnPay.getOut_trade_no() + "总金额：" + returnPay.getTotal_fee()));
	      if (returnPay.getReturn_code().equals("SUCCESS") && returnPay.getOut_trade_no() != null
	              && !returnPay.getOut_trade_no().isEmpty()) {
	          double fee = Double.parseDouble(returnPay.getTotal_fee());
	          returnPay.setTotal_fee(String.valueOf(fee / 100));
	          //log.info("微信的支付状态为SUCCESS");
	          // 支付成功业务
	          synchronized (WXPayController.class) { // 加入同步锁
	              Thread.sleep(1000); //睡一秒,防止并发倒致数据不一致
	              //订单编号
	              Long orderId = Long.parseLong(returnPay.getOut_trade_no());
	              //完成交易
	              //更新订单情况
	              System.out.println("更新订单+"+orderId);
	             orderMapper.updateByKey(orderId);
	              
	             //判断订单是否是 vip订单
	             //略
	             //   addServiceCount(returnPay,response); // 写你支付成功后的业务, 比如给用户充值服务次数
	          }
	          // 返回false的原因有可能是：订单已完成支付,或者订单已退款
	      }else
	          response.getWriter().write(setXml("FAIL","ORDER IS FINISH"));
	      }
	  
	  
	  	/**
	  	 * 查询对方时候购买
	  	 * @param code
	  	 * @param msg
	  	 * @return
	  	 */
	  
	   
	  
	  	public  String setXml(String code,String msg) {
			StringBuffer b = new StringBuffer();
			b.append("<xml><return_code><![CDATA[");
			b.append(code);
			b.append("]]></return_code><return_msg><![CDATA[");
			b.append(msg);
			b.append("]]></return_msg></xml>");
			return null;
		}
}
