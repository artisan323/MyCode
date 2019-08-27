package com.artisan.ioc;

import com.artisan.ioc.support.BeanDefinition;

import java.util.List;

/**
 * @author wannengqingnian
 */
public interface BeanRegister {
    /**
     * 向工厂内注册BeanDefinition
     * @param bds
     */
    void registBeanDefinition(List<BeanDefinition> bds);

    /**
     * 向工厂内注册bean实例对象
     * @param id
     * @param instance
     */
    void registInstanceMapping(String id,Object instance);
}
