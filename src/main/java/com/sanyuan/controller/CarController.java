package com.sanyuan.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sanyuan.mapper.SanyuanUserMapper;
import com.sanyuan.pojo.Car;
import com.sanyuan.pojo.CarBrand;
import com.sanyuan.pojo.CarConfig;
import com.sanyuan.pojo.CarModel;
import com.sanyuan.pojo.CarPicture;
import com.sanyuan.pojo.CarSeries;
import com.sanyuan.pojo.HeaderName;
import com.sanyuan.pojo.Result;
import com.sanyuan.pojo.SanyuanUser;
import com.sanyuan.pojo.YiyuanUser;
import com.sanyuan.service.CarService;
import com.sanyuan.utils.CookieUtils;
import com.sanyuan.utils.CreateIdUtils;
import com.sanyuan.utils.FileUtils;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.JsonUtils;
import com.sanyuan.utils.RedisUtils;

@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private SanyuanUserMapper userMapper;
	
	@RequestMapping("/sellCar")
	public ModelAndView sellCar(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView view = new ModelAndView("fallin");
		view.addObject("type", 3);
		return view;
	}
	
	
	  @RequestMapping("/getBrand") 
	  public Result getBrand(@RequestParam(defaultValue = "")String brandShouzimu) {
		  List<CarBrand> brandList = carService.checkBrand(brandShouzimu); 
		  return Result.ok(brandList);
	  }
	
	@RequestMapping("/getSeries") 
	public Result getSeries(String brandId) {
		
		List<CarSeries> seriesList = carService.selectByBrandId(brandId); 
		return Result.ok(seriesList);
	}
	
	@RequestMapping("/getModel") 
	public Result getModel(String brandId,String seriesId) { 
		List<CarModel> modelList = carService.checkModel(brandId,seriesId);
		return Result.ok(modelList); 
	}
	
	@RequestMapping("/getParam")
	public ModelAndView getParam(String brandId,String seriesId,String modelId) {
		ModelAndView view = new ModelAndView("param");
		CarConfig config = carService.checkConfig(brandId, seriesId, modelId);
		if(config!=null) {
			Map<String, Object> map = objectToMap(config);
			List<HeaderName> nameList = carService.checkName();
			Map<HeaderName, Object> configMap = new LinkedHashMap<HeaderName, Object>();
			for (HeaderName name : nameList) {
				//System.out.println("key:"+name);
				//System.out.println("value:"+map.get(name.getEnName()));
				configMap.put(name, map.get(name.getEnName()));
			}
			view.addObject("configMap", configMap);
			view.addObject("nameList", nameList);
		}
		return view;
	}
	public static Map<String, Object> objectToMap(Object obj)  {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Class<?> clazz = obj.getClass();
			//System.out.println(clazz);
			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				String fieldName = field.getName();
				Object value = field.get(obj);
				//System.out.println("fieldName:"+fieldName);
				//System.out.println("value:"+value);
				map.put(fieldName,value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return map;
	}
	
	/*@RequestMapping("/getCanShu")
	public void getCanShu(String brandId,String seriesId,String modelId,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		CarConfig config = carService.checkConfig(brandId, seriesId, modelId);
		Map<HeaderName, Object> configMap = new LinkedHashMap<HeaderName, Object>();
		if(config!=null) {
			Map<String, Object> map = objectToMap(config);
			List<HeaderName> nameList = carService.checkName();
			for (HeaderName name : nameList) {
				configMap.put(name, map.get(name.getEnName()));
			}
		}
		PrintWriter writer = response.getWriter();
		writer.print("callbackSuccess"+"('"+JsonUtils.objectToJson(configMap)+"')");
	}*/
	@Transactional
	@RequestMapping("/car")
	public ModelAndView car(Car car,HttpServletRequest request,HttpServletResponse response,MultipartFile[] picture) {
		ModelAndView view = new ModelAndView("redirect:/sellCar");
		int carId = CreateIdUtils.createId();
		CarPicture pricture = new CarPicture();
		pricture.setCarId(carId);
		pricture.setStatus(1);
		if(picture.length>0) {
			for (int i = 0; i < picture.length; i++) {
				if(picture[i].getOriginalFilename()!=null&&!"".equals(picture[i].getOriginalFilename())) {
					String fileName = FileUtils.addFile(picture[i], "/img/pricture");
					pricture.setPicture(FileUtils.URL+"/img/pricture/"+fileName);
					carService.insertPicture(pricture);
				}
			}
		}
		CookieUtils.setCookie(request, response, GlobalConst.CARID,String.valueOf(carId));
		SanyuanUser user = getUser(request);
		if(user!=null) {
			car.setCarId(carId);
			car.setStatus(1);
			car.setUserNum(user.getUserNum());
			carService.insertCar(car);
		}else {
			view.addObject("result", false);
		}
		return view;
	}
	
//	@RequestMapping("/addPicture")
//	public ModelAndView addPicture(HttpServletRequest request,MultipartFile[] picture) {
//		ModelAndView view = new ModelAndView("redirect:/sellCar");
//		int carId = Integer.parseInt(CookieUtils.getCookieValue(request, GlobalConst.CARID));
//		SanyuanUser user = getUser(request);
//		CarPicture pricture = new CarPicture();
//		pricture.setCarId(carId);
//		pricture.setStatus(1);
//		if(user!=null) {
//			if(picture.length>0) {
//				for (int i = 0; i < picture.length; i++) {
//					if(picture[i].getOriginalFilename()!=null&&!"".equals(picture[i].getOriginalFilename())) {
//						String fileName = FileUtils.addFile(picture[i], "/img/pricture");
//						pricture.setPicture(FileUtils.URL+"/img/pricture/"+fileName);
//						carService.insertPicture(pricture);
//					}
//				}
//			}
//		}else {
//			view.addObject("result", false);
//		}
//		return view;
//	}
	
	
	private SanyuanUser getUser(HttpServletRequest request) {
		String ticket = CookieUtils.getCookieValue(request, GlobalConst.YY_COOKIE_NAME);
		if(ticket!=null&&!"".equals(ticket)&&!" ".equals(ticket)) {
			String result = redisUtils.get(ticket);
			if(result!=null&&!"".equals(result)&&!" ".equals(result)) {
				YiyuanUser yuser = JsonUtils.jsonToPojo(result,YiyuanUser.class);
				Long userId=yuser.getUserId();
				SanyuanUser user = userMapper.selectByPrimaryKey(userId);
				return user;
			}
			return null;
		}
		return null;
	}
}
