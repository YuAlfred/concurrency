package com.ty.concurrency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/7/4 8:32 下午
 * @description : 用来标记不推荐的写法
 * @modified By  :
 */
//注解可标注位置
@Target(ElementType.TYPE)
//注解存在番位范围
@Retention(RetentionPolicy.SOURCE)
public @interface NotRecommend {

    String value() default "";

}
