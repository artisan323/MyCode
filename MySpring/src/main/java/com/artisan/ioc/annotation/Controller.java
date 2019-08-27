package com.artisan.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author wannengqingnian
 */
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Target(ElementType.TYPE)//作用在类上面
@Documented
public @interface Controller {
    String value() default "";
}
