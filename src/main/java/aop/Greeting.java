package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by harlenzhang on 16/8/10.
 */
public class Greeting implements MethodInterceptor, MethodBeforeAdvice{
    public void greet(){
        System.out.println("hello,");
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
       // greet();
        invocation.proceed();
        return null;
    }

    public void before(Method method, Object[] args, Object target) throws Throwable {
        greet();
    }
}
