package com.hope.learn.patterns.proxy.dynamic;

import com.hope.learn.patterns.proxy.RealSubject;
import com.hope.learn.patterns.proxy.Subject;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by hope on 17/2/24.
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxyInterceptor cglibProxyInterceptor = new CglibProxyInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(cglibProxyInterceptor);
        enhancer.setSuperclass(RealSubject.class);
        Subject subject = (Subject)enhancer.create();
        subject.toilet();

    }
}
