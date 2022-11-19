package com.xu.annotation;

import com.xu.aop.Convert;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xucanjin
 * @date 2022/11/19
 * @description
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordOperate {

    String desc() default "";

    Class<? extends Convert> convert();
}
