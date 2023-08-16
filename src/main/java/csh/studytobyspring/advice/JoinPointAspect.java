package csh.studytobyspring.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class JoinPointAspect {

    @Before("execution(* csh.studytobyspring.service.MemberService.*(..))")
    public void before(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String method = jp.getSignature().getName();
        log.info("before {}({})", method, args);
    }

    @Around("execution(* csh.studytobyspring.service.MemberService.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        String method = pjp.getSignature().getName();
        Object result = pjp.proceed();
        log.info("around {}({}) -> {}", method, args, result);
        return result;
    }

}
