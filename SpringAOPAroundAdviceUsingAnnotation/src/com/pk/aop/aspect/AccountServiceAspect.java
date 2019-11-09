package com.pk.aop.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountServiceAspect {
     @Around(value = "execution(* com.pk.serviceimpl.AccountServiceImpl.*(..))")
     public Object aroundAdvice(ProceedingJoinPoint joinPoint)
     {
    	 long sTime = System.currentTimeMillis();
    	 System.out.println("Before method: "+joinPoint.getSignature().getName()+"class: "+joinPoint.getTarget().getClass().getSimpleName());    	 
    	 Object object = null;
    	 try {
			Object proceed = joinPoint.proceed();
		     } catch (Throwable ex) 
    	 {
			System.out.println(ex.getMessage());
		}   	
    	 System.out.println("After method: "+joinPoint.getSignature().getName()+"class: "+joinPoint.getTarget().getClass().getSimpleName());  
    	 long eTime = System.currentTimeMillis();
  	     System.out.println("Total execution time taken by method"+joinPoint.getSignature().getName()+" is :"+(eTime-sTime)+" ms");
    	 return object;    	   	 
     }
}
