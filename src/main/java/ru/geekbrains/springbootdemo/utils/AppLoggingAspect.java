package ru.geekbrains.springbootdemo.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AppLoggingAspect {

    @AfterReturning(
            pointcut = "execution(public * ru.geekbrains.springbootdemo.utils.UserDAO.getAllUsers(..))",
            returning = "result")
    public void afterGetBobInfo(JoinPoint joinPoint, List<String> result) {

    }

}
