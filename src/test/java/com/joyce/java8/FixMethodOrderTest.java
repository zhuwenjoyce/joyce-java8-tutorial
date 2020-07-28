package com.joyce.java8;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.JVM)
public class FixMethodOrderTest {

    private static Logger logger = LoggerFactory.getLogger(FixMethodOrderTest.class);

    @Test
    public void test1() throws InterruptedException {
        logger.info("1");
        Thread.sleep(1000);
    }

    @Test
    public void test2() throws InterruptedException {
        logger.info("2");
        Thread.sleep(1000);
    }

    @Test
    public void test3() throws InterruptedException {
        logger.info("3");
        Thread.sleep(1000);
    }

}
