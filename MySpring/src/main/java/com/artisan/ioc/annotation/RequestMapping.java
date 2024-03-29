package com.artisan.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author wannengqingnian
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})//作用在类和方法 仿照springmvc的套路来
@Documented
public @interface RequestMapping {
    String value() default "";
}
