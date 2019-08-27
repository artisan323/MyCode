package com.sb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sb01ApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {

        logger.trace("这是trace信息");
        logger.debug("这是debug信息");
        logger.info("这是info信息");
        logger.warn("这是warn信息");
        logger.error("这是error信息");
    }

}
