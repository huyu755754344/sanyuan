package com.sanyuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanyuan.pojo.Car;
import com.sanyuan.service.CarService;

@RestController
public class IndexController {

	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");
		List<Car> carList = carService.checkCar();
		view.addObject("carList", carList);
		view.addObject("type",1);
		return view;
	}
	 public static void main(String[] args) {
		System.out.println(3/45);
	}
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(defaultValue = "")String carModel,@RequestParam(defaultValue = "")String brandId,
			@RequestParam(defaultValue = "")String brandName,@RequestParam(defaultValue = "")String seriesId,
			@RequestParam(defaultValue = "")String price,@RequestParam(defaultValue = "")String carAge,
			@RequestParam(defaultValue = "")String carKm,@RequestParam(defaultValue = "")String color,
			@RequestParam(defaultValue = "")String carProvince,@RequestParam(defaultValue = "")String carCity,
			@RequestParam(defaultValue = "")String carDistrict,@RequestParam(defaultValue = "3")String identity,
			@RequestParam(defaultValue = "0")Integer pageNum) {
		ModelAndView view = new ModelAndView("search");
		
		List<Car> carList = carService.checkCar(carModel, brandId, seriesId, price, carAge, carKm, color, carProvince, carCity, carDistrict);
		int size= carList.size();
		PageHelper.startPage(pageNum, 45);
		//总页数
		int total =size/45;
		view.addObject("carList", new PageInfo<Car>(carList));
		view.addObject("carModel", carModel);
		view.addObject("brandId", brandId);
		view.addObject("brandName", brandName);
		view.addObject("seriesId", seriesId);
		view.addObject("price", price);
		view.addObject("carAge", carAge);
		view.addObject("carKm", carKm);
		view.addObject("color", color);
		view.addObject("carProvince", carProvince);
		view.addObject("carCity", carCity);
		view.addObject("carDistrict", carDistrict);
		view.addObject("identity", identity);
		view.addObject("type", 2);
		view.addObject("pageNum", pageNum);
		view.addObject("total", total);
		return view;
	}
	
}
