package com.sanyuan.service;

import java.util.List;

import com.sanyuan.pojo.Car;
import com.sanyuan.pojo.CarBrand;
import com.sanyuan.pojo.CarConfig;
import com.sanyuan.pojo.CarModel;
import com.sanyuan.pojo.CarPicture;
import com.sanyuan.pojo.CarSeries;
import com.sanyuan.pojo.HeaderName;

public interface CarService {

	public List<CarBrand> checkBrand(String brandShouzimu);
	
	public List<CarSeries> selectByBrandId(String brandId);
	
	public List<CarModel> checkModel(String brandId,String seriesId);
	
	public CarConfig checkConfig(String brandId,String seriesId,String modelId);
	
	public List<HeaderName> checkName();
	
	public int insertCar(Car car);
	
	public int insertPicture(CarPicture picture);
	
	public Car checkCar(int carId);
	
	public List<CarPicture> selectByCarId(int carId);
	
	public List<Car> checkCar(String carModel,String brandId,String seriesId,String price,String carAge,String carKm,
			String color,String carProvince,String carCity,String carDistrict);
	
	public List<Car> checkCar();
	
	public List<Car> selectByUserNum(int userNum);
	
	public int update(Car car);
	
	public int delCar(int carId);
	
	public String findPhoneByCarId(Integer carId);
}
