package com.hope.learn.patterns.proxy.dynamic;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hope on 17/2/24.
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler() {
    }

    public ProxyHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("take my phone");
        Object result = method.invoke(object,args);
        System.out.println("smell bad");
        return result;
    }
}
