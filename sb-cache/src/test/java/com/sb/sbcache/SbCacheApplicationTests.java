package com.sb.sbcache;

import com.sb.sbcache.bean.Employee;
import com.sb.sbcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbCacheApplicationTests {

    @Resource
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;

    @Test
    public void testRedis(){
        /*String msg = stringRedisTemplate.opsForValue().get("k1");
        System.out.println(msg);

        //测试添加数据
        stringRedisTemplate.opsForList().leftPush("zmxlist", "zmx");
        stringRedisTemplate.opsForList().leftPush("zmxlist", "zj");*/

        //使用自定义把对象转换为json数据格式保存
        Employee employee = employeeMapper.getEmployeeById(1);
        //employeeRedisTemplate.opsForValue().set("111", employee);

        redisTemplate.opsForValue().set("zmxemp", employee);

    }

    @Test
    public void contextLoads() {

        Employee employee = employeeMapper.getEmployeeById(1);
        System.out.println(employee);

    }

}
