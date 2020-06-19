package com.medsci.hello.spring.boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 学长
 * @date: 2020/6/11 10:56
 */
@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.medsci.hello.spring.boot.controller.*.*(..))")
    private void myPointCut(){}


    /**
     * 前置通知：在目标方法执行前调用
     */
    @Before("myPointCut()")
    public void before(){
        System.out.println("前置通知");
    }

    /**
     * 后置/最终通知：无论目标方法在执行过程中出现异常都会在它之后调用
     */
    @After("myPointCut()")
    public void after(){
        System.out.println("后置/最终通知");
    }

    /**
     * 后置通知: 在目标方法执行后调用，若目标方法出现异常，则不执行
     */
    @AfterReturning("myPointCut()")
    public void afterReturning(){
        System.out.println("后置通知");
    }

    /**
     * 异常通知：目标方法抛出异常时执行
     */
    @AfterThrowing("myPointCut()")
    public void afterThrowing(){
        System.out.println("异常通知");
    }

    /**
     * 环绕通知：灵活自由的在目标方法中切入代码
     */
    @Around("execution(* com.medsci.hello.spring.boot.controller.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // 获取目标方法的名称
        String methodName = proceedingJoinPoint.getSignature().getName();

        //获取目标方法传入参数
//        Object[] params = proceedingJoinPoint.getArgs();

        System.out.println("method name " + methodName);

        //执行源方法
        Object object = proceedingJoinPoint.proceed();

        return object;
        //模拟进行验证
    }
}
