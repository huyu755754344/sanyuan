package com.sanyuan.mapper;

import java.util.List;

import com.sanyuan.pojo.CarModel;

public interface ModelMapper {
	List<CarModel> checkModel(String brandId, String seriesId);
}
