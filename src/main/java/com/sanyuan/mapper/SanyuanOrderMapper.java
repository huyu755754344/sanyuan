package com.sanyuan.mapper;

import com.sanyuan.pojo.SanyuanOrder;
import com.sanyuan.pojo.SanyuanOrderExample;
import java.util.List;

public interface SanyuanOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(SanyuanOrder record);

    int insertSelective(SanyuanOrder record);

    List<SanyuanOrder> selectByExample(SanyuanOrderExample example);

    SanyuanOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(SanyuanOrder record);

    int updateByPrimaryKey(SanyuanOrder record);
    /**
     * 根据用户id和 汽车id 查询所有成功的交易记录 
     * @param userId
     * @param carId
     * @return 
     */
    SanyuanOrder chackOrderByUserIdCarIdOK(Long userId,Integer carId);
    SanyuanOrder findOrderByUserIdCarIdING(Long userId,Integer carId);
}