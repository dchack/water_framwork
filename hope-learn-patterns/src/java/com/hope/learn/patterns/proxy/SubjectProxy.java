package com.hope.learn.patterns.proxy;

/**
 * Created by hope on 17/2/24.
 */

/**
 * 代理类控制了真实角色的访问权限
 * 而从代理类自身增强的角度来看,可以说是控制了被代理功能的粒度细分的控制
 */
public class SubjectProxy implements Subject{

    Subject subject =  new RealSubject();

    public void toilet() {
        System.out.println("take my phone");
        subject.toilet();
        System.out.println("smell bad");
    }
}
