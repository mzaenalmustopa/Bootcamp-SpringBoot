package mzaaenalmustopa.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("target(mzaaenalmustopa.springaop.service.HelloService)")
    public void helloServiceMethod(){

    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Before " + className + " " + methodName + "()" );
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod2(){
        log.info("Before HelloService Method Again");
    }

    @Around("helloServiceMethod()")
    public Object aroundServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable{
         String className = joinPoint.getTarget().getClass().getName();
         String methodName = joinPoint.getSignature().getName();
         try {
             log.info("Around Before " + className + "." + methodName + "()");
             return joinPoint.proceed(joinPoint.getArgs());
         } catch (Throwable throwable){
             log.info("Around Error " + className + "." + methodName + "()" );
             throw throwable;
         } finally {
             log.info("Around Finally " + className + "." + methodName + "()");
         }
    }

    @Pointcut("execution(* mzaaenalmustopa.springaop.service.HelloService.*(java.lang.String))")
    public void pointcutHelloServiceStringParam(){

    }

//    @Before("pointcutHelloServiceStringParam()")
//    public void logStringParameter(JoinPoint joinPoint){
//        String value = (String) joinPoint.getArgs()[0];
//        log.info("Execute method with parameter : " + value);
//    }

    @Before("pointcutHelloServiceStringParam() && args(name)")
    public void logStringParameter(String name){
        log.info("Execute method with parameter : " + name);
    }

    @Pointcut("execution(* mzaaenalmustopa.springaop.service.*.*(..))")
    public void pointcutServicePackage(){

    }

    @Pointcut("bean(helloService)")
    public void pointcutServiceBean(){

    }

    @Pointcut("execution(public * *(..)) ")
    public void pointcutPublicMethod(){

    }

    @Pointcut("pointcutServicePackage() && pointcutServiceBean() && pointcutPublicMethod()")
    public void publicMethodForService(){

    }

    @Before("publicMethodForService()")
    public void logAllPublicServiceMethod(){
        log.info("Log for all public service method");
    }
}
