package com.hope.learn.base.reference;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by hope on 2018/1/2.
 * SoftReference 于 WeakReference 的特性基本一致，
 * 最大的区别在于 SoftReference 会尽可能长的保留引用直到 JVM 内存不足时才会被回收(虚拟机保证),
 * 这一特性使得 SoftReference 非常适合缓存应用
 */
public class SoftReference {

    @Test
    public void softReferenceTest(){
        Object referent = new Object();
        java.lang.ref.SoftReference<Object> softReference = new java.lang.ref.SoftReference<Object>(referent);

        assertNotNull(softReference.get());

        referent = null;
        System.gc();

        /**
         *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用
         */
        assertNotNull(softReference.get());
    }
}
