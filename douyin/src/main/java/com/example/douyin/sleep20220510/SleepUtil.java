package com.example.douyin.sleep20220510;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: SleepUtil
 * @Author: lph
 * @Description:
 * @Date: 2022/5/11 10:18
 */
public class SleepUtil {

    public static void main(String[] args) {
        //排序并返回数组
        int[] nums = {1, 2, 25, 4, 30};
        Arrays.stream(sleepSort(nums)).forEach(System.out::println);
    }


    /**
     * 多线程睡眠排序大法
     * @param nums
     * @return
     */
    public static int[] sleepSort(int[] nums){
        int[] newNums = new int[nums.length];
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(nums.length);
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            new Thread(()->{

                try {
                    Thread.sleep(num);
                    newNums[atomicInteger.get()] = num;
                    atomicInteger.incrementAndGet();//相当于++
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
