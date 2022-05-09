package com.example.douyin.paixu220509;

/**
 * @ClassName: ShellSort
 * @Author: lph
 * @Description:
 * @Date: 2022/5/9 23:56
 */
public class ShellSort {


    /**
     * 希尔排序
     * @param arr 进行排序的数组
     * @return 排好序的数组
     */
    public static int[] shellSort(int[] arr) {

        int temp = 0;
        //分成几个一组
        int group = arr.length / 2;
        while (group != 0) {
            for (int i = group; i < arr.length; i++) {
                //遍历每组中的元素，步长为group
                for (int j = i - group; j >= 0; j -= group) {
                    //采用交换法
                    if (arr[j] > arr[j + group]) {
                        temp = arr[j];
                        arr[j] = arr[j + group];
                        arr[j + group] = temp;
                    }
                }
            }
            //进行下一次分组
            group = group / 2;

        }
        return arr;
    }

}
