package com.hope.learn.patterns.proxy.dynamic;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by hope on 17/2/24.
 */
public class CglibProxyInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method,
                            Object[] args, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("take my phone");
        Object o1 = methodProxy.invokeSuper(o, args);
        System.out.println("smell bad");
        return o1;
    }
}
