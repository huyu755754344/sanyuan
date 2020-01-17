package com.sanyuan.utils;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 用来发送短信的工具类
 */
public class SendCodeUtils {
    // 配置个人阿里云的AK，保密信息
    private static String accessKeyId = "LTAI4FwUcjpLThiWkSdMiQDP";
    private static String accessKeySecret = "IlLj0P6v8AfCXkN7DenEeS60Wi7rC1";
    //发送验证码短信的配置信息
    private static String signName = "婚恋商城";
    private static String templateCode = "SMS_176375468";
    private static String forgetTemplateCode = "SMS_176385040";
    private static String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
	private static String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

    /**
     * 执行发送短信的工具类，可以发送指定手机号，签名、模板代码的、模板变量的信息,私有化，被类里面其他更具体的方法调用，例如发送验证码的方法
     * @param phoneNumber 手机号
     * @param signName    短信签名，提前在阿里云申请
     * @param templateCode 模板代码，提前在阿里云申请
     * @param templateParam 模板变量，和具体的模板有关，用来代替模板里面的变量值
     * @return
     */
    public static  SendSmsResponse sendSms(String phoneNumber, String templateParam) {
    	System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
    	System.setProperty("sun.net.client.defaultReadTimeout", "10000");
    	//初始化ascClient,暂时不支持多region
    	IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
    	try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e) {
			e.printStackTrace();
		}
    	IAcsClient acsClient = new DefaultAcsClient(profile);
    	 //组装请求对象
    	 SendSmsRequest request = new SendSmsRequest();
    	 //使用post提交
    	 request.setMethod(MethodType.POST);
    	 //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
    	 request.setPhoneNumbers(phoneNumber);
    	 //必填:短信签名-可在短信控制台中找到
    	 request.setSignName(signName);
    	 //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
    	 request.setTemplateCode(templateCode);
    	 //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
    	 //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
    	 request.setTemplateParam("{\"code\":\"" + templateParam + "\"}");
    	 //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
    	 //request.setSmsUpExtendCode("90997");
    	 //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
    	 request.setOutId("yourOutId");
    	//请求失败这里会抛ClientException异常
    	SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}

        return sendSmsResponse;
    }
    
    public static  SendSmsResponse forgetSendCode(String phoneNumber, String templateParam) {
    	System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
    	System.setProperty("sun.net.client.defaultReadTimeout", "10000");
    	//初始化ascClient,暂时不支持多region
    	IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
    	try {
    		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
    	} catch (ClientException e) {
    		e.printStackTrace();
    	}
    	IAcsClient acsClient = new DefaultAcsClient(profile);
    	//组装请求对象
    	SendSmsRequest request = new SendSmsRequest();
    	//使用post提交
    	request.setMethod(MethodType.POST);
    	//必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
    	request.setPhoneNumbers(phoneNumber);
    	//必填:短信签名-可在短信控制台中找到
    	request.setSignName(signName);
    	//必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
    	request.setTemplateCode(forgetTemplateCode);
    	//可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
    	//友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
    	request.setTemplateParam("{\"code\":\"" + templateParam + "\"}");
    	//可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
    	//request.setSmsUpExtendCode("90997");
    	//可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
    	request.setOutId("yourOutId");
    	//请求失败这里会抛ClientException异常
    	SendSmsResponse sendSmsResponse = null;
    	try {
    		sendSmsResponse = acsClient.getAcsResponse(request);
    	} catch (ServerException e) {
    		e.printStackTrace();
    	} catch (ClientException e) {
    		e.printStackTrace();
    	}
    	
    	return sendSmsResponse;
    }

}

