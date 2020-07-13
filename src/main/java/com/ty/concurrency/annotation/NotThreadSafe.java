package com.ty.concurrency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/7/4 8:36 下午
 * @description : 用来标注线程不安全的类
 * @modified By  :
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {

    String value() default "";

}
