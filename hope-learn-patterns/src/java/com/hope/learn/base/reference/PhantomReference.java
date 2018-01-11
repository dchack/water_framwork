package com.hope.learn.base.reference;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import static junit.framework.TestCase.*;

/**
 * Created by hope on 2018/1/2.
 * 最关键的来了， Phantom Reference(幽灵引用) 与 WeakReference 和 SoftReference 有很大的不同,
 * 因为它的 get() 方法永远返回 null, 这也正是它名字的由来
 */
public class PhantomReference {

    /**
     * 请注意构造 PhantomReference 时的第二个参数 ReferenceQueue(事实上 WeakReference & SoftReference 也可以有这个参数)，
     PhantomReference 唯一的用处就是跟踪 referent 何时被 enqueue 到 ReferenceQueue 中.
     */
    @Test
    public void phantomReferenceTest(){
        Object referent = new Object();
        java.lang.ref.PhantomReference<Object> phantomReference = new java.lang.ref.PhantomReference<Object>(referent, new ReferenceQueue<Object>());

        /**
         * phantom reference 的 get 方法永远返回 null
         */
        assertNull(phantomReference.get());
    }


    /**
     * 当一个 WeakReference 开始返回 null 时， 它所指向的对象已经准备被回收，
     * 这时可以做一些合适的清理工作. 将一个 ReferenceQueue 传给一个 Reference 的构造函数，
     * 当对象被回收时， 虚拟机会自动将这个对象插入到 ReferenceQueue 中，
     * WeakHashMap 就是利用 ReferenceQueue 来清除 key 已经没有强引用的 entries.
     * @throws InterruptedException
     */
    @Test
    public void referenceQueue() throws InterruptedException {
        Object referent = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        java.lang.ref.WeakReference<Object> weakReference = new java.lang.ref.WeakReference<Object>(referent, referenceQueue);

        assertFalse(weakReference.isEnqueued());
        Reference<? extends Object> polled = referenceQueue.poll();
        assertNull(polled);

        referent = null;
        System.gc();

        assertTrue(weakReference.isEnqueued());
        Reference<? extends Object> removed = referenceQueue.remove();
        assertNotNull(removed);
    }


}
