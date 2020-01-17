package com.sanyuan.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.github.wxpay.sdk.WXPayConfig;

public class WXPayConfigImpl implements WXPayConfig{
	private byte[] certData;
	private String certPath;
	private String notifyUrl;
	
	public WXPayConfigImpl() throws Exception {
        certPath = "C:\\Users\\Administrator\\Desktop\\pay\\apiclient_cert.p12";
        File file = new File(certPath);
        this.notifyUrl="https://www.hunlian.art/wxpay";
        InputStream certStream = new FileInputStream(file);
        certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }
	private WXPayConfigImpl(String certPath,String notifyUrl) throws Exception {
		this.certPath = certPath;
        File file = new File(certPath);
        this.notifyUrl=notifyUrl;
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
	}
	

	@Override
	public String getAppID() {
		// TODO Auto-generated method stub
		return "wx6a792a15dbcdec4d";
	}

	@Override
	public String getMchID() {
		// TODO Auto-generated method stub
		return "1574241891";
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "0b839427735816be26a2588fa8e8f439";
	}

	@Override
	public InputStream getCertStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHttpConnectTimeoutMs() {
		// TODO Auto-generated method stub
		return 8000;
	}

	@Override
	public int getHttpReadTimeoutMs() {
		// TODO Auto-generated method stub
		return 10000;
	}
	/**
	 * 传入request获取用户ip
	 *
	 * @param request
	 * @return
	 */
	public String getSpbillCreateIp(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getRemoteAddr();
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public String getTradeType() {
		// TODO Auto-generated method stub
		return "NATIVE";
	}



	public static WXPayConfigImpl getInstance(String certPath, String notifyUrl) throws Exception {
		
		return new WXPayConfigImpl(certPath,notifyUrl);
	}

}
