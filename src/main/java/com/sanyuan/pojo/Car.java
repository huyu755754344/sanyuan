package com.sanyuan.pojo;

import java.io.Serializable;

public class Car implements Serializable {
	private SanyuanUser user;
	private CarBrand brand;
	private CarSeries series;
	private CarConfig config;
	private String imgPath;
	
	
    public final String getImgPath() {
		return imgPath;
	}

	public final void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public SanyuanUser getUser() {
		return user;
	}

	public void setUser(SanyuanUser user) {
		this.user = user;
	}

	public CarBrand getBrand() {
		return brand;
	}

	public void setBrand(CarBrand brand) {
		this.brand = brand;
	}

	public final CarSeries getSeries() {
		return series;
	}

	public final void setSeries(CarSeries series) {
		this.series = series;
	}

	public CarConfig getConfig() {
		return config;
	}

	public void setConfig(CarConfig config) {
		this.config = config;
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private Integer carId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.user_num
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private Integer userNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.brand_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String brandId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.series_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String seriesId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.model_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String modelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_model
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carModel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.prot_price
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String protPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.now_price
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String nowPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_age
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carAge;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_shangpai
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carShangpai;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_color
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carColor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_km
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carKm;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_annual
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carAnnual;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_insurance
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carInsurance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_sali
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carSali;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_upkeep
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carUpkeep;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_contact
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carContact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_phone
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_province
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carProvince;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_city
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carCity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_district
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carDistrict;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_addr
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carAddr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_describe
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private String carDescribe;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.status
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table car
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_id
     *
     * @return the value of car.car_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_id
     *
     * @param carId the value for car.car_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.user_num
     *
     * @return the value of car.user_num
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public Integer getUserNum() {
        return userNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.user_num
     *
     * @param userNum the value for car.user_num
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.brand_id
     *
     * @return the value of car.brand_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.brand_id
     *
     * @param brandId the value for car.brand_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.series_id
     *
     * @return the value of car.series_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getSeriesId() {
        return seriesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.series_id
     *
     * @param seriesId the value for car.series_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId == null ? null : seriesId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.model_id
     *
     * @return the value of car.model_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.model_id
     *
     * @param modelId the value for car.model_id
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_model
     *
     * @return the value of car.car_model
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_model
     *
     * @param carModel the value for car.car_model
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarModel(String carModel) {
        this.carModel = carModel == null ? null : carModel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.prot_price
     *
     * @return the value of car.prot_price
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getProtPrice() {
        return protPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.prot_price
     *
     * @param protPrice the value for car.prot_price
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setProtPrice(String protPrice) {
        this.protPrice = protPrice == null ? null : protPrice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.now_price
     *
     * @return the value of car.now_price
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getNowPrice() {
        return nowPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.now_price
     *
     * @param nowPrice the value for car.now_price
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice == null ? null : nowPrice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_age
     *
     * @return the value of car.car_age
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarAge() {
        return carAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_age
     *
     * @param carAge the value for car.car_age
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarAge(String carAge) {
        this.carAge = carAge == null ? null : carAge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_shangpai
     *
     * @return the value of car.car_shangpai
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarShangpai() {
        return carShangpai;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_shangpai
     *
     * @param carShangpai the value for car.car_shangpai
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarShangpai(String carShangpai) {
        this.carShangpai = carShangpai == null ? null : carShangpai.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_color
     *
     * @return the value of car.car_color
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarColor() {
        return carColor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_color
     *
     * @param carColor the value for car.car_color
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarColor(String carColor) {
        this.carColor = carColor == null ? null : carColor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_km
     *
     * @return the value of car.car_km
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarKm() {
        return carKm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_km
     *
     * @param carKm the value for car.car_km
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarKm(String carKm) {
        this.carKm = carKm == null ? null : carKm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_annual
     *
     * @return the value of car.car_annual
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarAnnual() {
        return carAnnual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_annual
     *
     * @param carAnnual the value for car.car_annual
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarAnnual(String carAnnual) {
        this.carAnnual = carAnnual == null ? null : carAnnual.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_insurance
     *
     * @return the value of car.car_insurance
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarInsurance() {
        return carInsurance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_insurance
     *
     * @param carInsurance the value for car.car_insurance
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarInsurance(String carInsurance) {
        this.carInsurance = carInsurance == null ? null : carInsurance.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_sali
     *
     * @return the value of car.car_sali
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarSali() {
        return carSali;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_sali
     *
     * @param carSali the value for car.car_sali
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarSali(String carSali) {
        this.carSali = carSali == null ? null : carSali.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_upkeep
     *
     * @return the value of car.car_upkeep
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarUpkeep() {
        return carUpkeep;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_upkeep
     *
     * @param carUpkeep the value for car.car_upkeep
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarUpkeep(String carUpkeep) {
        this.carUpkeep = carUpkeep == null ? null : carUpkeep.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_contact
     *
     * @return the value of car.car_contact
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarContact() {
        return carContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_contact
     *
     * @param carContact the value for car.car_contact
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarContact(String carContact) {
        this.carContact = carContact == null ? null : carContact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_phone
     *
     * @return the value of car.car_phone
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarPhone() {
        return carPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_phone
     *
     * @param carPhone the value for car.car_phone
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarPhone(String carPhone) {
        this.carPhone = carPhone == null ? null : carPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_province
     *
     * @return the value of car.car_province
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarProvince() {
        return carProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_province
     *
     * @param carProvince the value for car.car_province
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarProvince(String carProvince) {
        this.carProvince = carProvince == null ? null : carProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_city
     *
     * @return the value of car.car_city
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarCity() {
        return carCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_city
     *
     * @param carCity the value for car.car_city
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarCity(String carCity) {
        this.carCity = carCity == null ? null : carCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_district
     *
     * @return the value of car.car_district
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarDistrict() {
        return carDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_district
     *
     * @param carDistrict the value for car.car_district
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarDistrict(String carDistrict) {
        this.carDistrict = carDistrict == null ? null : carDistrict.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_addr
     *
     * @return the value of car.car_addr
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarAddr() {
        return carAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_addr
     *
     * @param carAddr the value for car.car_addr
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarAddr(String carAddr) {
        this.carAddr = carAddr == null ? null : carAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_describe
     *
     * @return the value of car.car_describe
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public String getCarDescribe() {
        return carDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_describe
     *
     * @param carDescribe the value for car.car_describe
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setCarDescribe(String carDescribe) {
        this.carDescribe = carDescribe == null ? null : carDescribe.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.status
     *
     * @return the value of car.status
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.status
     *
     * @param status the value for car.status
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbg.generated Tue Nov 26 09:56:09 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carId=").append(carId);
        sb.append(", userNum=").append(userNum);
        sb.append(", brandId=").append(brandId);
        sb.append(", seriesId=").append(seriesId);
        sb.append(", modelId=").append(modelId);
        sb.append(", carModel=").append(carModel);
        sb.append(", protPrice=").append(protPrice);
        sb.append(", nowPrice=").append(nowPrice);
        sb.append(", carAge=").append(carAge);
        sb.append(", carShangpai=").append(carShangpai);
        sb.append(", carColor=").append(carColor);
        sb.append(", carKm=").append(carKm);
        sb.append(", carAnnual=").append(carAnnual);
        sb.append(", carInsurance=").append(carInsurance);
        sb.append(", carSali=").append(carSali);
        sb.append(", carUpkeep=").append(carUpkeep);
        sb.append(", carContact=").append(carContact);
        sb.append(", carPhone=").append(carPhone);
        sb.append(", carProvince=").append(carProvince);
        sb.append(", carCity=").append(carCity);
        sb.append(", carDistrict=").append(carDistrict);
        sb.append(", carAddr=").append(carAddr);
        sb.append(", carDescribe=").append(carDescribe);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}