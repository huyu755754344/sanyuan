package com.sanyuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sanyuan.pojo.Car;
import com.sanyuan.pojo.CarPicture;
import com.sanyuan.service.CarService;

@RestController
public class DetailController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/detail")
	public ModelAndView detail(int carId) {
		ModelAndView view = new ModelAndView("detail");
		Car car = carService.checkCar(carId);
		view.addObject("car", car);
		List<CarPicture> pictureList = carService.selectByCarId(carId);
		view.addObject("pictureList", pictureList);
		return view;
	}
	
}
