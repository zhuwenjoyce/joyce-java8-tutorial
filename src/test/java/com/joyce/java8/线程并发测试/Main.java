package com.joyce.java8.线程并发测试;

import com.joyce.java8.Demo10_DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    static int 总数 = 3;

    static CountDownLatch latch = new CountDownLatch(总数);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList();
        for (int i = 0; i < 总数; i++) {
            Thread t = new Thread(() -> {
                int sleepTime = new Random().nextInt(1000);
                new Main().execResultUtil(sleepTime);
            });
            list.add(t);
        }
        for (Thread t : list){
            t.start();
            latch.countDown();
        }
        Thread.sleep(10000);
    }

    public void execResultUtil(int sleepTime) {
        logger.info("1、"+Thread.currentThread().getName()+", sleepTime=" + sleepTime);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("2、"+Thread.currentThread().getName()+", sleepTime=" + sleepTime);
        ResultUtil r = ResultUtil.FAIL_COMMON.setObj(sleepTime);
        logger.info("3、"+Thread.currentThread().getName()+", sleepTime=" + r.getObj());
    }

}
