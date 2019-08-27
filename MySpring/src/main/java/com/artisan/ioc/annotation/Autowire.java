package com.artisan.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author wannengqingnian
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)//作用在字段上面
@Documented
public @interface Autowire {
    String value() default "";
}
