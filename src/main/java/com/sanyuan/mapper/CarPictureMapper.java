package com.sanyuan.mapper;

import com.sanyuan.pojo.CarPicture;
import com.sanyuan.pojo.CarPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarPictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    long countByExample(CarPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    int deleteByExample(CarPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    int deleteByPrimaryKey(Integer pictureId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    int insert(CarPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    int insertSelective(CarPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    List<CarPicture> selectByExample(CarPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    CarPicture selectByPrimaryKey(Integer pictureId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    int updateByExampleSelective(@Param("record") CarPicture record, @Param("example") CarPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    int updateByExample(@Param("record") CarPicture record, @Param("example") CarPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    int updateByPrimaryKeySelective(CarPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_picture
     *
     * @mbg.generated Tue Nov 26 09:29:06 CST 2019
     */
    int updateByPrimaryKey(CarPicture record);
}