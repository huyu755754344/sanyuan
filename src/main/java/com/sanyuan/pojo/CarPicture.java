package com.sanyuan.pojo;

import java.io.Serializable;

public class CarPicture implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_picture.picture_id
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    private Integer pictureId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_picture.car_id
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    private Integer carId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_picture.picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    private String picture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_picture.status
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_picture.picture_id
     *
     * @return the value of car_picture.picture_id
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    public Integer getPictureId() {
        return pictureId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_picture.picture_id
     *
     * @param pictureId the value for car_picture.picture_id
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_picture.car_id
     *
     * @return the value of car_picture.car_id
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_picture.car_id
     *
     * @param carId the value for car_picture.car_id
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_picture.picture
     *
     * @return the value of car_picture.picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_picture.picture
     *
     * @param picture the value for car_picture.picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_picture.status
     *
     * @return the value of car_picture.status
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_picture.status
     *
     * @param status the value for car_picture.status
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pictureId=").append(pictureId);
        sb.append(", carId=").append(carId);
        sb.append(", picture=").append(picture);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}