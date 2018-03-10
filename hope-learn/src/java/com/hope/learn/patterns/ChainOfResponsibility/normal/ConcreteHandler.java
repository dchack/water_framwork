package com.hope.learn.patterns.ChainOfResponsibility.normal;

/**
 * Created by hope on 2017/12/22.
 */
public class ConcreteHandler extends Handler {
    /**
     * 处理方法，调用此方法处理请求
     */
    @Override
    public void handleRequest(int n) {

        if(n>1000){
            /**
             * 判断是否有后继的责任对象
             * 如果有，就转发请求给后继的责任对象
             * 如果没有，则处理请求
             */
            if(getSuccessor() != null)
            {
                System.out.println("提交上级处理");
                getSuccessor().handleRequest(n);
            }else
            {
                System.out.println("上级不在 无法处理");
            }
        }else{
            System.out.println("处理请求");
        }

    }

}
