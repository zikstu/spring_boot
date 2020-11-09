package com.medsci.hello.spring.boot.annotation.constraints.impl;

import com.medsci.hello.spring.boot.annotation.constraints.RSADtoCheckAction;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description:
 * @author: 学长
 * @date: 2020/11/6 14:29
 */
public class RSADtoCheckActionValidatorImpl implements ConstraintValidator<RSADtoCheckAction, String> {
    private String name;

    @Override
    public void initialize(RSADtoCheckAction constraintAnnotation) {
        this.name = constraintAnnotation.name();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (this.name == "action"){
            if (s == "encrypt" || s == "decrypt"){
                return true;
            }
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("非法操作！").addConstraintViolation();
        }else if (this.name == "keyType"){
            if (s == "private" || s == "public"){
                return true;
            }
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Key 类型非法！").addConstraintViolation();
        }else {
            return false;
        }

        return false;
    }
}
