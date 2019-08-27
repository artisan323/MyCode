package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.po.MyUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;
import java.util.List;

public class MyBatisTest {
    @Test
    public void test(){
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();
            //采用接口绑定方案
            UserMapper um = ss.getMapper(UserMapper.class);

            MyUser LYH = new MyUser(2, "罗永浩", "男");
            um.addUser(LYH);


            MyUser mu = um.selectUserById(1);
            System.out.println(mu);

            MyUser mu2 = um.selectUserById(2);
            System.out.println(mu2);

            List<MyUser> list = um.selectAllUser();
            System.out.println(list);
            ss.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
