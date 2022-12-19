package com.bm.relation.core.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * api层注解过多 组装各类所需注解
 * 只需引入此注解可减少代码层注解数量
 * @author : zyg
 * @since : 2022/07/19
 **/

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Controller
@ResponseBody
@RestController
@RequestMapping
public @interface ApiPath {

    @AliasFor("path")
    String[] value() default {};

    @AliasFor("value")
    String[] path() default {};
}