package com.jadson.study.config.dynamicds;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 解析EnableMasterSlave注解
 */
@Aspect
@Component
public class EnableMasterSlaveResolver {

    @Pointcut("@within(com.jadson.study.config.dynamicds.EnableMasterSlave)")
    public void masterSlavePoint() {

    }

    @Around("masterSlavePoint()")
    public Object masterSlaveResolve(ProceedingJoinPoint jp) throws Throwable {
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        if (method.getName().endsWith("ReadOnly")) {
            System.out.println("change slave datasource ....");
            DataSourceContext.setDataSource("slave");
        }
        Object rspValue = jp.proceed();
        DataSourceContext.clear();
        return rspValue;
    }
}
