package com.bankapp.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Aspect //aspect=advice + pointcut
public class LoggingAspect {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Around("execution(  * com.bankapp.service.AccountServiceImpl.*(..))")
    public Object loggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start=System.currentTimeMillis();

        Object result=proceedingJoinPoint.proceed();

        long end=System.currentTimeMillis();
        logger.info("Time taken call method: "+(end-start)+" ms "+ "name of method is "+
                proceedingJoinPoint.getSignature().getName());

        return  result;
    }
    //if any ex come anywhere in the project then it will be logged
    @AfterThrowing(pointcut = "execution(  * com.bankapp.service.AccountServiceImpl.*(..))",throwing = "ex")
    public void loggingException(JoinPoint joinPoint, Exception ex) {
        logger.info(ex.getMessage());
        logger.error("Exception in method: "+joinPoint.getSignature().getName());
    }

}
