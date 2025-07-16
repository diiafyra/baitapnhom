package com.example.baitapnhom.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.baitapnhom.service.BorrowService.borrowBook(..))")
    public Object logBorrowExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("THOI GIAN THUC HIEN MUON SACH: " + (end - start) + "ms");
        return proceed;
    }

    @Around("execution(* com.example.baitapnhom.service.BorrowService.returnBook(..))")
    public Object logReturnExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("THOI GIAN THUC HIEN TRA SACH: " + (end - start) + "ms");
        return proceed;
    }
}
