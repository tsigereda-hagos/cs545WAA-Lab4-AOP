package main.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLoggingAspect {
    @AfterThrowing(pointcut = "execution(* main.service.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Exception thrown in " + joinPoint.getSignature().getName() + ": " + exception.getMessage());
    }
}
