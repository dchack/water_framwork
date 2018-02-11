package com.hope.learn.third.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by hope on 2018/2/6.
 */
public class InvocationHandlerTest {

    public static void main(String[] args) throws Exception {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/dongchao/dc_file/gitwork/");
//        new InvocationHandlerTest().testInvocationHandler();
        new InvocationHandlerTest().testMethodInterceptor();
    }
    public void testInvocationHandler() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {

            //这个就比较细粒度了，可以根据method args 来进行不同的拦截逻辑
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                //getDeclaringClass 检查方法是不是本类的方法
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "Hello cglib!";
                } else {
                    throw new RuntimeException("Do not know what to do.");
                }
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("Hello cglib!"+proxy.test(null));
        System.out.println("Hello cglib!"+proxy.toString());
        proxy.hashCode();
    }


    public void testMethodInterceptor() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                    throws Throwable {
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "Hello cglib!";
                } else {
                    return proxy.invokeSuper(obj, args);
                }
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("Hello cglib!"+proxy.test(null));
//        System.out.println("Hello cglib!"+proxy.toString());
//        proxy.hashCode(); // Does not throw an exception or result in an endless loop.
    }
}
