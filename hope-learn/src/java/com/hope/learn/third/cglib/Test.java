package com.hope.learn.third.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * Created by hope on 2018/2/6.
 */

public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        // Enhancer 产生动态的子类以达到对被代理类的方法拦截
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);// 继承
        enhancer.setCallback(new FixedValue() {
            // 所有方法的返回值都被拦截替换 所以proxy.toString()也是 proxy.hashCode()就会类型转换失败
            // 除了final method
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib!";
            }
        });

        SampleClass proxy = (SampleClass) enhancer.create();
//        System.out.println("Hello cglib!"+ proxy.test(null));
        // 返回值类型不匹配 ：java.lang.String cannot be cast to java.lang.Number
//        System.out.println("Hello cglib!"+ proxy.test1(null));

        // 产生一个代理类的class对象
//        Class clazz = enhancer.createClass();
//        SampleClass proxy1 = (SampleClass) clazz.newInstance();
//        System.out.println("Hello cglib!"+ proxy.test(null));
    }
}
