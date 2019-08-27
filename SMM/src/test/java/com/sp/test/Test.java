package com.sp.test;

import com.sp.pojo.Idcard;
import com.sp.pojo.Person;
import com.sp.serviceImpl.IdcardServiceImpl;
import com.sp.serviceImpl.PersonServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext appcon = new ClassPathXmlApplicationContext("applicationContext.xml");
        IdcardServiceImpl idcardServiceImpl = appcon.getBean("IdcardService", IdcardServiceImpl.class);
        PersonServiceImpl personServiceImpl = appcon.getBean("PersonService", PersonServiceImpl.class);

        Idcard idcard = idcardServiceImpl.showIdcard(1);
        System.out.println(idcard);
        Person person = personServiceImpl.showPerson(1);
        System.out.println(person);
//        String[] names =  appcon.getBeanDefinitionNames();
//        for (String  e: names) {
//            System.out.println(e);
//        }

    }
}
