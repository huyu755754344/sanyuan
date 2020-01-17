package com.sanyuan.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.wxpay.sdk.WXPay;
import com.sanyuan.config.WXPayConfigImpl;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.MD5Encrypt;


public class WXPayService {
	private static Logger logger = LoggerFactory.getLogger(WXPayService.class);
    private WXPay wxpay;
    private WXPayConfigImpl config;
    private static WXPayService wxPayService;
    private WXPayService(String certPath, String notifyUrl) throws Exception {
        config = WXPayConfigImpl.getInstance(certPath,notifyUrl);
        wxpay = new WXPay(config);
    }
    public static WXPayService getInstance(String certPath,String notifyUrl) throws Exception {
        if (wxPayService == null) {
            synchronized (WXPayConfigImpl.class) {
                if (wxPayService == null) {
                    wxPayService = new WXPayService(certPath,notifyUrl);
                }
            }
        }
        return wxPayService;
    }
   
    /**
     * 微信下单接口
     *
     * @param out_trade_no 订单号
     * @param body         商家商品名
     * @param money        总金额
     * @param applyNo      商品编号
     * @return
     */
    public String doUnifiedOrder(String out_trade_no, String body, Double money, String applyNo) {
    	
        String amt = String.valueOf(money * 100);
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", body);
        data.put("out_trade_no", out_trade_no);
        data.put("device_info", "web");
        data.put("fee_type", "CNY");
        data.put("total_fee", amt.substring(0, amt.lastIndexOf(".")));
       //data.put("spbill_create_ip", config.getSpbillCreateIp());
        data.put("notify_url", config.getNotifyUrl());
        data.put("trade_type", config.getTradeType());
        data.put("product_id", applyNo);
        System.out.println(String.valueOf(money * 100));
        // data.put("time_expire", "20170112104120");
        try {
            Map<String, String> r = wxpay.unifiedOrder(data);
           //System.out.println("返回的参数是" + r);
           // System.out.println("aaaaaaaaaaa"+r);
            String url = r.get("code_url");
            System.out.println(url);
           return url;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return null;
        }
    }
    
    public String doUnifiedOrder(String out_trade_no, String body, Double money, String applyNo,String attach) {
        String amt = String.valueOf(money * 100);
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", body);
        data.put("out_trade_no", out_trade_no);
        data.put("device_info", "web");
        data.put("fee_type", "CNY");
        data.put("total_fee", amt.substring(0, amt.lastIndexOf(".")));
       //data.put("spbill_create_ip", config.getSpbillCreateIp());
        data.put("notify_url", config.getNotifyUrl());
        data.put("trade_type", config.getTradeType());
        data.put("product_id", applyNo);
        data.put("attach",attach);
        System.out.println(String.valueOf(money * 100));
        // data.put("time_expire", "20170112104120");
        try {
            Map<String, String> r = wxpay.unifiedOrder(data);
           System.out.println("返回的参数是" + r);
            System.out.println("orderasdqwe"+r.get("code_url"));
            return r.get("code_url");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return null;
        }
    }
    
 

    
    /**
     * 退款
     */
    public void doRefund(String out_trade_no, String total_fee) {
        logger.info("退款时的订单号为：" + out_trade_no + "退款时的金额为:" + total_fee);
        String amt = String.valueOf(Double.parseDouble(total_fee) * 100);
        logger.info("修正后的金额为：" + amt);
        logger.info("最终的金额为：" + amt.substring(0, amt.lastIndexOf(".")));
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", out_trade_no);
        data.put("out_refund_no", out_trade_no);
        data.put("total_fee", amt.substring(0, amt.lastIndexOf(".")));
        data.put("refund_fee", amt.substring(0, amt.lastIndexOf(".")));
        data.put("refund_fee_type", "CNY");
        data.put("op_user_id", config.getMchID());
        try {
            Map<String, String> r = wxpay.refund(data);
            logger.info("退款操作返回的参数为" + r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 微信验签接口
     *
     * @return
     * @throws DocumentException
     */
    public boolean checkSign(String  strXML) throws DocumentException {
        SortedMap<String, String> smap = new TreeMap<String, String>();
        Document doc = DocumentHelper.parseText(strXML);
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            smap.put(e.getName(), e.getText());
        }
        return isWechatSign(smap,config.getKey());
    }
    private boolean isWechatSign(SortedMap<String, String> smap,String apiKey) {
        StringBuffer sb = new StringBuffer();
        Set<Entry<String, String>> es = smap.entrySet();
        Iterator<Entry<String, String>> it = es.iterator();
        while (it.hasNext()) {
            Entry<String, String> entry =  it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"sign".equals(k) && null != v && !"".equals(v) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + apiKey);
        /** 验证的签名 */
        //String sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
        String sign = MD5Encrypt.MD5Encode(sb.toString()).toUpperCase();
         /** 微信端返回的合法签名 */
        String validSign = ((String) smap.get("sign")).toUpperCase();
        return validSign.equals(sign);
    }
}

