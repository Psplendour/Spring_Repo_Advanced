package com.pk.aop.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.pk.model.Account;
@Aspect
@Component
public class AccountServiceAspect {
    @AfterReturning(value="execution(* com.pk.serviceimpl.AccountServiceImpl.*(..) )",returning="account")
	public void afterReturningAdvice(JoinPoint joinPoint,Account account)
     {
    	System.out.println("After Returning method: "+joinPoint.getSignature().getName()+"class: "+joinPoint.getTarget().getClass().getSimpleName());
        System.out.println(account);
     }        
     @AfterThrowing(value="execution(* com.pk.serviceimpl.AccountServiceImpl.*(..) )",throwing="exception")
	 public void afterThrowingAddvice(JoinPoint joinPoint,Exception exception){
    	 System.out.println("After Throwing Exception in method: "+joinPoint.getSignature().getName()+"class: "+joinPoint.getTarget().getClass().getSimpleName());
         System.out.println("Exception is: "+exception.getMessage());
     }
}
