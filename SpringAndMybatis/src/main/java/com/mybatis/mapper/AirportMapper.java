package com.mybatis.mapper;

import com.mybatis.pojo.Airport;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AirportMapper {

    //查询起飞机场
    @Select("select * from airport where id in (select distinct takeid from airplane)")
    List<Airport> selTakePort();
}
