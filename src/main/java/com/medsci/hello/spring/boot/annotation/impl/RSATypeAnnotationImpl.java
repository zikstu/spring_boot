package com.medsci.hello.spring.boot.annotation.impl;

import com.medsci.hello.spring.boot.annotation.OrderHandlerType;
import com.medsci.hello.spring.boot.annotation.RSATypeAnnotation;

import java.lang.annotation.Annotation;

/**
 * @description:
 * @author: 学长
 * @date: 2020/10/15 17:36
 */
public class RSATypeAnnotationImpl implements RSATypeAnnotation {
    private String keyType;

    private String action;

    public RSATypeAnnotationImpl(String keyType, String action){
        this.keyType = keyType;
        this.action = action;
    }

    @Override
    public String keyType() {
        return keyType;
    }

    @Override
    public String action() {
        return action;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return RSATypeAnnotation.class;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += (127 * "keyType".hashCode()) ^ keyType.hashCode();
        hashCode += (127 * "action".hashCode()) ^ action.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RSATypeAnnotation)) {
            return false;
        }
        RSATypeAnnotation other = (RSATypeAnnotation) obj;
        return keyType.equals(other.keyType()) && action.equals(other.action());
    }
}
