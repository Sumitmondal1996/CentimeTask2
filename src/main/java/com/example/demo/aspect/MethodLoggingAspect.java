package com.example.demo.aspect;

import com.example.demo.annotation.LogMethodParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class MethodLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodLoggingAspect.class);

    @Around("@annotation(com.example.demo.annotation.LogMethodParam)")
    public Object logMethodDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogMethodParam annotation = method.getAnnotation(LogMethodParam.class);

        String methodName = method.getName();
        Object[] args = joinPoint.getArgs();

        // Logging arguments if enabled
        if (annotation.logArguments()) {
            logger.info("Method: {} called with parameters: {}", methodName, args);
        }

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();  // Proceed with method execution
        long endTime = System.currentTimeMillis();

        // Logging execution time if enabled
        if (annotation.logExecutionTime()) {
            logger.info("Execution time of {} : {} ms", methodName, (endTime - startTime));
        }

        return result;
    }
}
