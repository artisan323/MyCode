package com.mybatis.service.Impl;

import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;

import com.mybatis.mapper.AirportMapper;
import com.mybatis.pojo.Airport;
import com.mybatis.service.AirportService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AirportServiceImpl implements AirportService {
    @Override
    public List<Airport> showTakePort() throws IOException {


        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        AirportMapper airportMapper = (AirportMapper) session.getMapper(Airport.class);
        return airportMapper.selTakePort();
    }
}
