package com.sanyuan.pojo;

import java.io.Serializable;

public class CarBrand implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_brand.id
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_brand.brand_shouzimu
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    private String brandShouzimu;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_brand.brand_pinpai
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    private String brandPinpai;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_brand.brand_pinpai_id
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    private String brandPinpaiId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_brand.brand_pinpai_logo
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    private String brandPinpaiLogo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_brand.brand_gengxinshijian
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    private String brandGengxinshijian;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table car_brand
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_brand.id
     *
     * @return the value of car_brand.id
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_brand.id
     *
     * @param id the value for car_brand.id
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_brand.brand_shouzimu
     *
     * @return the value of car_brand.brand_shouzimu
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public String getBrandShouzimu() {
        return brandShouzimu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_brand.brand_shouzimu
     *
     * @param brandShouzimu the value for car_brand.brand_shouzimu
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public void setBrandShouzimu(String brandShouzimu) {
        this.brandShouzimu = brandShouzimu == null ? null : brandShouzimu.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_brand.brand_pinpai
     *
     * @return the value of car_brand.brand_pinpai
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public String getBrandPinpai() {
        return brandPinpai;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_brand.brand_pinpai
     *
     * @param brandPinpai the value for car_brand.brand_pinpai
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public void setBrandPinpai(String brandPinpai) {
        this.brandPinpai = brandPinpai == null ? null : brandPinpai.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_brand.brand_pinpai_id
     *
     * @return the value of car_brand.brand_pinpai_id
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public String getBrandPinpaiId() {
        return brandPinpaiId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_brand.brand_pinpai_id
     *
     * @param brandPinpaiId the value for car_brand.brand_pinpai_id
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public void setBrandPinpaiId(String brandPinpaiId) {
        this.brandPinpaiId = brandPinpaiId == null ? null : brandPinpaiId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_brand.brand_pinpai_logo
     *
     * @return the value of car_brand.brand_pinpai_logo
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public String getBrandPinpaiLogo() {
        return brandPinpaiLogo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_brand.brand_pinpai_logo
     *
     * @param brandPinpaiLogo the value for car_brand.brand_pinpai_logo
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public void setBrandPinpaiLogo(String brandPinpaiLogo) {
        this.brandPinpaiLogo = brandPinpaiLogo == null ? null : brandPinpaiLogo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_brand.brand_gengxinshijian
     *
     * @return the value of car_brand.brand_gengxinshijian
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public String getBrandGengxinshijian() {
        return brandGengxinshijian;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_brand.brand_gengxinshijian
     *
     * @param brandGengxinshijian the value for car_brand.brand_gengxinshijian
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    public void setBrandGengxinshijian(String brandGengxinshijian) {
        this.brandGengxinshijian = brandGengxinshijian == null ? null : brandGengxinshijian.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_brand
     *
     * @mbg.generated Sat Nov 23 09:13:24 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandShouzimu=").append(brandShouzimu);
        sb.append(", brandPinpai=").append(brandPinpai);
        sb.append(", brandPinpaiId=").append(brandPinpaiId);
        sb.append(", brandPinpaiLogo=").append(brandPinpaiLogo);
        sb.append(", brandGengxinshijian=").append(brandGengxinshijian);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}