package com.gaeainfo.module.base.annotation;

/**
 * Created by Rock on 2017/4/28.
 */
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckRequestToken {
    boolean value() default true;
    String[] roleName() default {};
    String[] excludeRoleName() default {};
}
