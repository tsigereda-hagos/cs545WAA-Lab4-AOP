package main.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Around(value = "@annotation(main.aop.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Object proceed = joinPoint.proceed();
        Instant end = Instant.now();
        long executionTime = Duration.between(start, end).toMillis();
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

}
