package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by harlenzhang on 16/8/10.
 */
public class Greeting implements MethodInterceptor{
    public void greet(){
        System.out.println("hello,");
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        greet();
        invocation.proceed();
        return null;
    }
}
