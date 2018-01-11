package com.hope.learn.base.reference;

import org.junit.Test;

import java.util.Map;
import java.util.WeakHashMap;

import static junit.framework.TestCase.*;

/**
 * Created by hope on 2018/1/2.
 * WeakReference， 顾名思义, 是一个弱引用,
 * 当所引用的对象在 JVM 内不再有强引用时, GC 后 weak reference 将会被自动回收
 */
public class WeakReference {

    @Test
    public void WeakReferenceTest(){
        Object referent = new Object();
        java.lang.ref.WeakReference<Object> weakReference = new java.lang.ref.WeakReference<Object>(referent);

        assertSame(referent, weakReference.get());

        referent = null;
        System.gc();

        /**
         * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
         */
        assertNull(weakReference.get());
    }

    /**
     * WeakHashMap 使用 WeakReference 作为 key，
     * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
     */
    @Test
    public void WeakHashMapTest() throws InterruptedException {
        Map<Object, Object> weakHashMap = new WeakHashMap<Object, Object>();
        Object key = new Object();
        Object value = new Object();
        weakHashMap.put(key, value);

        assertTrue(weakHashMap.containsValue(value));

        key = null;
        System.gc();

        /**
         * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理
         */
        Thread.sleep(1000);

        weakHashMap.get("1");
        /**
         * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
         */
        assertFalse(weakHashMap.containsValue(value));
    }


}
