package com.example.mock.controller;

import com.example.mock.MockDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: MockController
 * @Author: lph
 * @Description:
 * @Date: 2022/8/3 22:18
 */
@RestController
public class MockController {

    public static List<Object> list = new ArrayList<>();

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    @GetMapping("/oom")
    public String oom(Integer length,Integer arrSize){
        for (int i = 0; i < arrSize; i++) {
            list.add(new MockDemo(length));
        }

        return "ok";
    }


    @GetMapping("/lock")
    public String lock(){
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    System.out.println("thread1 begin");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                synchronized (lock2) {
                    System.out.println("thread1 end");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                try {
                    System.out.println("thread2 begin");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                synchronized (lock1) {
                    System.out.println("thread2 end");
                }
            }
        }).start();

        System.out.println("main thread end");

        return "ok";
    }

    @GetMapping("/cpu")
    public String cpu(Integer arrSize){
        for (int i = 0; i < arrSize; i++) {
            compute();
        }

        return "ok";
    }

    public int compute() {  //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }


    @RequestMapping("/jvm")
    public String processUserData(Integer length) {
        MockDemo mockDemo = new MockDemo(length);
        System.out.println("mockDemo:" + mockDemo.toString());

        return "end";
    }



}
