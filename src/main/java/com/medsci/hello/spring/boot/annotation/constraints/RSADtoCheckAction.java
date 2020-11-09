package com.medsci.hello.spring.boot.annotation.constraints;

import com.medsci.hello.spring.boot.annotation.constraints.impl.RSADtoCheckActionValidatorImpl;

import javax.validation.Constraint;
import java.lang.annotation.*;
import javax.validation.Payload;

@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RSADtoCheckActionValidatorImpl.class)
public @interface RSADtoCheckAction {
        /**
         * 校验字段名
         * @return
         */
        String name() default "action";

        /**
         * 默认错误信息
         * @return
         */
        String message() default "参数错误！";

        /**
         * 分组
         * @return
         */
        Class<?>[] groups() default {};

        /**
         * 负载
         * @return
         */
        Class<? extends Payload>[] payload() default {};

        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @interface List{
                RSADtoCheckAction[] value();
        }
}
