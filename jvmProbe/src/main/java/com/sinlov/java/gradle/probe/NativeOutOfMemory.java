package com.sinlov.java.gradle.probe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 17/10/19.
 */
public class NativeOutOfMemory {

    private static final String string = "Thread OOM count => ";
    private static final AtomicInteger count = new AtomicInteger();

    public static void threadOOM() {
        try {
            for (int i = 0; ; i++) {
                System.out.println(string + i);
                new Thread(new HoldThread()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void maxThreadCount() {
        while (true)
            (new CountThread()).start();


    }

    static class HoldThread extends Thread {
        CountDownLatch cdl = new CountDownLatch(1);

        public HoldThread() {
            this.setDaemon(true);
        }

        public void run() {
            try {
                cdl.await();
            } catch (InterruptedException e) {

            }
        }
    }

    static class CountThread extends Thread {
        @Override
        public void run() {
            System.out.println(count.incrementAndGet());
            while (true)
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {

                    break;
                }
        }
    }
}
