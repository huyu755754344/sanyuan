package com.sanyuan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sanyuan.mapper.SanyuanUserMapper;
import com.sanyuan.pojo.Car;
import com.sanyuan.pojo.SanyuanUser;
import com.sanyuan.pojo.YiyuanUser;
import com.sanyuan.service.CarService;
import com.sanyuan.utils.CookieUtils;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.JsonUtils;
import com.sanyuan.utils.RedisUtils;

@RestController
public class MyCarController {

	@Autowired
	private CarService carService;
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private SanyuanUserMapper userMapper;
	
	@RequestMapping("/myCar")
	public ModelAndView myCar(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		SanyuanUser user = getUser(request);
	
		if(user!=null) {
			System.out.println("1111111111111111111");
			List<Car> carList = carService.selectByUserNum(user.getUserNum());
			view.addObject("carList", carList);
			view.setViewName("pub");
		}else {
			System.out.println("2222222222222222222");
			view.addObject("result", false);
			view.setViewName("redirect:/sellCar");
		}
		return view;
	}
	
	@RequestMapping("/updateCar")
	public ModelAndView updateCar(int carId) {
		ModelAndView view = new ModelAndView();
		Car car = carService.checkCar(carId);
		view.addObject("car", car);
		view.setViewName("change");
		return view;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(Car car,HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		SanyuanUser user = getUser(request);
		if(user!=null) 
		carService.update(car);
		view.setViewName("redirect:/updateCar?carId="+car.getCarId());
		return view;
	}
	
	@RequestMapping("/delCar")
	public ModelAndView delCar(int carId,HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		SanyuanUser user = getUser(request);
		if(user!=null) 
			carService.delCar(carId);
		view.setViewName("redirect:/myCar");
		return view;
	}
	
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
