package com.basic.my.aop;

import javafx.scene.paint.Stop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Aspect
 * 구현하고자 하는 횡단 관심사의 기능을 의미한다. 한개 이상의 포인트컷과 어드바이스의 조합으로 만들어진다.
 * */
@Aspect
public class MyAspect {

    protected static final Logger logger = LoggerFactory.getLogger(MyAspect.class);


    /**
     * Pointcut
     * 어드바이스를 적용할 조인 포인트를 선별하는 과정이나 그 기능을 정의한 모듈
     * 아래를 해석해 보자면
     * public               *                         com.basic.my.service.impl.testServiceImpl.*(..))
     * 접근지정자가 public이며 반환자료형은 아무거나 상관없고  해당 패키지 내부의                          .모든함수에 대해서
     * 어드바이스를 적용하려 한다는것입니다.
     * */
    @Pointcut("execution(public * com.basic.my.service.impl.testServiceImpl.*(..))")
    public void serviceLog(){

    }

    @Pointcut("execution(* com.basic.my.controller.BasicController.*(..))")
    public void controllerLog(){

    }

    /**
     * Advice
     * 관점의 구현체로 조인 포인트에 삽입되어 동작하는 코드이다.
     * Before, After returning, After throwing, After, Around이 존재 한다.
     * */
    @Around("controllerLog()")
    /**
     * 아래의 어드바이스에서 하고자 하는 바는 StopWatch를 이용하여 특정 호출 및 실행 후 시간이 얼마걸리는지 알아보기 위함이며
     * 이를 이용하여 특정 로그를 추가하여 속도가 느린 프로세스에 대해 개선을 위한 목적으로 남기려고 한다.
     * 그 외에도 활용도는 무궁무진하겠징
     * */
    public Object beforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("around Advice : before");

        StopWatch sw = new StopWatch();
        sw.start();

        Object result = joinPoint.proceed();

        sw.stop();
        Long total = sw.getTotalTimeMillis();

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String taskName = className+"."+methodName;

        logger.info("[ExecutionTime] {} {}(ms)",taskName,total);

        return result;
    }
}
