package com.fnfn.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명: <code>LoggerAspect</code><br>
 *
 *
 *
 * @author fnfnk
 * @since 2020. 4. 24.
 *
 */
@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Around("  execution(* blog..controller.*Controller.*(..)) or"
            + "execution(* blog..service.*Service.*(..)) or"
            + "execution(* blog..dao.*Dao.*(..))")
    public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();

        if (name.indexOf("Controller") > -1) {
            type = "Controller \t: ";
        }

        if (name.indexOf("Service") > -1) {
            type = "Service \t: ";
        }

        if (name.indexOf("Dao") > -1) {
            type = "Dao \t: ";
        }

        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
