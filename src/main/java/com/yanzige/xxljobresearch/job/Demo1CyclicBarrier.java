package com.yanzige.xxljobresearch.job;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Demo1CyclicBarrier {
    public static void main(String[] args) {
        // 拦截线程的数量为5
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Athlete(cyclicBarrier, "运动员" + i));
            threadList.add(t);
        }
        for (Thread t : threadList) { // 通过遍历逐一启动线程
            t.start();
        }
    }
    static class Athlete implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private String name;
        public Athlete(CyclicBarrier cyclicBarrier, String name) {
                this.cyclicBarrier = cyclicBarrier;
                this.name = name;
        }
        @Override
        public void run() {
            System.out.println(name + "就位");
            try {
                // 每个线程调用await方法告诉CyclicBarrier已经到达屏障位置，线程被阻塞
                // 如果该线程不是到达的最后一个线程，则他会一直处于等待状态
                cyclicBarrier.await();
                // 一起开始做自己真实的业务 ...
                System.out.println(name + "跑到终点。");
            } catch (Exception e) {
            }
        }
    }
}