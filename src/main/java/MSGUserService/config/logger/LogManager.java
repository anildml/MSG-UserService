package MSGUserService.config.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogManager {

    @Autowired
    private AppLogger logger;

    @Around("" +
            "execution(* MSGUserService.services..*(..)) || " +
            "execution(* MSGUserService.controllers..*(..)) || " +
            "execution(* MSGUserService.daos..*(..))")
    public Object logRequests(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodSignature = signature.getDeclaringTypeName() + ":" + signature.getMethod().getName() + "()";

        logger.debug(methodSignature + " before", null);

        Object val = joinPoint.proceed();

        logger.debug(methodSignature + " after", null);

        return val;

    }

//    @AfterThrowing(
//            pointcut = "" +
//                    "execution(* com.nau21.bns.customerwebservice.services..*.*(..)) || " +
//                    "execution(* com.nau21.bns.customerwebservice.controllers..*(..)) || " +
//                    "execution(* com.nau21.bns.customerwebservice.repositories..*(..))",
//            throwing = "e"
//    )
//    public void logException(Exception e) {
//
//        logger.debug(e.getMessage(), null);
//
//    }

}
