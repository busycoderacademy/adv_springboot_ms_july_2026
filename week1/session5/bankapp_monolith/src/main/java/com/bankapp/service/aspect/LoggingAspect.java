package com.bankapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LoggingAspect {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Around("execution( * com.bankapp.service.*.*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
         Object value= joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("================================================");
        logger.info("Method {} completed in {} ms", joinPoint.getSignature().getName(), (endTime - startTime));
        return value;
    }

}
