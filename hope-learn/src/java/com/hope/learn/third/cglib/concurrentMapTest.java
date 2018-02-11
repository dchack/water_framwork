package com.hope.learn.third.cglib;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by dongchao on 2018/2/11.
 */
public class concurrentMapTest {

    // 记录自旋状态的轻量级类，只封装了一个volatile状态
    public static class SpinStatus{
        volatile boolean released;
    }

    // 辅助并发控制的Map，用来找出每个key对应的第一个成功进入的线程
    private ConcurrentMap<String, SpinStatus> raceUtil = new ConcurrentHashMap<String, SpinStatus>();

    private ConcurrentMap<String, Object> map = new ConcurrentHashMap<String, Object>();

    public Object test(String key){
        Object value = map.get(key);
        // 第一次
        if(value == null){
            // 需要为并发的线程new一个自旋状态，只有第一个成功执行putIfAbsent方法的线程设置的SpinStatus会被共享
            SpinStatus spinStatus = new SpinStatus();
            SpinStatus oldSpinStatus = raceUtil.putIfAbsent(key, spinStatus);
            //只有第一个执行成功的线程拿到的oldSpinStatus是null，其他线程拿到的oldSpinStatus是第一个线程设置的，可以在所有线程中共享
            if(oldSpinStatus == null){
                value = create();
                // 放入共享的并发Map，后续线程执行get()方法后可以直接拿到非null的引用返回
                map.put(key, value);
                // 释放其他自旋的线程,注意，对第一个成功执行的线程使用的是spinStatus的引用
                spinStatus.released = true;
            }else{
                // 其他线程在oldSpinStatus引用所指向的共享自旋状态上自旋，等待被释放
                while(!oldSpinStatus.released){};
            }

            // 再次获取一下，这时候是肯定不为空
            value = map.get(key);
        }
        return value;
    }

    /**
     * 假装耗时代码
     * @return
     */
    public static String create(){
        return "1";
    }
}
