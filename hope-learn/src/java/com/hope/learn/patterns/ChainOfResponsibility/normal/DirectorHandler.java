package com.hope.learn.patterns.ChainOfResponsibility.normal;

/**
 * Created by dongchao on 2018/3/10.
 */
public class DirectorHandler extends Handler{
    @Override
    public void handleRequest(int n) {
        System.out.println("Director 处理");
    }
}
