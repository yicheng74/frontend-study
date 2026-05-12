package com.exampleforsb.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect // 标识当前类是一个AOP类
@Component
public class RecordTimeAspect {

    @Around("execution(* com.exampleforsb.demo.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {

        // 1. 记录方法开始时间
        long begin = System.currentTimeMillis();

        // 2. 执行原始方法
        Object result = pjp.proceed();

        // 3. 记录方法结束时间
        long end = System.currentTimeMillis();

        // 4. 计算耗时
        log.info("方法执行耗时: {}ms", end - begin);

        return result;
    }
}