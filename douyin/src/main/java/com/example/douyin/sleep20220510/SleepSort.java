package com.example.douyin.sleep20220510;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: SleepSort
 * @Author: lph
 * @Description:
 * @Date: 2022/5/10 23:07
 */
public class SleepSort {


    public static void main(String[] args) {
        int[] nums = {1, 2, 25, 4, 30};
        Arrays.stream(sleepSort(nums)).forEach(System.out::println);
    }

    /**
     * 多线程同时睡眠排序大法
     * @param nums
     */
    public static int[] sleepSort(int[] nums){
        AtomicInteger count =new AtomicInteger(0);
        int[] newNums = new int[nums.length];
        CountDownLatch countDownLatch = new CountDownLatch(nums.length);
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            new Thread(()->{
                try {
                    Thread.sleep(num);
                    newNums[count.get()] = num;
                    count.getAndIncrement();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return newNums;
    }
}
