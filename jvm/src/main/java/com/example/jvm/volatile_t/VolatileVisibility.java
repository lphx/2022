package com.example.jvm.volatile_t;

/**
 * @ClassName: VolatileVisibility
 * @Author: lph
 * @Description:
 * @Date: 2022/2/13 22:11
 */
public class VolatileVisibility {

    public static volatile int i =0;
    public static void increase(){
        i++;
    }

    public static void main(String[] args) {

        System.out.println(i);
        for (int j = 1; j <= 5000; j++) {
            new Thread(VolatileVisibility::increase).start();
        }
        System.out.println(i);

    }

}
