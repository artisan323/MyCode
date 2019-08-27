package com.artisan.ioc.support;

import com.artisan.ioc.ApplicationContext;
import com.artisan.ioc.BeanRegister;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class AnnotationApplicationContext implements ApplicationContext, BeanRegister {
    private Map<String,Object> instanceMapping = new ConcurrentHashMap<String, Object>();

    //保存所有bean的信息,主要包含bean的类型  id等信息
    private List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();
    //配置文件的config,这里为了简单我们使用properties文件
    private Properties config = new Properties();

    public AnnotationApplicationContext(String location){
        InputStream is = null;
        try{

            //1、定位
            is = this.getClass().getClassLoader().getResourceAsStream(location);

            //2、载入
            config.load(is);

            //3、注册
            register();

            //4、实例化
            createBean();

            //5、注入
            populate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 调用具体委派的注入类进行注入
     */
    private void populate() {
        Populator populator = new Populator();
        populator.populate(instanceMapping);
    }

    /**
     * 调用具体的创建对象创建beanz
     */
    private void createBean() {
        BeanCreater creater = new BeanCreater(this);
        creater.create(beanDefinitions);
    }

    /**
     * 调用具体的注册对象注册bean信息
     */
    private void register() {
        BeanDefinitionParser parser = new BeanDefinitionParser(this);
        parser.parse(config);
    }

    @Override
    public Object getBean(String id) {
        return instanceMapping.get(id);
    }

    public Properties getConfig() {
        return this.config;
    }

    @Override
    public <T> T getBean(String id, Class<T> clazz) {
        return (T)instanceMapping.get(id);
}

    @Override
    public Map<String, Object> getBeans() {
        return instanceMapping;
    }

    @Override
    public void registBeanDefinition(List<BeanDefinition> bds) {
        beanDefinitions.addAll(bds);
    }

    @Override
    public void registInstanceMapping(String id, Object instance) {
        instanceMapping.put(id,instance);
    }

}
