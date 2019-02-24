package com.itheima.utils;

import com.itheima.domain.SysLog;
import com.itheima.service.ISysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Aspect
@Component
public class LogAspect {


    @Autowired
    private ISysLogService sysLogService;


    @Autowired
    private ServletRequest request;


    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object insertLog(ProceedingJoinPoint pjp){

        try {
            String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            String classname = pjp.getTarget().getClass().getName();
            String methodName = pjp.getSignature().getName();
            String result = classname+"." + methodName + "(..)";
            SysLog sysLog = new SysLog();
            sysLog.setVisitTime(new Timestamp(new Date().getTime()));
            sysLog.setMethod(result);
            sysLog.setUsername(username);
            sysLog.setIp(request.getRemoteAddr());
            //放行
            Object retV = pjp.proceed();
            sysLogService.insertLog(sysLog);
            return retV;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

}
