package com.xu.aop;

import com.xu.annotation.RecordOperate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xucanjin
 * @date 2022/11/19
 * @description 记录订单id的切面
 * 配置切面必须添加@Aspect和@Component注解
 */

@Aspect
@Component
public class OperateAspect {

    /**
     * 1、先定义切入点
     * 2. 再定义横切逻辑
     */
    @Pointcut("@annotation(com.xu.annotation.RecordOperate)")
    public void pointCut() {
    }

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100));

    @Around("pointCut()")
    public Object around(final ProceedingJoinPoint joinPoint) throws Throwable {
        final Object result = joinPoint.proceed();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
                    RecordOperate annotation = methodSignature.getMethod().getAnnotation(RecordOperate.class);

                    Class<? extends Convert> convert = annotation.convert();
                    Convert logConvert = convert.newInstance();
                    OperateLog log = logConvert.convert(joinPoint.getArgs()[0]);
                    log.setDesc(annotation.desc());
                    log.setResult(result.toString());
                    System.out.println("Id:" + log.getOrderId());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        return result;
    }
}
