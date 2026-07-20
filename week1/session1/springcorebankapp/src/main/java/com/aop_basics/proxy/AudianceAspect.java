package com.aop_basics.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //aspect =advice + pointcut
public class AudianceAspect {
	@After("execution( * com.aop_basics.proxy.Magician.do*(..))")
	//we want to know information about target method?
	public void clapping(JoinPoint joinPoint){
		System.out.println("maza aa gaya..: "+ joinPoint.getSignature().getName()+"() is completed");
	}
}












//		@Pointcut("execution(public void doMagic())")
//		public void watch(){}
//
//		@After("watch()")
//		public void clapping(){
//			System.out.println("maza aa gaya...");
//		}