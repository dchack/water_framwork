package com.hope.learn.patterns.proxy;

/**
 * Created by hope on 17/2/24.
 */
public class TestProxy {
    public static void main(String[] args) {
        Subject subjectProxy = new SubjectProxy();
        // 使用代理类访问实际执行类
        subjectProxy.toilet();
    }
}
