package com.ty.concurrency.example.atomic;

import com.ty.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/7/13 9:17 下午
 * @description :
 * @modified By  :
 */
@Slf4j
@ThreadSafe
public class AtomicExample2 {

    /**
     * 0;
     * 请求并发数
     */
    public static int clientTotal = 5000;

    /**
     * 并发线程数
     */
    public static int threadTotal = 200;

    //计数
    public static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);

    }

    private static void add() {
        count.incrementAndGet();
        // count.getAndIncrement()
    }

}
