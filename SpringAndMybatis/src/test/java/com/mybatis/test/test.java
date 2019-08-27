package com.mybatis.test;

import com.mybatis.mapper.AirportMapper;
import com.mybatis.pojo.Airport;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    @Test
    public void test(){
        InputStream config = null;
        try {
            config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();

            AirportMapper airportMapper = ss.getMapper(AirportMapper.class);
            List<Airport> airport = airportMapper.selTakePort();
            System.out.println(airport);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
