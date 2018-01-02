package com.hope.learn.base.reference;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertSame;

/**
 * Created by hope on 2018/1/2.
 * StrongReference 是 Java 的默认引用实现,
 * 它会尽可能长时间的存活于 JVM 内,当没有任何对象指向它时 GC 执行后将会被回收
 */
public class StrongReference {

    @Test
    public void strongReferenceTest(){
        Object referent = new Object();

        /**
         * 通过赋值创建 StrongReference
         */
        Object strongReference = referent;

        assertSame(referent, strongReference);

        referent = null;
        System.gc();

        /**
         * StrongReference 在 GC 后不会被回收
         */
        assertNotNull(strongReference);
    }

}
