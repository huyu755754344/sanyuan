package com.sanyuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanyuan.mapper.CarBrandMapper;
import com.sanyuan.mapper.CarConfigMapper;
import com.sanyuan.mapper.CarMapper;
import com.sanyuan.mapper.CarPictureMapper;
import com.sanyuan.mapper.CarSeriesMapper;
import com.sanyuan.mapper.HeaderNameMapper;
import com.sanyuan.mapper.ModelMapper;
import com.sanyuan.mapper.SanyuanUserMapper;
import com.sanyuan.pojo.Car;
import com.sanyuan.pojo.CarBrand;
import com.sanyuan.pojo.CarBrandExample;
import com.sanyuan.pojo.CarConfig;
import com.sanyuan.pojo.CarConfigExample;
import com.sanyuan.pojo.CarExample;
import com.sanyuan.pojo.CarExample.Criteria;
import com.sanyuan.pojo.CarModel;
import com.sanyuan.pojo.CarPicture;
import com.sanyuan.pojo.CarPictureExample;
import com.sanyuan.pojo.CarSeries;
import com.sanyuan.pojo.CarSeriesExample;
import com.sanyuan.pojo.HeaderName;
import com.sanyuan.pojo.SanyuanUser;
import com.sanyuan.pojo.SanyuanUserExample;
import com.sanyuan.service.CarService;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarBrandMapper brandMapper;
	@Autowired
	private CarSeriesMapper seriesMapper;
	@Autowired
	private CarConfigMapper configMapper;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private HeaderNameMapper nameMapper;
	@Autowired
	private CarMapper carMapper;
	@Autowired
	private CarPictureMapper pictureMapper;
	@Autowired
	private SanyuanUserMapper userMapper;
	
	@Override
	public List<CarBrand> checkBrand(String brandShouzimu) {
		CarBrandExample example = new CarBrandExample();
		if(!"".equals(brandShouzimu)) {
			example.or().andBrandShouzimuEqualTo(brandShouzimu);
		}
		return brandMapper.selectByExample(example);
	}

	@Override
	public List<CarSeries> selectByBrandId(String brandId) {
		CarSeriesExample example = new CarSeriesExample();
		example.or().andBrandPinpaiIdEqualTo(brandId);
		return seriesMapper.selectByExample(example);
	}

	@Override
	public List<CarModel> checkModel(String brandId, String seriesId) {
		
		return modelMapper.checkModel(brandId, seriesId);
	}

	@Override
	public CarConfig checkConfig(String brandId, String seriesId, String modelId) {
		CarConfigExample example = new CarConfigExample();
		example.or().andBrandPinpaiIdEqualTo(brandId).andSeriesChexiIdEqualTo(seriesId).andConfigChexingIdEqualTo(modelId);
		List<CarConfig> list = configMapper.selectByExample(example);
		if(list.size()>0&&list!=null)
			return list.get(0);
		return null;
	}

	@Override
	public List<HeaderName> checkName() {
		
		return nameMapper.selectByExample(null);
	}

	@Override
	public int insertCar(Car car) {
		
		return carMapper.insertSelective(car);
	}

	@Override
	public int insertPicture(CarPicture picture) {
		return pictureMapper.insertSelective(picture);
	}

	@Override
	public Car checkCar(int carId) {
		Car car = carMapper.selectByPrimaryKey(carId);
		if(car!=null) {
			car = getCarDetail(car);
		}
		return car;
	}

	@Override
	public List<CarPicture> selectByCarId(int carId) {
		CarPictureExample example = new CarPictureExample();
		example.or().andCarIdEqualTo(carId).andStatusEqualTo(1);
		return pictureMapper.selectByExample(example);
	}
	
	@Override
	public List<Car> checkCar() {
		List<Car> carList = new ArrayList<>();
		CarExample example = new CarExample();
		example.setOrderByClause("rand() limit 15");
		example.or().andStatusEqualTo(1);
		List<Car> list = carMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			for (Car car : list) {
				 //carList.add(getCarDetail(car));
				CarBrandExample brandExample = new CarBrandExample();
				brandExample.or().andBrandPinpaiIdEqualTo(car.getBrandId());
				List<CarBrand> brandList = brandMapper.selectByExample(brandExample);
				if(brandList.size()>0&&brandList!=null) 
					car.setBrand(brandList.get(0));
				CarPictureExample pictureExample = new CarPictureExample();
				pictureExample.or().andCarIdEqualTo(car.getCarId()).andStatusEqualTo(1);
				List<CarPicture> pictures = pictureMapper.selectByExample(pictureExample);
				if(pictures.size()>0&&pictures!=null)
					car.setImgPath(pictures.get(0).getPicture());
				carList.add(car);
			}
		}
		return carList;
	}
	@Override
	public List<Car> checkCar(String carModel,String brandId,String seriesId,String price,String carAge,String carKm,
			String color,String carProvince,String carCity,String carDistrict) {
		List<Car> carList = new ArrayList<>();
		CarExample example = new CarExample();
		Criteria criteria = example.or().andStatusEqualTo(1);
		if(!"".equals(carModel))
			criteria.andCarModelEqualTo(carModel);
		if(!"".equals(brandId))
			criteria.andBrandIdEqualTo(brandId);
		if(!"".equals(seriesId))
			criteria.andSeriesIdEqualTo(seriesId);
		if(!"".equals(price)) {
			String[] split = price.split(",");
			criteria.andNowPriceBetween(split[0], split[1]);
		}
		if(!"".equals(carAge)) {
			String[] split = carAge.split(",");
			criteria.andCarAgeBetween(split[0], split[1]);
		}
		if(!"".equals(carKm)) {
			String[] split = carKm.split(",");
			criteria.andCarKmBetween(split[0], split[1]);
		}
		if(!"".equals(color))
			criteria.andCarColorEqualTo(color);
		if(!"".equals(carProvince))
			criteria.andCarProvinceEqualTo(carProvince);
		if(!"".equals(carCity))
			criteria.andCarCityEqualTo(carCity);
		if(!"".equals(carDistrict))
			criteria.andCarDescribeEqualTo(carDistrict);
		List<Car> list = carMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			for (Car car : list) {
				Car carDB = getCarDetail(car);
				CarPictureExample pictureExample = new CarPictureExample();
				pictureExample.or().andCarIdEqualTo(car.getCarId()).andStatusEqualTo(1);
				List<CarPicture> pictures = pictureMapper.selectByExample(pictureExample);
				if(pictures.size()>0&&pictures!=null)
					carDB.setImgPath(pictures.get(0).getPicture());
				carList.add(carDB);
			}
		}
		return carList;
	}

	@Override
	public List<Car> selectByUserNum(int userNum) {
		List<Car> carList = new ArrayList<>();
		CarExample example = new CarExample();
		example.or().andStatusEqualTo(1).andUserNumEqualTo(userNum);
		List<Car> list = carMapper.selectByExample(example);
		if(list.size()>0&&list!=null) {
			for (Car car : list) {
				carList.add(getCarDetail(car));
			}
		}
		return carList;
	}
	
	
	private Car getCarDetail(Car car) {
		SanyuanUserExample userExample = new SanyuanUserExample();
		userExample.or().andUserNumEqualTo(car.getUserNum()).andStatusEqualTo(1);
		List<SanyuanUser> userList = userMapper.selectByExample(userExample);
		if(userList.size()>0&&userList!=null) {
			SanyuanUser user = userList.get(0);
			user.setUserId(null);
			car.setUser(user);
		}
		CarBrandExample brandExample = new CarBrandExample();
		brandExample.or().andBrandPinpaiIdEqualTo(car.getBrandId());
		List<CarBrand> brandList = brandMapper.selectByExample(brandExample);
		if(brandList.size()>0&&brandList!=null) 
			car.setBrand(brandList.get(0));
		CarSeriesExample seriesExample = new CarSeriesExample();
		seriesExample.or().andBrandPinpaiIdEqualTo(car.getBrandId()).andSeriesChexiIdEqualTo(car.getSeriesId());
		List<CarSeries> seriesList = seriesMapper.selectByExample(seriesExample);
		if(seriesList.size()>0&&seriesList!=null) 
			car.setSeries(seriesList.get(0));
		if(!"".equals(car.getModelId())&&car.getModelId()!=null) {
			CarConfigExample configExample = new CarConfigExample();
			configExample.or().andBrandPinpaiIdEqualTo(car.getBrandId()).andSeriesChexiIdEqualTo(car.getSeriesId())
			.andConfigChexingIdEqualTo(car.getModelId());
			List<CarConfig> configList = configMapper.selectByExample(configExample);
			if(configList.size()>0&&configList!=null)
				car.setConfig(configList.get(0));
		}
		return car;
	}

	@Override
	public int update(Car car) {
		
		return carMapper.updateByPrimaryKeySelective(car);
	}

	@Override
	public int delCar(int carId) {
		
		return carMapper.deleteByPrimaryKey(carId);
	}

	@Override
	public String findPhoneByCarId(Integer carId) {
		
		
		return carMapper.selectPhoneByCarId(carId);
	}
}
