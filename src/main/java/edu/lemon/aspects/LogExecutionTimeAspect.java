package edu.lemon.aspects;

import lombok.Setter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
@Aspect
public class LogExecutionTimeAspect {
    private long start = 0;
    private long end = 0;

  private static final Logger LOG = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

    @Around("@annotation(edu.lemon.aspects.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        Object proceed = joinPoint.proceed();

        long executionTime = System.nanoTime() - start;
        LOG.info(String.format("Method %s was executed in %d ns", joinPoint.getSignature(), executionTime));
        return proceed;
    }

    @Before("@annotation(edu.lemon.aspects.annotation.LogExecutionTime)")
    public void logExecutionTimeStart() throws Throwable {
        start = System.nanoTime();
      System.out.println("Before pointcut");
    }

    @After("@annotation(edu.lemon.aspects.annotation.LogExecutionTime)")
    public void logExecutionTimeEnd() throws Throwable {

        LOG.info(String.format("Method was executed in %d ns", end - start));
        System.out.printf("Method was executed in %d ns", end - start);
    }

}
