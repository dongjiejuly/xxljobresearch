package com.yanzige.xxljobresearch.job;

/**
 * @author liuxu29
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("讲道理这个最后打印，因为子线程调用了join操作：" + Thread.currentThread().getName());
        while (thread1.isAlive() || thread2.isAlive()) {
            //只要两个线程中有任何一个线程还在活动，主线程就不会往下执行
            System.out.println("讲道理这个最后打印，因为子线程调用了join操作：" + Thread.currentThread().getName());
        }
    }
}
