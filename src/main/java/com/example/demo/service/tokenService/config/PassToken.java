package com.example.demo.service.tokenService.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ranran.mao
 * @date 2021/12/10 13:06
 * 用来跳过验证的PassToken
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean requiesd() default true;
}
