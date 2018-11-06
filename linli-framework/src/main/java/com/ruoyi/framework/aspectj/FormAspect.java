package com.ruoyi.framework.aspectj;


import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Aspect
@Component
public class FormAspect {


    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    private static final String PARAM_TOKEN = "token";
    private static final String PARAM_TOKEN_FLAG = "tokenFlag";


    // 配置织入点
    @Pointcut("@annotation(com.ruoyi.common.annotation.Form)")
    public void formPointCut() {
    }

    @Around("formPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object result = null;
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                if (args[i] != null && args[i] instanceof HttpServletRequest) {
                    //被调用的方法需要加上HttpServletRequest request这个参数
                    HttpServletRequest request = (HttpServletRequest) args[i];
                    if (request.getMethod().equalsIgnoreCase("get")) {
                        //方法为get
                        result = generate(joinPoint, request, PARAM_TOKEN_FLAG);
                    } else {
                        //方法为post
                        result = validation(joinPoint, request, PARAM_TOKEN_FLAG);
                    }
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();

            return AjaxResult.error("执行防止重复提交功能AOP失败，原因").put("error",e.getMessage());
        }

    }


    private Object generate(ProceedingJoinPoint joinPoint, HttpServletRequest request, String tokenFlag) throws Throwable {
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(PARAM_TOKEN, uuid);
        return joinPoint.proceed();
    }

    private Object validation(ProceedingJoinPoint joinPoint, HttpServletRequest request, String tokenFlag) throws Throwable {
        String requestFlag = request.getParameter(PARAM_TOKEN);
        //redis加锁
        boolean lock = RedisUtil.setnxLock(tokenFlag + requestFlag, requestFlag, 60000);
        if (lock) {
            //加锁成功
            //执行方法
         System.out.println("加锁成功");
            Object funcResult = joinPoint.proceed();
            //方法执行完之后进行解锁
            RedisUtil.del(tokenFlag + requestFlag);
            return funcResult;
        } else {
            //锁已存在
            return AjaxResult.error("请勿重复提交");
        }
    }


}
