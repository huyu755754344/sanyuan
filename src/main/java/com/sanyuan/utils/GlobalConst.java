package com.sanyuan.utils;

import java.util.HashMap;
import java.util.Map;



public class GlobalConst {
	public static String SY_COOKIE_NAME = "sy_lg";
	public static String YY_COOKIE_NAME = "yy_lg";
	public static String CARID = "carId";
	public static String MD5_PASSWORD="yiyuan";
	
	public static Map<String,Entity> COMMODITY= new HashMap<String,Entity>();
	static {
		//添加商品
		COMMODITY.put("phone",new Entity("查看电话号码", 3.0, 1));
	}
	
	/**
	 * 商品实体类
	 * 
	 */
	
	public static class Entity{
		public static String name;
		public static Double pay;
		public static Integer id;
		public static String msg;
		
		public Entity(String name,Double pay,Integer id){
			this.name=name;
			this.pay=pay;
			this.id=id;
		}
		public Entity(String name,Double pay,Integer id,String msg){
			this.name=name;
			this.pay=pay;
			this.id=id;
			this.msg=msg;
		}
		
		
	}
}
