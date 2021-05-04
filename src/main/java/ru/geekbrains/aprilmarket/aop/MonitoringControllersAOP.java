package ru.geekbrains.aprilmarket.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Aspect
@Component
public class MonitoringControllersAOP {

    @Pointcut("execution(* ru.geekbrains.aprilmarket.controllers.ProductController.findAllProducts())")
    private void getProducts() {
    }

    @Around("getProducts()")
    public Object beforeGetProducts(ProceedingJoinPoint joinPoint) throws Throwable {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long startTime = timestamp.getTime();
        System.out.println("Start load Products " + startTime);

        Object retVal = joinPoint.proceed();

        Timestamp endTimestamp = new Timestamp(System.currentTimeMillis());
        long endTime = endTimestamp.getTime();

        System.out.println("End load Products " + endTime);
        System.out.println("Products load at: " + (endTime - startTime) + "ms");

        return retVal;

    }
}
