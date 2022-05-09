package com.example.douyin.paixu220509;

/**
 * @ClassName: DubbleSort
 * @Author: lph
 * @Description:
 * @Date: 2022/5/9 23:52
 */
public class DubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4};
        bubbleSort(arr);
    }

    /**
     * 冒泡排序
     * @param arr 进行排序的数组
     * @return 排好序的数组
     */
    public static int[] bubbleSort(int[] arr) {
        int temp = 0;
        int count = 0;

        for (int i =  arr.length-1; i > 0; i--) {
            count = 0;
            //每次循环都遍历出了一个最大的放在数组的后面
            for (int j = 0; j < i ; j++) {
                //如果比后一个元素大则进行交换
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //记录进行交换的次数
                    count++;
                }
            }
            //说明已经有序了 无须在排
            if (count == 0) {
                return arr;
            }

        }
        return arr;
    }


}
