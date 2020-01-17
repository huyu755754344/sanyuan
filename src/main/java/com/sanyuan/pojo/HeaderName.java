package com.sanyuan.pojo;

import java.io.Serializable;

public class HeaderName implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column header_name.id
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column header_name.param_type
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    private String paramType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column header_name.cn_name
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    private String cnName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column header_name.en_name
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    private String enName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table header_name
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column header_name.id
     *
     * @return the value of header_name.id
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column header_name.id
     *
     * @param id the value for header_name.id
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column header_name.param_type
     *
     * @return the value of header_name.param_type
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column header_name.param_type
     *
     * @param paramType the value for header_name.param_type
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column header_name.cn_name
     *
     * @return the value of header_name.cn_name
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column header_name.cn_name
     *
     * @param cnName the value for header_name.cn_name
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column header_name.en_name
     *
     * @return the value of header_name.en_name
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    public String getEnName() {
        return enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column header_name.en_name
     *
     * @param enName the value for header_name.en_name
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table header_name
     *
     * @mbg.generated Mon Nov 25 10:08:50 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", paramType=").append(paramType);
        sb.append(", cnName=").append(cnName);
        sb.append(", enName=").append(enName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}