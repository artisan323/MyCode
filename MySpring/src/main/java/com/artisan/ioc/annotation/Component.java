package com.artisan.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author wannengqingnian
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Component {
    String value() default "";
}