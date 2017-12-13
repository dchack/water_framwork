package com.hope.learn.patterns.proxy.dynamic;

import com.hope.learn.patterns.proxy.RealSubject;
import com.hope.learn.patterns.proxy.Subject;

import java.lang.reflect.Proxy;

/**
 * Created by hope on 17/2/24.
 */
public class TestProxy {

    public static void main(String[] args) {

        Subject subject = new RealSubject();
        ProxyHandler proxyHandler = new ProxyHandler(subject);
        Subject subjectProxy = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),proxyHandler);
        subjectProxy.toilet();
    }
}
