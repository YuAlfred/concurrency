package com.ty.concurrency.example.atomic;

import com.ty.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/7/13 9:17 下午
 * @description :
 * @modified By  :
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    public static AtomicIntegerFieldUpdater<AtomicExample5> updater =
        AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success, {}", example5.getCount());
        }
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success, {}", example5.getCount());
        } else {
            log.info("update failed, {}", example5.getCount());
        }
    }

}
